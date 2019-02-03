/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import FC.* ;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;

public class AfficheImage extends JFrame implements ActionListener {

    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu fichierMenu = new JMenu();
    private final JMenuItem ouvrirMenu = new JMenuItem();

    private final JMenu filtreMenu = new JMenu();
    private final IHMImages panneau = new IHMImages();
    private final JMenuItem enregistrerMenu = new JMenuItem();

    private final JMenuItem inversionMenu = new JMenuItem();
    private final JMenuItem assombrirMenu = new JMenuItem();
    private final JMenuItem brillanceMenu = new JMenuItem();
    private final JMenuItem binarisationMenu = new JMenuItem();
    private final JMenuItem convolutionMenu = new JMenuItem();
    private final JMenu retaillerMenu = new JMenu();
    private final JMenuItem agrandirMenu = new JMenuItem();
    private final JMenuItem reduireMenu = new JMenuItem();
    private final JMenuItem rotationDroiteMenu = new JMenuItem();
    private final JMenuItem rotationGaucheMenu = new JMenuItem();
    private final JMenuItem writeInPacs = new JMenuItem();
    
    private final  JPanel barredoutils = new javax.swing.JPanel();
        private final JButton BoutonInverserColors = new javax.swing.JButton();
        private final JButton BoutonModifierLum = new javax.swing.JButton();
        private final JButton BoutonRotationDroite = new javax.swing.JButton();
        private final JButton BoutonRotationGauche = new javax.swing.JButton();
        
        private final JSlider SlideLumi = new javax.swing.JSlider();
        private final JSlider SlideContraste = new javax.swing.JSlider();
        
        private final JLabel texteSlideLumi = new javax.swing.JLabel("Luminosité");
        private final JLabel texteSlideContraste = new javax.swing.JLabel("Contraste");
    

    public AfficheImage() { // constructeur avec comme parametre lurl de limage
        super();
        //this.setLocationRelativeTo(null);
        setBounds(100, 100, 500, 375);
        //setBounds(100, 100, 800, 650);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        try {
            creerMenu();
            panneau.ajouterImage(new File("C:\\Users\\Nathan\\Pictures\\SIR\\essai.pgm"));
        } catch (Throwable e) {
            e.printStackTrace();
        }
        //
    }

    private void creerMenu() throws Exception {

        // construction du menu
        setJMenuBar(menuBar);
        menuBar.add(fichierMenu);
        fichierMenu.setText("Fichier");
        fichierMenu.add(ouvrirMenu);
        ouvrirMenu.addActionListener((ActionListener) this);
        ouvrirMenu.setText("ouvrir");

        fichierMenu.add(enregistrerMenu);
        enregistrerMenu.addActionListener((ActionListener) this);
        enregistrerMenu.setText("enregistrer");

        fichierMenu.add(writeInPacs);
        writeInPacs.addActionListener((ActionListener) this);
        writeInPacs.setText("ajouter au PACS");

        menuBar.add(filtreMenu);
        filtreMenu.setText("Filtre");

        filtreMenu.add(inversionMenu);
        inversionMenu.addActionListener((ActionListener) this);
        inversionMenu.setText("inversion niveau de gris");

        filtreMenu.add(binarisationMenu);
        binarisationMenu.addActionListener((ActionListener) this);
        binarisationMenu.setText("binarisation-contraste");

        filtreMenu.add(assombrirMenu);
        assombrirMenu.addActionListener((ActionListener) this);
        assombrirMenu.setText("assombrir");

        filtreMenu.add(brillanceMenu);
        brillanceMenu.addActionListener((ActionListener) this);
        brillanceMenu.setText("éclaircir");

        filtreMenu.add(convolutionMenu);
        convolutionMenu.addActionListener((ActionListener) this);
        convolutionMenu.setText("convolution-lumino");

        menuBar.add(retaillerMenu);
        retaillerMenu.setText("Retailler");

        retaillerMenu.add(agrandirMenu);
        agrandirMenu.addActionListener((ActionListener) this);
        agrandirMenu.setText("agrandir");

        retaillerMenu.add(reduireMenu);
        reduireMenu.addActionListener((ActionListener) this);
        reduireMenu.setText("reduire");

        retaillerMenu.add(rotationDroiteMenu);
        rotationDroiteMenu.addActionListener((ActionListener) this);
        rotationDroiteMenu.setText("rotation droite");

        retaillerMenu.add(rotationGaucheMenu);
        rotationGaucheMenu.addActionListener((ActionListener) this);
        rotationGaucheMenu.setText("rotation gauche");
        
        //BoutonModifierLum.addActionListener((ActionListener) this);
        
        
        

        // ajouter le panneau de dessin
       // getContentPane().add(panneau);
        
        
        
        
        
        
        getContentPane().add(panneau, BorderLayout.CENTER);
        // creation de la barre d'outils
        BoutonInverserColors.setText("/");
        BoutonInverserColors.setPreferredSize(new Dimension(45,45));
        BoutonInverserColors.addActionListener((ActionListener) this);
        //BoutonModifierLum.setText("Lumino");
       // BoutonModifierLum.setPreferredSize(new Dimension(45,45));
        BoutonRotationDroite.setText("D");
        BoutonRotationDroite.setPreferredSize(new Dimension(45,45));
        BoutonRotationDroite.addActionListener((ActionListener) this);
        
        BoutonRotationGauche.setPreferredSize(new Dimension(45,45));
        BoutonRotationGauche.setText("G");
        BoutonRotationGauche.addActionListener((ActionListener) this);
         
        SlideLumi.setPreferredSize(new Dimension(100,20));
        SlideLumi.addChangeListener(new javax.swing.event.ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent ce) {
            
            //panneau.ModifierLuminosite(SlideLumi.getValue()-50); // rajouter pondération entre 0 et 255
            panneau.ModifierCONTETLUM(SlideContraste.getValue()-50, SlideLumi.getValue()-50);
        }
    });
        SlideContraste.setPreferredSize(new Dimension(100,20));
        SlideContraste.addChangeListener(new javax.swing.event.ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent ce) {
           
           // panneau.ModifierContraste(SlideContraste.getValue()-50); // rajouter pondération entre 0 et 255
            panneau.ModifierCONTETLUM(SlideContraste.getValue()-50, SlideLumi.getValue()-50);
        }
    });
             texteSlideLumi.setPreferredSize(new Dimension(100,20));
             texteSlideLumi.setHorizontalAlignment(JLabel.CENTER);
             texteSlideLumi.setVerticalAlignment(JLabel.CENTER);
             texteSlideContraste.setPreferredSize(new Dimension(100,20));
            texteSlideContraste.setHorizontalAlignment(JLabel.CENTER);
            texteSlideContraste.setVerticalAlignment(JLabel.CENTER);
             
              barredoutils.setPreferredSize(new Dimension(100,300));
              barredoutils.add(BoutonRotationGauche);
              barredoutils.add(BoutonRotationDroite);
              barredoutils.add(texteSlideLumi);
              barredoutils.add(SlideLumi);
              barredoutils.add(texteSlideContraste);
              barredoutils.add(SlideContraste);
              barredoutils.add(BoutonInverserColors);
        getContentPane().add(barredoutils, BorderLayout.EAST);
        
        
    }

   
    
    public void actionPerformed(ActionEvent cliqueMenu) {
        if (cliqueMenu.getSource().equals(ouvrirMenu)) {
            JFileChooser fileOuvrirImage = new JFileChooser();
            if (fileOuvrirImage.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                panneau.ajouterImage(new File(fileOuvrirImage.getSelectedFile()
                        .getAbsolutePath()));
            }
        }
        else if (cliqueMenu.getSource().equals(BoutonInverserColors)) {
           try {
                panneau.inversionNiveauGris();
            } catch (IOException ex) {
                Logger.getLogger(AfficheImage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (cliqueMenu.getSource().equals(BoutonRotationGauche)) {
           panneau.rotationGauche();
        }
        else if (cliqueMenu.getSource().equals(BoutonRotationDroite)) {
            panneau.rotationDroite();
        }
         else if (cliqueMenu.getSource().equals(binarisationMenu)) {
            panneau.imageBinaire();
        } else if (cliqueMenu.getSource().equals(convolutionMenu)) {
            //panneau.ModifierLuminosite();
        } else if (cliqueMenu.getSource().equals(agrandirMenu)) {
            panneau.agrandirImage();
        } else if (cliqueMenu.getSource().equals(reduireMenu)) {
            panneau.reduireImage();
        } else if (cliqueMenu.getSource().equals(assombrirMenu)) {
            panneau.imageSombre();
        } else if (cliqueMenu.getSource().equals(rotationDroiteMenu)) {
            panneau.rotationDroite();
        } else if (cliqueMenu.getSource().equals(rotationGaucheMenu)) {
            System.out.println("Vous avez cliqué sur rotation a gauche");
            panneau.rotationGauche();
        } else if (cliqueMenu.getSource().equals(inversionMenu)) {
            try {
                panneau.inversionNiveauGris();
            } catch (IOException ex) {
                Logger.getLogger(AfficheImage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }

    public static void main(String args[]){
        
        try {
            AfficheImage frame = new AfficheImage();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
