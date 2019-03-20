/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import FC.*;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

   


public class Controlleur {

    private VueConnect co;
    private CréerUnDMR crDMR;
    private CréerUnExamen crExam;
    private PH_DossierPatient phDossPat;
    private PH_Examen phExam;
    private PH_RechercherPatient phRechPat;
    private AjouterImage ajoutImg;
    private CR compteR;
    private VuePrincipale vuePrin;
    private Parametres para;
    private RequetesBD req;
    private Professionnel pro;
    private AccueilPH menuP;
    
    Services CHU;
    Service s;
    Aile ai;
    Patient PATIENTSELECTIONNE;
    Examen SELECTEDEXAMEN;
    
    public Controlleur() throws ClassNotFoundException, SQLException { // certains constructeurs des interfaces auront des parametres genre un parametre "patient" qui permet de charger les données du patient pour ensuite l'afficher
        // connexion à la BD
        req= new RequetesBD();
        CHU = req.CreerListeServices();
        
        // chargelent des interfaces
        menuP = new AccueilPH();
        co = new VueConnect();
        crDMR = new CréerUnDMR();
        crExam = new CréerUnExamen();
        phDossPat = new PH_DossierPatient();
        phExam = new PH_Examen();
        phRechPat = new PH_RechercherPatient(this.CHU,this.req);
        compteR = new CR();
        vuePrin = new VuePrincipale();
        para = new Parametres(); 
        ajoutImg = new AjouterImage();
        vuePrin.newFrame(co);

        //////// BOUTONS PAGE DE CONNEXION /////////
        co.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pro = req.Identification(co.getTextIdentifiant(), co.getTextMDP());
                if(pro.getId()==0){
                    JOptionPane.showMessageDialog(co, "Identifiants incorrect", "Erreur", JOptionPane.WARNING_MESSAGE);
                    System.out.println("Mauvais mdp");
                }
                else{
                    phRechPat.ActualiserInformationsProfessionnel(pro);
                     changerMenu(menuP);
                }
            }
        });
        
        co.getMdp().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    pro = req.Identification(co.getTextIdentifiant(), co.getTextMDP());
                    if(pro.getId()==0){
                        JOptionPane.showMessageDialog(co, "Identifiants incorrect", "Erreur", JOptionPane.WARNING_MESSAGE);
                        System.out.println("Mauvais mdp");
                    }
                    else{
                        System.out.println("IDENTIFIANTS RECONNUS DANS LA BD");
                        menuP.ActualiserInformationsProfessionnel(pro);
                        changerMenu(menuP);
                    }
                }   
            }
            public void keyReleased(KeyEvent e) {
            }
        });

        
        co.getIdent().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {  
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                pro = req.Identification(co.getTextIdentifiant(), co.getTextMDP());
                if(pro.getId()==0){
                    JOptionPane.showMessageDialog(co, "Identifiants incorrect", "Erreur", JOptionPane.WARNING_MESSAGE);
                    System.out.println("Mauvais mdp");
                }
                else{
                    System.out.println("IDENTIFIANTS RECONNUS DANS LA BD");
                    menuP.ActualiserInformationsProfessionnel(pro);
                    changerMenu(menuP);
                }
            }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
       
        //Boutons page d'accueil
        menuP.getButtonDeco2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(co);
            }
        });
        
        menuP.getButtonGerer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phRechPat.ActualiserInformationsProfessionnel(pro);
                changerMenu(phRechPat);
            }
        });
        
        menuP.getButtonPara().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                vuePrin.newWindow(para);
            }
        });
        
        menuP.getButtonCrDmr().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crDMR.ActualiserInformationsProfessionnel(pro);
                vuePrin.newWindow(crDMR);
            }
        });
        
        
        //////// BOUTONS PAGE DE RECHERCHE DE PATIENTS /////////
        phRechPat.getButtonInfos().addActionListener(new ActionListener() { // recuperer infos des autres champs pour trouver le bon dossier patient ?
            @Override
            public void actionPerformed(ActionEvent e) {
               int id = Integer.parseInt(phRechPat.getTextFieldId().getText());
               PATIENTSELECTIONNE = req.ChargementPatient(id);
               try{
                    phDossPat.ActualiserInfosPatient(CHU, PATIENTSELECTIONNE); // maj de la page suivante
                    phDossPat.ActualiserInfosPro(pro);
                    changerMenu(phDossPat); // mettre un patient en argument ? ou avant creer meethode setpat dans phdosspat
                } catch(NullPointerException npe){
                    Component frame = null;
                    JOptionPane.showMessageDialog(frame,"L'ID rentré n'est pas dans la base de donnée","Inane warning",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        phRechPat.getButtonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(menuP);
            }
        });

        phRechPat.getButtonService().addActionListener(new ActionListener() {// recuperer infos des autres champs pour trouver le bon dossier patient ?
            @Override
            public void actionPerformed(ActionEvent e) {
                String valpat = String.valueOf(phRechPat.getComboBoxPatients().getSelectedItem());
                int id = req.getIntNomPrenomIdPatient(valpat);
                System.out.println("id récupéré :"+id);
                System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////");
                PATIENTSELECTIONNE = req.ChargementPatient(id);
                phDossPat.ActualiserInfosPatient(CHU, PATIENTSELECTIONNE); // maj de la page suivante
                phDossPat.ActualiserInfosPro(pro);
                changerMenu(phDossPat); // mettre un patient en argument ? ou avant creer meethode setpat dans phdosspat
            }
        });
        
        phRechPat.getButtonDeco().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(co);
            }
        });

        phRechPat.getButtonPara().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                vuePrin.newWindow(para);
            }
        });
        
        //////// BOUTONS DOSSIER PATIENT /////////
        phDossPat.getButtonCreerExamen().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                crExam.ActualiserInfos(pro,PATIENTSELECTIONNE);
                vuePrin.newWindow(crExam);
            }
        });
        
        phDossPat.getButtonVal().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                vuePrin.newWindow(phExam);
            }
        });
        
        phDossPat.getButtonPara().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vuePrin.newWindow(para);
            }
        });
        
        phDossPat.getButtonDeco().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(co);
            }
        });

        phDossPat.getTableExamens().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 2) {
                    int ligne = phDossPat.getTableExamens().getSelectedRow();
                    
                    int a = (int)phDossPat.getTableExamens().getValueAt(ligne, 0);
                    //System.out.println("\n\n\n\n\n\n\nID :"+a);
                    SELECTEDEXAMEN = PATIENTSELECTIONNE.getDMR().GetExamenDMR(a);
                    phExam.actualiserInfos(CHU,SELECTEDEXAMEN);
                    vuePrin.changerWindow(phExam);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        phDossPat.getButtonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(phRechPat);
            }
        });
        
        phDossPat.getButtoncocher().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                phDossPat.ActualiserDMRPatient(CHU, PATIENTSELECTIONNE);
            }
        });
      
        ///////////// BOUTONS AFFICHAGE EXAMEN
        phExam.getListeImages().addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {             
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() >= 2) {
                    String ligne =phExam.getListeImages().getSelectedValue();
                    System.out.println(ligne);
                    Imagepacs SELECTEDIMG = SELECTEDEXAMEN.getLISTEIMAGES().getImage(ligne);
                    SELECTEDIMG.InformationsImage();
                    AfficheImage frame = new AfficheImage(SELECTEDIMG);
                    frame.setVisible(true);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        phExam.getButtonEditerCr().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               compteR.ActualiserInfos(CHU, pro, PATIENTSELECTIONNE, SELECTEDEXAMEN);                    
               vuePrin.newWindow(compteR);
            }
        });
        
        phExam.getButtonAddImage().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ajoutImg.actualiserInfosPage(CHU,PATIENTSELECTIONNE,SELECTEDEXAMEN);              
                vuePrin.newWindow(ajoutImg);
            }
           
        });
        
        //////////////// BOUTON AJOUTER IMAGE ///////////////////
        ajoutImg.getButtonCharger().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileOuvrirImage = new JFileChooser();           
                if (fileOuvrirImage.showOpenDialog(phExam) == JFileChooser.APPROVE_OPTION) {
                    ajoutImg.setCheminImage(fileOuvrirImage.getSelectedFile().getAbsolutePath());
                    ajoutImg.setTextChemin(ajoutImg.getCheminImage());
                }
            }
        });
        
        ajoutImg.getButtonValider().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!ajoutImg.getChampsNom().getText().equals("")){
                    if(!ajoutImg.getCheminImage().equals("")){
                        System.out.println("blabla");
                        int id = req.getMaxIdImg()+1;
                        System.out.println("id :"+id);
                         Imagepacs ImageAAjouter = new Imagepacs(id,PATIENTSELECTIONNE.getid(),SELECTEDEXAMEN.getIdExamen(),ajoutImg.getChampsNom().getText());
                         SELECTEDEXAMEN.getLISTEIMAGES().AjouterImage(ImageAAjouter); //ajouter img en local
                         phExam.actualiserInfos(CHU, SELECTEDEXAMEN);
                         req.ecrirePACS(ImageAAjouter, ajoutImg.getCheminImage());
                         JOptionPane.showMessageDialog(ajoutImg, "L'image a bien été rajouté", "Information", JOptionPane.INFORMATION_MESSAGE);
                         ///// JE SAIS PLUS COMMENT ON QUITTE LA FENETRE
                         ajoutImg.setVisible(false);
                    }
                    else{
                        System.out.println("ERREUR image non selectionne");
                    } 
                }
                else{
                    JOptionPane.showMessageDialog(ajoutImg, "Veuillez remplir tous les champs", "Erreur", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        ///////////// BOUTON COMPTE RENDU///////////////////////////
        compteR.getValiderButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               if(compteR.getTextCR().getText().equals("")){
                   SELECTEDEXAMEN.getCr().setEtat(EtatCr.nonecrit);
                    phExam.actualiserInfos(CHU, SELECTEDEXAMEN);
                    // actualiserle cr dans la BD
                    req.ModifierCR(SELECTEDEXAMEN);
                    // QUITTER FENETRE
                    JOptionPane.showMessageDialog(compteR, "Le compte rendu a bien été modifié", "Information", JOptionPane.INFORMATION_MESSAGE);
                    compteR.setVisible(false);/////////////////////// AUTRE MOYEN AVEC CNTROLEUR AYAYAYAY
               }
               else{
                   SELECTEDEXAMEN.getCr().setEtat(EtatCr.validé);
                   SELECTEDEXAMEN.getCr().setTexte(compteR.getTextCR().getText());
                   phExam.actualiserInfos(CHU, SELECTEDEXAMEN);
                   // modifier le cr dans la BD
                   req.ModifierCR(SELECTEDEXAMEN);
                   JOptionPane.showMessageDialog(compteR, "Le compte rendu a bien été modifié", "Information", JOptionPane.INFORMATION_MESSAGE);
                    compteR.setVisible(false);/////////////////////// AUTRE MOYEN AVEC CNTROLEUR AYAYAYAY   
               }
            }
        });

        //////// BOUTONS CREER NOUVEL EXAMEN /////////
        crExam.RemplirComboServices(CHU);
        crExam.RemplirComboAiles(CHU);
        crExam.getComboServices().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               crExam.RemplirComboAiles(CHU);
            }
        });
        
        crExam.getButtonAjout().addActionListener(new ActionListener() { // c'est pas mieux d'ouvrir une nouvelle fenetre et de la rendre visible ? C'est possible d'avoir 2 fenetres ouvertes ? ca sera necessaire pour le bouton parametre
            @Override
            public void actionPerformed(ActionEvent e) {
                crExam.ajouterExamen(CHU,pro,PATIENTSELECTIONNE,req);
                crExam.ResetChamps();
                int max = PATIENTSELECTIONNE.getDMR().getIdMax();
                SELECTEDEXAMEN = PATIENTSELECTIONNE.getDMR().GetExamenDMR(max);
                phExam.actualiserInfos(CHU,SELECTEDEXAMEN);
                vuePrin.changerWindow(phExam);
            }
        });
        
/////////////////// BOUTON PARTIE INTERFACE IMAGE

        ///////////// BOUTON PARAMETRES ///////////
        para.getButtonAnnul().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                para.ResetChamps();
                vuePrin.changerWindow(phRechPat);
            }
        });
        
        para.getButtonVal().addActionListener(new ActionListener() { // c'est pas mieux d'ouvrir une nouvelle fenetre et de la rendre visible ? C'est possible d'avoir 2 fenetres ouvertes ? ca sera necessaire pour le bouton parametre
            @Override
            public void actionPerformed(ActionEvent e) {
                if(para.ChangementMDP(pro, req)){
                    para.ResetChamps();
                    vuePrin.changerWindow(phRechPat);
                } 
            }
        });
        
        //////// BOUTONS PAGE DE CREATION DMR /////////
        crDMR.getButtonCreerDmr().addActionListener(new ActionListener() { // c'est pas mieux d'ouvrir une nouvelle fenetre et de la rendre visible ? C'est possible d'avoir 2 fenetres ouvertes ? ca sera necessaire pour le bouton parametre
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(phDossPat);
            }
        });
        
        
        

    }

    public void changerMenu(JFrame vueApres) {
        vuePrin.newFrame(vueApres);

    }

}
