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

   

// classe qui permet de gérer le changement d'interfaces
public class Controlleur {

    private VueConnect co; // page connexion
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
    private AperçuAvantImpression Aperçu;
    
    // attributs qui changeront en fonction du choix de l'utilisateur
    Services CHU;
    Service s;
    Aile ai;
    Patient PATIENTSELECTIONNE;
    Examen SELECTEDEXAMEN;
    Imagepacs SELECTEDIMG;
    AfficheImage frame;
    
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
        Aperçu = new AperçuAvantImpression();
        
        vuePrin.newFrame(co);

        //////// BOUTONS PAGE DE CONNEXION /////////
        
        // si on clique sur le bouton connexion
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
                    co.resetChamps();
                     changerMenu(menuP);
                }
            }
        });
        
       // si on appuie sur le bouton entré en étant focus sur le bouton mdp
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
                        co.resetChamps();
                    }
                }   
            }
            public void keyReleased(KeyEvent e) {
            }
        });

        // si on appuie sur le bouton entré en étant focus sur le bouton connexion
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
                    co.resetChamps();
                }
            }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
       
       //////////Boutons page d'accueil
        
       // si on se déconnecte
        menuP.getButtonDeco2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                changerMenu(co);
            }
        });
        
        // si on clique sur le bouton gérer dmr
        menuP.getButtonGerer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phRechPat.ActualiserInformationsProfessionnel(pro);
                changerMenu(phRechPat);
            }
        });
        
        // si on clique sur le bouton parametres
        menuP.getButtonPara().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //vuePrin.newWindow(para);
            }
        });
        
        // si on clique sur le bouton créerdmr
        menuP.getButtonCrDmr().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //crDMR.ActualiserInformationsProfessionnel(pro);
                vuePrin.newWindow(crDMR);
            }
        });
        
        
        
        
        
        //////// BOUTONS PAGE DE RECHERCHE DE PATIENTS /////////
        
        // si on clique sur le bouton recherche par id
        phRechPat.getButtonInfos().addActionListener(new ActionListener() { // recuperer infos des autres champs pour trouver le bon dossier patient ?
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if((!phRechPat.getTextFieldId().getText().equals(""))){
                    try{
               int id = Integer.parseInt(phRechPat.getTextFieldId().getText());
                    
               
               PATIENTSELECTIONNE = req.ChargementPatient(id);
               try{
                    phDossPat.ActualiserInfosPatient(CHU, PATIENTSELECTIONNE); // maj de la page suivante
                    phDossPat.ActualiserInfosPro(pro);
                    phDossPat.SetAffichageDroits(pro.getProfession()); // affiche la page en fonction des droits
                    changerMenu(phDossPat); // mettre un patient en argument ? ou avant creer meethode setpat dans phdosspat
                } catch(NullPointerException npe){
                    Component frame = null;
                    JOptionPane.showMessageDialog(frame,"L'ID rentré n'est pas dans la base de donnée","Inane warning",JOptionPane.WARNING_MESSAGE);
                }
               }catch(java.lang.NumberFormatException ex){
                        Component frame = null;
                    JOptionPane.showMessageDialog(frame,"Erreur vous n'avez pas entré un id valide","Inane warning",JOptionPane.WARNING_MESSAGE);
                
                    }
               
               
            }
                else{
                        Component frame = null;
                     JOptionPane.showMessageDialog(frame,"Vous devez entrer un id","Inane warning",JOptionPane.WARNING_MESSAGE);
                
                }
        }
        });
        
        // si on clique sur le bouton retour
        phRechPat.getButtonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(menuP);
            }
        });

        // si on clique sur le bouton recherche par service
        phRechPat.getButtonService().addActionListener(new ActionListener() {// recuperer infos des autres champs pour trouver le bon dossier patient ?
            @Override
            public void actionPerformed(ActionEvent e) {
                if(phRechPat.getComboBoxPatients().getItemCount()>0){
                String valpat = String.valueOf(phRechPat.getComboBoxPatients().getSelectedItem());
                int id = req.getIntNomPrenomIdPatient(valpat);
                System.out.println("id récupéré :"+id);
                System.out.println("//////////////////////////////////////////////////////////////////////////////////////////////////////////");
                PATIENTSELECTIONNE = req.ChargementPatient(id);
                phDossPat.ActualiserInfosPatient(CHU, PATIENTSELECTIONNE); // maj de la page suivante
                phDossPat.ActualiserInfosPro(pro);
                phDossPat.SetAffichageDroits(pro.getProfession()); // on affiche ou pas des boutons selon la profession
                changerMenu(phDossPat); // mettre un patient en argument ? ou avant creer meethode setpat dans phdosspat
            }
                else{
                 Component frame = null;
                 JOptionPane.showMessageDialog(frame,"Il n'y a pas de patient selectionné","Inane warning",JOptionPane.WARNING_MESSAGE);
                
                }}
        });
        
        // si on se déconnecte
        phRechPat.getButtonDeco().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(co);
            }
        });

         // si on affiche les paramètres
        phRechPat.getButtonPara().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                vuePrin.newWindow(para);
            }
        });
        
        //////// BOUTONS DOSSIER PATIENT /////////
        // si on clique sur le bouton créer examen
        phDossPat.getButtonCreerExamen().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                crExam.ActualiserInfos(pro,PATIENTSELECTIONNE);
                vuePrin.newWindow(crExam);
            }
        });
        
        // si on valide après avoir cliqué 
        phDossPat.getButtonVal().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                if(phDossPat.getTableExamens().getSelectedRowCount()==1){
                int ligne = phDossPat.getTableExamens().getSelectedRow();
                    
                    int a = (int)phDossPat.getTableExamens().getValueAt(ligne, 0);
                    //System.out.println("\n\n\n\n\n\n\nID :"+a);
                    SELECTEDEXAMEN = PATIENTSELECTIONNE.getDMR().GetExamenDMR(a);
                    phExam.actualiserInfos(CHU,SELECTEDEXAMEN);
                    phExam.setAffichageDroits(pro.getProfession());
                    changerMenu(phExam);
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Vous devez selectionner un examen","Inane warning",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        // accéder aux paramètres
        phDossPat.getButtonPara().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vuePrin.newWindow(para);
            }
        });
        
        // si on  se déconnecte
        phDossPat.getButtonDeco().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(co);
            }
        });

        // si on double clic sur le tableau
        phDossPat.getTableExamens().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!pro.getProfession().toString().equals("Secretaire")){
                if (e.getClickCount() >= 2) {
                    int ligne = phDossPat.getTableExamens().getSelectedRow();
                    
                    int a = (int)phDossPat.getTableExamens().getValueAt(ligne, 0);
                    //System.out.println("\n\n\n\n\n\n\nID :"+a);
                    SELECTEDEXAMEN = PATIENTSELECTIONNE.getDMR().GetExamenDMR(a);
                    phExam.actualiserInfos(CHU,SELECTEDEXAMEN);
                    phExam.setAffichageDroits(pro.getProfession());
                    changerMenu(phExam);
                }
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
        
        // si on clic sur le bouton retour
        phDossPat.getButtonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(phRechPat);
            }
        });
        
        // modifie la recherche pour afficher que les exams avec cr
        phDossPat.getButtoncocher().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                phDossPat.ActualiserDMRPatient(CHU, PATIENTSELECTIONNE);
            }
        });
        phDossPat.getChampsrecherche().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                 phDossPat.ActualiserDMRPatient(CHU, PATIENTSELECTIONNE);
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
                phDossPat.ActualiserDMRPatient(CHU, PATIENTSELECTIONNE);
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                 phDossPat.ActualiserDMRPatient(CHU, PATIENTSELECTIONNE);
            }
        });
      
        ///////////// BOUTONS AFFICHAGE EXAMEN//////////////////////
        // affiche l'image qu'on a double clic
        phExam.getListeImages().addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {             
            }
            
            

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() >= 2) {
                    
                    String ligne =phExam.getListeImages().getSelectedValue();
                    System.out.println(ligne);
                    System.out.println("nb images :"+SELECTEDEXAMEN.getLISTEIMAGES().getListeImages().size());
                    SELECTEDIMG = SELECTEDEXAMEN.getLISTEIMAGES().getImage(ligne);
                    SELECTEDIMG.InformationsImage();
                    
                    frame = new AfficheImage(SELECTEDIMG,SELECTEDEXAMEN,phExam,req);
                    
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
        
        
        phExam.getButtonModifier().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!(phExam.getListeImages().getSelectedIndex()==-1)){
                    String ligne =phExam.getListeImages().getSelectedValue();
                    System.out.println(ligne);
                    System.out.println("nb images :"+SELECTEDEXAMEN.getLISTEIMAGES().getListeImages().size());
                    SELECTEDIMG = SELECTEDEXAMEN.getLISTEIMAGES().getImage(ligne);
                    SELECTEDIMG.InformationsImage();
                    
                    frame = new AfficheImage(SELECTEDIMG,SELECTEDEXAMEN,phExam,req);
                    
                    frame.setVisible(true);
                }
                else{
                     JOptionPane.showMessageDialog(frame,"Vous devez selectionner une image pour la modifier","Inane warning",JOptionPane.WARNING_MESSAGE);
                
                }
            }
        });
        
        // permet de modifier le cr
        phExam.getButtonEditerCr().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               compteR.ActualiserInfos(CHU, pro, PATIENTSELECTIONNE, SELECTEDEXAMEN);                    
               vuePrin.newWindow(compteR);
            }
        });
        
        phExam.getButtonImprim().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              Aperçu.setExam(SELECTEDEXAMEN);
              Aperçu.remplirTextArea();
              vuePrin.newWindow(Aperçu);
            }
        });
        
        // permet d'ajouter une image a lexamen
        phExam.getButtonAddImage().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ajoutImg.actualiserInfosPage(CHU,PATIENTSELECTIONNE,SELECTEDEXAMEN);              
                vuePrin.newWindow(ajoutImg);
            }
           
        });
        
        phExam.getButtonEnregistrer().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ajoutImg.actualiserInfosPage(CHU,PATIENTSELECTIONNE,SELECTEDEXAMEN);              
                changerMenu(phDossPat);
            }
           
        });
        
        phExam.getButtonRetour().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(phDossPat);
            }
        });
        
        //////////////// BOUTON AJOUTER IMAGE ///////////////////
        // charge limage a partir du repertoire
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
        
        // valide ssi les infos sont correct
        ajoutImg.getButtonValider().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!ajoutImg.getChampsNom().getText().equals("")){
                    if(!ajoutImg.getCheminImage().equals("")){
                       
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
        // enregistre les infos du cr et met en type validé si cr fait
        compteR.getValiderButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               if(compteR.getTextCR().getText().equals("")){
                   SELECTEDEXAMEN.getCr().setEtat(EtatCr.nonecrit);
                   SELECTEDEXAMEN.getCr().setTexte(compteR.getTextCR().getText());
                    phExam.actualiserInfos(CHU, SELECTEDEXAMEN);
                    // actualiserle cr dans la BD
                    req.ModifierCR(SELECTEDEXAMEN);
                    // QUITTER FENETRE
                    JOptionPane.showMessageDialog(compteR, "Le compte rendu a bien été modifié", "Information", JOptionPane.INFORMATION_MESSAGE);
                    compteR.setVisible(false);/////////////////////// AUTRE MOYEN AVEC CNTROLEUR AYAYAYAY
               }
               else{
                   if(pro.getProfession().toString().equals("interne")){
                       SELECTEDEXAMEN.getCr().setEtat(EtatCr.attente);
                   }
                   else{ // si c'est le PH
                       SELECTEDEXAMEN.getCr().setEtat(EtatCr.validé);
                   }
                   
                   SELECTEDEXAMEN.getCr().setTexte(compteR.getTextCR().getText());
                   SELECTEDEXAMEN.getCr().setCreateur(pro);// ajoute le pro connecté en redacteur de cr
                   phExam.actualiserInfos(CHU, SELECTEDEXAMEN);
                   // modifier le cr dans la BD
                   req.ModifierCR(SELECTEDEXAMEN);
                   JOptionPane.showMessageDialog(compteR, "Le compte rendu a bien été modifié", "Information", JOptionPane.INFORMATION_MESSAGE);
                    compteR.setVisible(false);/////////////////////// AUTRE MOYEN AVEC CNTROLEUR AYAYAYAY   
               }
            }
        });
        
        // permet de revenir en arrière
        compteR.getButtonAnnul().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vuePrin.closeWindow();
            }
        });

        //////// BOUTONS CREER NOUVEL EXAMEN /////////
        // actualise une première fois els infos
        crExam.RemplirComboServices(CHU);
        crExam.RemplirComboAiles(CHU);
        // initialise les combos box en fonction de la combo box service
        crExam.getComboServices().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               crExam.RemplirComboAiles(CHU);
            }
        });
        
        // valide en local et en ligne lexam
        crExam.getButtonAjout().addActionListener(new ActionListener() { // c'est pas mieux d'ouvrir une nouvelle fenetre et de la rendre visible ? C'est possible d'avoir 2 fenetres ouvertes ? ca sera necessaire pour le bouton parametre
            @Override
            public void actionPerformed(ActionEvent e) {
                crExam.ajouterExamen(CHU,pro,PATIENTSELECTIONNE,req);
                crExam.ResetChamps();
                int max = PATIENTSELECTIONNE.getDMR().getIdMax();
                SELECTEDEXAMEN = PATIENTSELECTIONNE.getDMR().GetExamenDMR(max);
                phExam.actualiserInfos(CHU,SELECTEDEXAMEN);
                phDossPat.ActualiserInfosPatient(CHU, PATIENTSELECTIONNE);
                //Rendre la fenetre dosspat invisible
//phDossPat.setVisible(false);
                vuePrin.changerWindow(phExam);
            }
        });
        
        // revient en arrière
        crExam.getButtonAnnul().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vuePrin.closeWindow();
            }
        });
        
        
        
        
        
        
        
        

        ///////////// BOUTON PARAMETRES ///////////
        para.getButtonAnnul().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                para.ResetChamps();
                vuePrin.closeWindow();
            }
        });
        
        para.getButtonVal().addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                if(para.ChangementMDP(pro, req)){
                    para.ResetChamps();
                    vuePrin.closeWindow();
                } 
            }
        });
        
        //////// BOUTONS PAGE DE CREATION DMR /////////
        
        crDMR.RemplirComboServices(CHU);
        crDMR.RemplirComboAiles(CHU);
        
        crDMR.getComboServices().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               crDMR.RemplirComboAiles(CHU);
            }
        });
        
        crDMR.getButtonCreerDmr().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(crDMR.CréerDMR(CHU,req)==1){
                JOptionPane.showMessageDialog(crDMR, "Le patient a bien été crée", "Information", JOptionPane.INFORMATION_MESSAGE);
                crDMR.ResetChamps();
                vuePrin.closeWindow();             
                }
                else{
                 JOptionPane.showMessageDialog(crDMR, "Erreur données incorrect", "Erreur", JOptionPane.WARNING_MESSAGE);
    
                }
                
            }
        });
        
//        crDMR.getButtonDeco().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                changerMenu(co);
//            }
//        });
//        
//        crDMR.getButtonPara().addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                vuePrin.newWindow(para);
//            }
//        });
        
        
        
       // ajout dfes bulles d'aide :
       crExam.getjComboBox4().setToolTipText("Année");
       crExam.getjComboBox5().setToolTipText("Mois");
       crExam.getjComboBox6().setToolTipText("Jour");
       crExam.getjComboBox7().setToolTipText("Heure");
       crExam.getjComboBox8().setToolTipText("Minute");
       crExam.getjComboBox3().setToolTipText("Service");
       crExam.getjComboBox2().setToolTipText("Aile");
        
       crDMR.getjComboBox4().setToolTipText("Année");
       crDMR.getjComboBox5().setToolTipText("Mois");
       crDMR.getjComboBox6().setToolTipText("Jour");
       crDMR.getjComboBox7().setToolTipText("Aile");      
       crDMR.getjComboBox3().setToolTipText("Service");
       
       
       ajoutImg.getButtonValider().setToolTipText("Ajouter l'image au pacs");
        
       phDossPat.getButtonVal().setToolTipText("Afficher l'examen selectionné");
       
       phExam.getButtonAddImage().setToolTipText("Ajouter une image à l'examen");
       phExam.getButtonModifier().setToolTipText("Modifier un examen selectionné");
       phExam.getButtonEditerCr().setToolTipText("Modifier le compte rendu");
       
   
           
        
        
        
    }
    
  

    public void changerMenu(JFrame vueApres) {
        vuePrin.newFrame(vueApres);

    }
















       
}