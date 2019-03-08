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

    public Controlleur() { // certains constructeurs des interfaces auront des parametres genre un parametre "patient" qui permet de charger les données du patient pour ensuite l'afficher
        
        co = new VueConnect();
        crDMR = new CréerUnDMR();
        crExam = new CréerUnExamen();
        pageManip = new PageManipulateur1();
        phDossPat = new PH_DossierPatient();
        phExam = new PH_Examen();
        ph2 = new CréerUnExamen2();
        phRechPat = new PH_RechercherPatient();
        para = new Parametres();
        vuePrin = new VuePrincipale();
        para = new Parametres();

        vuePrin.newFrame(co);

        //Bouton page de connexion
        co.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(phRechPat);
            }
        });
        
        phRechPat.getButtonInfos().addActionListener(new ActionListener() { // recuperer infos des autres champs pour trouver le bon dossier patient ?
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(phDossPat);
            }
        });
        
        phRechPat.getButtonService().addActionListener(new ActionListener() {// recuperer infos des autres champs pour trouver le bon dossier patient ?
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(phDossPat);
            }
        });
        
        phRechPat.getButtonDeco().addActionListener(new ActionListener() {// recuperer infos des autres champs pour trouver le bon dossier patient ?
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(co);
            }
        });
        
        phRechPat.getButtonPara().addActionListener(new ActionListener() { // recuperer infos des autres champs pour trouver le bon dossier patient ?
            @Override
            public void actionPerformed(ActionEvent e) {
                vuePrin.newWindow(para);
            }
        });
        
        
        phDossPat.getButtonCreerExamen().addActionListener(new ActionListener() { // c'est pas mieux d'ouvrir une nouvelle fenetre et de la rendre visible ? C'est possible d'avoir 2 fenetres ouvertes ? ca sera necessaire pour le bouton parametre
            @Override
            public void actionPerformed(ActionEvent e) {
                vuePrin.newWindow(crExam);
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
        vuePrin.newFrame(vueApres);

    }
    // creer une méthode qui permet d'avoir 2 vues en meme temps ? cf creer examen ou parametres

}
