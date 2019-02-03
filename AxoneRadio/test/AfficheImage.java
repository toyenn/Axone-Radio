/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import FC.* ;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;

public class AfficheImage extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    
      Point P = new Point();

    private final JMenuBar menuBar = new JMenuBar();
    private final JMenu fichierMenu = new JMenu();
    private final JMenuItem ouvrirMenu = new JMenuItem();

    
    private final IHMImages panneau = new IHMImages();
    private final JMenuItem enregistrerMenu = new JMenuItem();

    private final JMenuItem inversionMenu = new JMenuItem();
    private final JMenuItem assombrirMenu = new JMenuItem();
    private final JMenuItem brillanceMenu = new JMenuItem();
    private final JMenuItem binarisationMenu = new JMenuItem();
    private final JMenuItem convolutionMenu = new JMenuItem();
    private final JMenu Options = new JMenu();
    
   
    private final JMenuItem afficherBarreOutil = new JMenuItem();
    //private final JMenuItem rotationGaucheMenu = new JMenuItem();
    private final JMenuItem writeInPacs = new JMenuItem();
    
    private final  JPanel barredoutils = new javax.swing.JPanel();
        private final JButton BoutonInverserColors = new javax.swing.JButton(new ImageIcon("src/images/inversioncouleurs.png"));
        
        private final JButton BoutonRotationDroite = new javax.swing.JButton(new ImageIcon("src/images/rotationdroite.png"));
        private final JButton BoutonRotationGauche = new javax.swing.JButton(new ImageIcon("src/images/rotationgauche.png"));
        
        private final JSlider SlideLumi = new javax.swing.JSlider();
        private final JSlider SlideContraste = new javax.swing.JSlider();
        
        private final JToggleButton ActiveSouris = new javax.swing.JToggleButton(new ImageIcon("src/images/contrasteluminosite.png")); // ajouter icone
        private final JButton Reset = new javax.swing.JButton(new ImageIcon("src/images/reset.png")); // ajouter icone
        private final JLabel texteSlideLumi = new javax.swing.JLabel("Luminosité");
        private final JLabel texteSlideContraste = new javax.swing.JLabel("Contraste");
    

    public AfficheImage() { // constructeur avec comme parametre lurl de limage
        super();
        //this.setLocationRelativeTo(null);
        //setBounds(100, 100, 500, 375);
        
        //ImageIcon icon = new ImageIcon(new ImageIcon("src/donnees/icon.png").getImage());
       // jLabel1.setIcon(icon);
        //jLabel1.setText(null);
        //setBounds(100, 100, 800, 650);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        try {
            creerMenu();
            panneau.ajouterImage(new File("C:\\Users\\Nathan\\Pictures\\SIR\\essai.pgm"));
            setBounds(100, 100,  panneau.im.getWidth()+140, panneau.im.getHeight()+80);
            this.setLocationRelativeTo(null); // PERMET DE CENTRER LA FENETRE
            //panneau.im.getHeight()
              //      panneau.im.getWidth()
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

        

        menuBar.add(Options);
        Options.setText("Options");

        

        Options.add(afficherBarreOutil);
        afficherBarreOutil.addActionListener((ActionListener) this);
        afficherBarreOutil.setText("afficher/masquer la barre d'outils");

      
        
        //BoutonModifierLum.addActionListener((ActionListener) this);
        
        
        

        // ajouter le panneau de dessin
       // getContentPane().add(panneau);
        
        
        
        
        
        
        getContentPane().add(panneau, BorderLayout.CENTER);
        // creation de la barre d'outils
        BoutonInverserColors.setText(null);
        BoutonInverserColors.setPreferredSize(new Dimension(50,50));
        BoutonInverserColors.addActionListener((ActionListener) this);
        //BoutonModifierLum.setText("Lumino");
       // BoutonModifierLum.setPreferredSize(new Dimension(48,48));
        BoutonRotationDroite.setText(null);

        BoutonRotationDroite.setPreferredSize(new Dimension(50,50));
        BoutonRotationDroite.addActionListener((ActionListener) this);
        
        BoutonRotationGauche.setText(null);
        BoutonRotationGauche.setPreferredSize(new Dimension(50,50));     
        BoutonRotationGauche.addActionListener((ActionListener) this);
        
        
        ActiveSouris.setText(null);
        ActiveSouris.setPreferredSize(new Dimension(50,50));
        ActiveSouris.addActionListener((ActionListener) this);
        
        Reset.setText(null);
        Reset.setPreferredSize(new Dimension(50,50));
        Reset.addActionListener((ActionListener) this);
         
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
             
              barredoutils.setPreferredSize(new Dimension(120,300));
              barredoutils.add(BoutonRotationGauche);
              barredoutils.add(BoutonRotationDroite);
              barredoutils.add(texteSlideLumi);
              barredoutils.add(SlideLumi);
              barredoutils.add(texteSlideContraste);
              barredoutils.add(SlideContraste);
              
               barredoutils.add(ActiveSouris);
               barredoutils.add(BoutonInverserColors);
               barredoutils.add(Reset);
               
        getContentPane().add(barredoutils, BorderLayout.EAST);
        
        barredoutils.setBorder(new BevelBorder(BevelBorder.RAISED));
        //barredoutils.setBorder(new BevelBorder(BevelBorder.));
         barredoutils.setVisible(false);
         
         
        panneau.addMouseListener((MouseListener) this);
        panneau.addMouseMotionListener((MouseMotionListener) this);
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
        else if (cliqueMenu.getSource().equals(Reset)) {
           panneau.Reset();
           this.SlideContraste.setValue(50);
           this.SlideLumi.setValue(50);
        }
        else if (cliqueMenu.getSource().equals(BoutonRotationDroite)) {
            panneau.rotationDroite();
        }
         else if (cliqueMenu.getSource().equals(binarisationMenu)) {
            panneau.imageBinaire();
        } else if (cliqueMenu.getSource().equals(convolutionMenu)) {
            //panneau.ModifierLuminosite();
        }  else if (cliqueMenu.getSource().equals(assombrirMenu)) {
            panneau.imageSombre();
        } else if (cliqueMenu.getSource().equals(afficherBarreOutil)) {
            System.out.println("affichage de la barre doutils");
            if(barredoutils.isVisible()==true){
            barredoutils.setVisible(false);
            }
            else{
                barredoutils.setVisible(true);
            }
        }  else if (cliqueMenu.getSource().equals(inversionMenu)) {
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
    
   
  
    
     public void mouseClicked(MouseEvent event) { 
//         if(event.getSource())
          
     }

    @Override
    public void mousePressed(MouseEvent e) {
        
        if(this.ActiveSouris.isSelected()){
             //System.out.println("on a clic et le bouton est appuyé woow");
             
             P = e.getLocationOnScreen();
            //System.out.println("Valeur du point de départ en x: "+P.getX());
            //System.out.println("Valeur du point de départ en y: "+P.getY());
         }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(this.ActiveSouris.isSelected()){
       //System.out.println("Bouton relache");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(this.ActiveSouris.isSelected()){
        
        Point P2 = e.getLocationOnScreen();
        //System.out.println("déplacement x : "+(P2.x-P.x));
        //System.out.println("déplacement y : "+(P2.y-P.y)); 
        
        panneau.ModifierCONTETLUM(((P2.y-P.y)/4),((P2.x-P.x)/4) );
        this.SlideLumi.setValue(((P2.x-P.x)/4)+50);
         this.SlideContraste.setValue(((P2.y-P.y)/4)+50);
        
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println(clic);
        
            
        
    }
}
