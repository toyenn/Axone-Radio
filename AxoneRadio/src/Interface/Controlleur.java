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
import javax.swing.JPanel;
import FC.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author natfo
 */
public class Controlleur {

    private VueConnect co;
    private CréerUnDMR crDMR;
    private CréerUnExamen crExam;
    private PageManipulateur1 pageManip;
    private PH_DossierPatient phDossPat;
    private PH_Examen phExam;
    private PH_RechercherPatient phRechPat;
    private CréerUnExamen2 ph2;
    private PageSecretaire pageSecr;
    private VuePrincipale vuePrin;
    private Parametres para;
    private JFrame vueAvant;
    
    
    private RequetesBD req;
    private Professionnel pro;
    Services CHU;
    Service s;
    Aile ai;
    Patient PATIENTSELECTIONNE;
    
    
    public Controlleur() throws ClassNotFoundException, SQLException { // certains constructeurs des interfaces auront des parametres genre un parametre "patient" qui permet de charger les données du patient pour ensuite l'afficher
        System.out.println("Connexion BD");
        req= new RequetesBD();
        CHU = req.CreerListeServices();
        System.out.println("test");
        co = new VueConnect();
        System.out.println("test 2");
        crDMR = new CréerUnDMR();
        crExam = new CréerUnExamen();
        pageManip = new PageManipulateur1();
        phDossPat = new PH_DossierPatient();
        phExam = new PH_Examen();
        System.out.println("test 7");
        ph2 = new CréerUnExamen2();
        System.out.println("test 8");
        phRechPat = new PH_RechercherPatient();
        para = new Parametres();
        vuePrin = new VuePrincipale();
        System.out.println("test 10");
        para = new Parametres();
        System.out.println("test 11");

        vuePrin.newFrame(co);

        //Bouton page de connexion
        co.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pro = req.Identification(co.getTextIdentifiant(), co.getTextMDP());
                if(pro.getId()==0){
                    JOptionPane.showMessageDialog(co, "Identifiants incorrect", "Erreur", JOptionPane.WARNING_MESSAGE);
                    System.out.println("Mauvais mdp");
                }
                else{
                    System.out.println("IDENTIFIANTS RECONNUS DANS LA BD");
                    
                    phRechPat.ActualiserInfos(pro,CHU);
                     changerMenu(phRechPat);
                }
               
            }
        });
        
        
        // bouton page de recherpatientph
        
        
        phRechPat.getButtonRechInfo().addActionListener(new ActionListener() { // recuperer infos des autres champs pour trouver le bon dossier patient ?
            @Override
            public void actionPerformed(ActionEvent e) {
               // changerMenu(phRechPat, phDossPat);
               changerMenu(phDossPat);
            }
        });
        phRechPat.getButtonRechServ().addActionListener(new ActionListener() {// recuperer infos des autres champs pour trouver le bon dossier patient ?
            @Override
            public void actionPerformed(ActionEvent e) {
                //changerMenu(phRechPat,phDossPat);
                changerMenu(phDossPat);
            }
        });
        
        
        
        
        phRechPat.getButtonDeco().addActionListener(new ActionListener() {// recuperer infos des autres champs pour trouver le bon dossier patient ?
            @Override
            public void actionPerformed(ActionEvent e) {
                //changerMenu(phDossPat, co);
                co.setTextIdentifiant("Identifiant");
                co.setTextMDP("mdp");
                changerMenu(co);
            }
        });
        
       
        phRechPat.getComboservice().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = String.valueOf(phRechPat.getComboservice().getSelectedItem());
                
                System.out.println("on a selectionné :"+a);
                s =CHU.getService(a);
                if(s==null){
                    s=CHU.getListeServices().firstElement();
                }
                //s.AfficherInformationsService();
               
                phRechPat.actualiserAile(s);
              
                
            }
        });
        
        phRechPat.getComboAile().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = String.valueOf(phRechPat.getComboAile().getSelectedItem());
                System.out.println("on a selectionné :"+b);
                ai = s.getAile(b);
                
                if(ai==null){
                    //ai=CHU.getListeServices().firstElement().getListeAiles().firstElement();
                     ai=s.getListeAiles().firstElement();
                }
//                //s.AfficherInformationsService();
               Patients lp = req.AfficherPatientsDansService(ai.getIdAile());
                phRechPat.actualiserPatients(lp);
              
                
            }
        });
        phRechPat.getButtonRechServ().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String c = String.valueOf(phRechPat.getComboPatients().getSelectedItem());
                System.out.println("on a selectionné :"+c);
                int idPatient=0;
                // problème pour récuperer que l'id  du patient
                
               
//                //s.AfficherInformationsService();
              
              PATIENTSELECTIONNE = req.RecherchePatient(idPatient); // pas très opti car retour dans BD.. à revoir
                
            }
        });
        
        
        
        
        
        
        
        
        // creer examen
        
        
        phDossPat.getButtonCreerExam().addActionListener(new ActionListener() { // c'est pas mieux d'ouvrir une nouvelle fenetre et de la rendre visible ? C'est possible d'avoir 2 fenetres ouvertes ? ca sera necessaire pour le bouton parametre
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(crExam);
                //changerMenu(phDossPat, crExam);
                //vuePrin.newFrame(crExam);
            }
        });
        
        phDossPat.getTableExamens().addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()>=2){
                int numcol = phDossPat.getTableExamens().getSelectedRow();
                System.out.println(numcol);
                // on change les menus avec les infos de l'examen en parametre
                changerMenu(phExam);
                //changerMenu(phDossPat, phExam);
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

    }

    public void changerMenu(JFrame vueApres) {
        vueAvant = vuePrin.getFrame();
        vuePrin.newFrame(vueApres);

    }
    // creer une méthode qui permet d'avoir 2 vues en meme temps ? cf creer examen ou parametres

}
