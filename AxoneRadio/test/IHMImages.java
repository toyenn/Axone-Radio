// charger le patient et lid de lexam pour pouvoir lecrire dans la bd après (dans le constructeur on apelle les 2 et on aura 2 attributs
import FC.*;

//import LectureImagePGM;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Blob;
import javax.swing.JPanel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IHMImages extends JPanel {
    LectureImagePGM im = null;
    
    // infos de l'image :
   
    private Imagepacs img;
    
    
    
    BufferedImage monImage = null;
   
    LectureImagePGM imDeBase = null; // image qu'on a ouvert et qu'on va jamais modifier (bon d'accord on la modifier a un moment
    
    File fichier;
    //int[] pgm = null;
   // int[][] pgm2 = null;

    public IHMImages(Imagepacs img) {
        super();       
       this.img = img;
        

    }

    public LectureImagePGM getIm() {
        return im;
    }

   

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (monImage != null) {
            //g.drawImage(monImage, this.getSize().width/2, this.getSize().height/2, null);
            g.drawImage(monImage, 0, 0,this.getWidth(),this.getHeight(), null);
            //g.translate(this.getSize().width/2,this.getSize().height/2);
            // si image affiché 2 fois plus grande : // rajouter un parametre qui fait fois 1 ou 2 ou... et qui redimenssione 
             //g.drawImage(monImage, 0, 0,monImage.getWidth()*2,monImage.getHeight()*2, null);
        }
    }

    protected void reduireImage() { // Reduire la taille d'une image
        BufferedImage imageReduite = new BufferedImage((int) (monImage.getWidth() * 0.5), (int) (monImage.getHeight() * 0.5), monImage.getType());
        AffineTransform reduire = AffineTransform.getScaleInstance(0.5, 0.5);
        int interpolation = AffineTransformOp.TYPE_BICUBIC;
        AffineTransformOp retaillerImage = new AffineTransformOp(reduire, interpolation);
        retaillerImage.filter(monImage, imageReduite);
        monImage = imageReduite;
        repaint();
    }

    protected void agrandirImage() { // Agrandir la taille de l'image
        BufferedImage imageZoomer = new BufferedImage((int) (monImage.getWidth() * 1.5), (int) (monImage.getHeight() * 1.5), monImage.getType());
        AffineTransform agrandir = AffineTransform.getScaleInstance(1.5, 1.5);
        int interpolation = AffineTransformOp.TYPE_BICUBIC;
        AffineTransformOp retaillerImage = new AffineTransformOp(agrandir, interpolation);
        retaillerImage.filter(monImage, imageZoomer);
        monImage = imageZoomer;
        repaint();
    }



    protected void imageEclaircie() { // Eclaircir l'image
        /*
		 *    RescaleOp brillance = new RescaleOp(A, K, null);
		 *    1.  A< 1, l’image devient plus sombre.
   			  2.  A > 1, l’image devient  plus brillante.
   			  3. K est compris entre 0 et 256 et ajoute un éclairement .
         */
        BufferedImage imgBrillant = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        RescaleOp brillance = new RescaleOp(1.2f, 0, null);
        Graphics2D surfaceImg = imgBrillant.createGraphics();
        imgBrillant = brillance.filter(monImage, imgBrillant);
        surfaceImg.drawImage(monImage, null, null);
        monImage = imgBrillant;
        repaint();

    }

    protected void imageSombre() { // Assombrir l'image
        /* RescaleOp assombrir = new RescaleOp(A, K, null);
		 *    
		 *    1.  A < 1, l’image devient plus sombre.
   			  2.  A > 1, l’image devient  plus brillante.
   			  3.  K est compris entre 0 et 256 et ajoute un éclairement .
		 *    
         */
        BufferedImage imgSombre = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_INT_RGB);
        RescaleOp assombrir = new RescaleOp(0.7f, 10, null);
        Graphics2D surfaceImg = imgSombre.createGraphics();
        imgSombre = assombrir.filter(monImage, null);
        surfaceImg.drawImage(monImage, null, null);
        monImage = imgSombre;
        repaint();
    }

    protected void imageBinaire() {
        BufferedImage imgBinaire = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D surfaceImg = imgBinaire.createGraphics();
        surfaceImg.drawImage(monImage, null, null);
        monImage = imgBinaire;
        repaint();
    }

    protected void imageEnNiveauGris() {
        BufferedImage imageGris = new BufferedImage(monImage.getWidth(), monImage.getHeight(), BufferedImage.TYPE_USHORT_GRAY);
        Graphics2D surfaceImg = imageGris.createGraphics();
        surfaceImg.drawImage(monImage, null, null);
        monImage = imageGris;
        repaint();
    }

    protected void inversionNiveauGris() throws IOException {
        //int[][] image;
        BufferedImage imageInv = new BufferedImage(monImage.getHeight(), monImage.getWidth(), monImage.getType());
        //image = new int[monImage.getHeight()][monImage.getWidth()];
      //  im.inversionCouleurs(im.getImage1D());
        
        im.inversionCouleurs(im.getImage());
        imDeBase.inversionCouleurs(imDeBase.getImage());
        
      //  for(int j =0; j<im.getImage1D().length; j++){
            
               // image[j][k] = monImage.getRGB(j, k);
       //        im.getImage1D()[j]=255-im.getImage1D()[j];
                
                //System.out.println();
                
 

                
        
  
     //       }
         final WritableRaster raster = imageInv.getRaster();
         raster.setPixels(0, 0, monImage.getWidth(), monImage.getHeight(), im.getImage1D());

        monImage = imageInv;
        repaint();
        
        
        
        
        
        
    }

    protected void rotationGauche() {
        System.out.println("rotation a gauche de limage");
        BufferedImage imageRot = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());

        im.RotationGaucheImage();
        final WritableRaster raster = imageRot.getRaster();
        raster.setPixels(0, 0, monImage.getWidth(), monImage.getHeight(), im.getImage1D());
        monImage = imageRot;
        imDeBase.RotationGaucheImage();
        repaint();
    }
    
    
    protected void ModifierLuminosite(int puissance){ // méthode non utilisée
        System.out.println("On modifie la luminosité de limage ");
        BufferedImage imageRot = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());

        //im.augmenterLuminosité(puissance-Modifierlumi);
        //this.Modifierlumi = puissance;
        //System.out.println(Modifierlumi);
        final WritableRaster raster = imageRot.getRaster();
        raster.setPixels(0, 0, monImage.getWidth(), monImage.getHeight(), im.getImage1D());
        monImage = imageRot;
        
        repaint();
    }
    
    protected void ModifierContraste(int puissance){ // méthode non utilisée
        System.out.println("On modifie le contraste de limage ");
        BufferedImage imageRot = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());

        //im.augmenterContraste(puissance-Modifiercontraste);
       
        //this.Modifiercontraste = puissance;
        //System.out.println(Modifiercontraste);
        final WritableRaster raster = imageRot.getRaster();
        raster.setPixels(0, 0, monImage.getWidth(), monImage.getHeight(), im.getImage1D());
        monImage = imageRot;
        
        repaint();
    }
    
    protected void ModifierCONTETLUM(int cont,int lumino){ 
        
        BufferedImage imageRot = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());

        
        im.augmenterContrasteEtlumi(imDeBase, lumino, cont);
       // imDeBase.augmenterContrasteEtlumi(imDeBase, lumino, cont);
        
        final WritableRaster raster = imageRot.getRaster();
        raster.setPixels(0, 0, monImage.getWidth(), monImage.getHeight(), im.getImage1D());
        monImage = imageRot;
        
        repaint();
    }
    
    
    

    protected void rotationDroite() {
        System.out.println("rotation a droite de limage");
        BufferedImage imageRot = new BufferedImage(monImage.getWidth(), monImage.getHeight(), monImage.getType());

        im.RotationDroiteImage();
         imDeBase.RotationDroiteImage();
        final WritableRaster raster = imageRot.getRaster();
        raster.setPixels(0, 0, monImage.getWidth(), monImage.getHeight(), im.getImage1D());
        monImage = imageRot;
        
        repaint();
       
    }

    protected void ajouterImage(File fichierImage) {   // dessiner une image à l'ecran	
        this.fichier=fichierImage;
        if (this.getExtension(fichierImage).contentEquals("pgm")) {
            try {

                im = new LectureImagePGM(fichierImage);
                imDeBase = new LectureImagePGM(fichierImage); 
                
                
                //pgm = im.getImage1D();
               // pgm2 = im.getImage();

                monImage = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
                final WritableRaster raster = monImage.getRaster();
                raster.setPixels(0, 0, im.getWidth(), im.getHeight(), im.getImage1D());
                monImage.getGraphics().drawImage(monImage, 0, 0, null);
//                for(int i=0;i<im.getImage1D().length;i++){
//                    System.out.println(im.getImage1D()[i]);
//                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                monImage = ImageIO.read(fichierImage);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (monImage == null) {
                JOptionPane.showMessageDialog(this, "Format d'image non supporté", "Erreur", JOptionPane.INFORMATION_MESSAGE);
            }

        }
        repaint();
    }

    protected BufferedImage getImage(File fichierImage) {   // retourner une BufferedImage d'un fichier Image	
        if (this.getExtension(fichierImage).contentEquals("pgm")) {
            try {

                LectureImagePGM im = new LectureImagePGM(fichierImage);
                //pgm = im.getImage1D();
                //pgm2 = im.getImage();

                monImage = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
                final WritableRaster raster = monImage.getRaster();
                raster.setPixels(0, 0, im.getWidth(), im.getHeight(), im.getImage1D());
                monImage.getGraphics().drawImage(monImage, 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                monImage = ImageIO.read(fichierImage);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return monImage;

    }

    protected BufferedImage getImagePanneau() {      // récupérer une image du panneau
        int width = this.getWidth();
        int height = this.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        this.paintAll(g);
        g.dispose();
        return image;
    }

    protected void enregistrerImage(File fichierImage) throws FileNotFoundException { //Enregistrer une image en local
        String format = "PGM";
        BufferedImage image = monImage;
        if (monImage == null) {
            JOptionPane.showMessageDialog(this, "Pas d'image à enregistrer", "Erreur", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                System.out.println("ecriture dans le fichier");

                ImageIO.write(image, format, fichierImage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    

   

    protected String getExtension(File f) { // Retourne l'extension d'un fichier
        if (f != null) {
            String filename = f.getName();
            int i = filename.lastIndexOf('.');
            if (i > 0 && i < filename.length() - 1) {
                return filename.substring(i + 1).toLowerCase();
            }
        }
        return null;
    }

    protected int getMax() { // Retourne la valeur maximum des pixels de l'image
        int max = monImage.getRGB(0, 0);
        int pivot;

        for (int j = 0; j < monImage.getWidth(); j++) {
            for (int k = 0; k < monImage.getHeight(); k++) {
                pivot = monImage.getRGB(k, j);

                if (pivot > max) {
                    max = pivot;
                }

            }
        }
        return max;

    }

    void Reset() {
        this.ajouterImage(fichier);
    }

    // y déplacer dna requetesBD
    void ecrirePACS() {
        try {
                // enregistrement en local :
                this.getIm().createFile(this.getIm().getImage(),"C:\\Users\\Nathan\\Pictures\\SIR\\resultatBD.pgm");
                
                RequetesBD req = new RequetesBD();
                
               PreparedStatement ps = req.getConn().prepareStatement("insert into pacs(nomImage,idExam,idPatient,image) values(?,?,?,?)");
               // enregistrer en local :
                
               InputStream is = new FileInputStream(new File("C:\\Users\\Nathan\\Pictures\\SIR\\resultatBD.pgm"));
               
               ps.setString(1,"Nom de limage");
               ps.setInt(2,4);
                ps.setInt(3,1);
               ps.setBlob(4,is);
               
              
               ps.executeUpdate();
               JOptionPane.showMessageDialog(null,"Data Inserted");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AfficheImage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AfficheImage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AfficheImage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void RecupererPACS(Imagepacs image) throws IOException{
        try{
        //this.getIm().createFile(this.getIm().getImage(),"C:\\Users\\Nathan\\Pictures\\SIR\\resultatBD.pgm");
                
                RequetesBD req = new RequetesBD();
                Statement state = req.getConn().createStatement();
                ResultSet result = state.executeQuery("SELECT * FROM pacs WHERE idImage=" +image.getIdImage());
                
           
                
               // lecture et ecriture dans fichier
               while(result.next()){
                  this.img.setIdImage(result.getInt("idImage"));
                  this.img.setIdExamen(result.getInt("idExam"));
                  this.img.setIdPatient(result.getInt("idPatient"));
                  this.img.setNom(result.getString("nomImage"));
                  
                  
                int b;
                InputStream bis = result.getBinaryStream("image");
                FileOutputStream f = new FileOutputStream("C:\\Users\\Nathan\\Pictures\\SIR\\wtf2.pgm");
                while ((b = bis.read()) >= 0) {
                  f.write(b);
                }
                f.close();
                bis.close();}
              this.ajouterImage(new File("C:\\Users\\Nathan\\Pictures\\SIR\\wtf2.pgm"));
//               
//              
//               ps.executeUpdate();
//               JOptionPane.showMessageDialog(null,"Data Inserted");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AfficheImage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AfficheImage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AfficheImage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    

   



}
