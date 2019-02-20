/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author natfo
 */
public class Controlleur {

    private Connect co;
    private CréerUnDMR crDMR;
    private CréerUnExamen crExam;
    private PageManipulateur1 pageManip;
    private PH_DossierPatient phDossPat;
    private PH_Examen phExam;
    private PH_RechercherPatient phRechPat;
    private PagePH2 ph2;
    private PageSecretaire pageSecr;
    private VuePrincipale vuePrin;
    private Parametres para;

    public Controlleur() {
        System.out.println("test");
        co = new Connect();
        System.out.println("test 2");
        crDMR = new CréerUnDMR();
        System.out.println("test 3");
        crExam = new CréerUnExamen();
        System.out.println("test 4");
        pageManip = new PageManipulateur1();
        System.out.println("test 5");
        phDossPat = new PH_DossierPatient();
        System.out.println("test 6");
        phExam = new PH_Examen();
        System.out.println("test 7");
        ph2 = new PagePH2();
        System.out.println("test 8");
        phRechPat = new PH_RechercherPatient();
        System.out.println("test 9");
        vuePrin = new VuePrincipale();
        System.out.println("test 10");

        vuePrin.newFrame(co);

        co.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changerMenu(co, phRechPat);
            }
        });

    }

    public void changerMenu(JFrame vueAvant, JFrame vueApres) {
        vuePrin.newFrame(vueApres);

    }

}
