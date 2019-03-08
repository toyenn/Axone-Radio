package FC;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Nathan
 */
public class LectureImagePGM {
    
    /*
    On pourra modifier la luminosité le contraste
    mais aussi rotation a gauche ou a droite
    inversion niveau de gris
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static final int MAXVAL = 255;
    private  int width = 0;
    private  int height = 0;
    private  int max = 0;
    private  int [][]image = null;
    private int[] image1D = null;
    
    
       public LectureImagePGM(File filename) throws FileNotFoundException
      {
        Scanner scanner = new Scanner(filename);
        scanner.next(); // magic number
        this.width = scanner.nextInt();
          //System.out.println("width :"+this.width);
        this.height = scanner.nextInt();
        //System.out.println("height :"+this.height);
        this.max = scanner.nextInt();
        //System.out.println("max :"+this.max);

        this.image = new int[height][width];
        this.image1D = new int[height*width];
//        for (int i = 0; i < height; ++i)
//        {
//          for (int j = 0; j < width; ++j)
//          {
//            // normalize to 255
//            int value = scanner.nextInt();
//            value = (int) Math.round( ((double) value) / max * MAXVAL);
//            this.image[i][j] = value;
//          }
//        }
for (int i = 0; i < height*width; ++i) {
            
                // normalize to 255
                //System.out.println("Lecture n°"+i);
                int value = scanner.nextInt();
                value = (int) Math.round(((double) value) / max * MAXVAL);
                image1D[i] = value;
            
        }
        image = new int[height][width];
        
        int taille = 0;
        for(int j =0; j<height; j++){
            for(int k=0; k<width; k++){
                image[j][k]= image1D[taille];
                taille++;
            }
        }

      }
    
    
  public int[][] getImage()
  {
    return image;
  }
  public int[] getImage1D(){
      return image1D;
  }

    public int[][] lirefichierPGM(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        scanner.next(); // magic number
        this.width = scanner.nextInt();
        this.height = scanner.nextInt();
        this.max = scanner.nextInt();
        
        image = new int[height][width];
        
        for (int i = 0; i < height; ++i)
        {
            for (int j = 0; j < width; ++j)
            {
                // normalize to 255
                int value = scanner.nextInt();
                value = (int) Math.round( ((double) value) / max * MAXVAL);
                image[i][j] = value;
            }
        }
        return image;
    }

    public void setImage1D(int[] image1D) {
        this.image1D = image1D;
    }

    public void setImage(int[][] image) {
        this.image = image;
    }
  

    

    public void inversionCouleurs(int[][] image) {
        int width = image[0].length;
        int height = image.length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                result[i][j] = MAXVAL - image[i][j];
            }
            
        }
        this.image = result;
        this.MiseAJourTableau1D();
       // return result;
        
    }
    
    public int[] inversionCouleurs(int[] image) {
        
       
        int[] result = new int[image.length];
        for (int i = 0; i < image.length; ++i) {
           
                result[i] = MAXVAL - image[i];
            }
            
        
        return result;
        
    }
    
    
    public void augmenterContrasteEtlumi(LectureImagePGM imageDeBase,int puissancelumi, int puissancecontraste) {
        // lire limage de imageDeBase et modifier le contraste et la lumi de this
        int width = this.image[0].length;
        int height = this.image.length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if(this.image[i][j]>(MAXVAL/2)){ // le pixel est plus proche du blanc
                    //if(this.image[i][j]<(MAXVAL-puissancecontraste)){
                        result[i][j]= imageDeBase.image[i][j]+puissancecontraste+puissancelumi;
                   // }
                    
                    
                }
                else{ // le pixel est plus proche du noir
                   // if(this.image[i][j]>(puissancecontraste)){
                        result[i][j]= imageDeBase.image[i][j]-puissancecontraste+puissancelumi;
                    //}
                    
                }
                
                if(result[i][j]<0){
                    result[i][j]=0;
                }
                else if(result[i][j]>MAXVAL){
                    result[i][j]=MAXVAL;
                }
            }
            
        }
       this.image = result;
       this.MiseAJourTableau1D();
        
    }
   
    
    public void augmenterContraste(int puissance) { // modifier pour faire une pondération ? (en pourcentage tousatoussa)
        int width = this.image[0].length;
        int height = this.image.length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if(this.image[i][j]>(MAXVAL/2)){ // le pixel est plus proche du blanc
                    if(this.image[i][j]<(MAXVAL-puissance)){
                        result[i][j]= this.image[i][j]+puissance;
                    }
                    else{
                       // result[i][j]=MAXVAL;
                       result[i][j]= this.image[i][j]+puissance;
                    }
                    
                }
                else{ // le pixel est plus proche du noir
                    if(this.image[i][j]>(puissance)){
                        result[i][j]= this.image[i][j]-puissance;
                    }
                    else{
                        //result[i][j]=0;
                        result[i][j]= this.image[i][j]+puissance;
                    }
                }
            }
            
        }
       this.image = result;
       this.MiseAJourTableau1D();
        //return result;
        
    }
     public void augmenterLuminosité(int puissance) { // modifier pour faire une pondération ? (en pourcentage tousatoussa)
        int width = this.image[0].length;
        int height = this.image.length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                result[i][j]=this.image[i][j]+puissance;
                
                if(result[i][j]>MAXVAL){
                    result[i][j]=MAXVAL;
                }
                else if(result[i][j]<0){
                    result[i][j]=0;
                }
            }
            
        }
        this.image = result;
       this.MiseAJourTableau1D();
        
    }
     
//          public void ModifierContrasteetlumino(int puissanceluminosite, int puissancecontraste) { // modifier pour faire une pondération ? (en pourcentage tousatoussa)
//            int width = this.image[0].length;
//            int height = this.image.length;
//            int[][] result = new int[height][width];
//            for (int i = 0; i < height; ++i) {
//                for (int j = 0; j < width; ++j) {
//                    result[i][j]=this.image[i][j]+puissance;
//
//                    if(result[i][j]>MAXVAL){
//                        result[i][j]=MAXVAL;
//                    }
//                    else if(result[i][j]<0){
//                        result[i][j]=0;
//                    }
//                }
//
//            }
//            this.image = result;
//           this.MiseAJourTableau1D();
//
//        }
     
//       public int[][] inclinerImage(int[][] image) { //rotation a 90 degres a gauche
//        int width = image[0].length;
//        int height = image.length;
//        int[][] result = new int[width][height];
//        for (int i = 0; i < height; ++i) {
//            for (int j = 0; j < width; ++j) {
//                result[i][j]=image[j][i];
//                
//            }
//            
//        }
//        return result;
//        
//      }
     
     
//     public int[][] Symetrie verticale() { //symétrie verticale ???
//        int width = this.image[0].length;
//        int height = this.image.length;
//        int[][] result = new int[width][height];
//        for (int i = 0; i < height; ++i) {
//            for (int j = 0; j < width; ++j) {
//                result[i][j]= this.image[i][width-1-j];
//                
//            }
//         
//        }
//       
//        this.MiseAJourTableau1D();
//        return result;
//      }
       
       public void RotationGaucheImage() { // rotation gauche
        int width = this.image[0].length;
        int height = this.image.length;
        int[][] result = new int[width][height];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                result[i][j]= this.image[j][width-1-i];
                
            }
         
        }
        this.image = result;
        this.MiseAJourTableau1D();
        
      }
       
       
       public void MiseAJourTableau1D(){
           System.out.println("Mise a jour du tableau 1D");
            int taille = 0;
        for(int j =0; j<height; j++){
            for(int k=0; k<width; k++){
                this.image1D[taille]= this.image[j][k];
                taille++;
            }
        }
       }
       
       public void RotationDroiteImage() { // rotation a 90 degres a droite
        int width = this.image[0].length;
        int height = this.image.length;
        int[][] result = new int[width][height];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                result[i][j]= this.image[height-1-j][i];
                
            }
         
        }
        this.image = result;
        this.MiseAJourTableau1D();
        
      }
       // pour faire rotation à 180 degres on cliquera 2 fois sur le bouton
       
       
    

    public static void createFile(int[][] image, String filename) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        int width = image[0].length;
        int height = image.length;

        // magic number, width, height, and maxval
        pw.println("P2");
        pw.println(width + " " + height);
        pw.println(MAXVAL);

        // print out the data, limiting the line lengths to 70 characters
        int lineLength = 0;
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                int value = image[i][j];

                // if we are going over 70 characters on a line,
                // start a new line
                String stringValue = "" + value;
                int currentLength = stringValue.length() + 1;
                if (currentLength + lineLength > 70) {
                    pw.println();
                    lineLength = 0;
                }
                lineLength += currentLength;
                pw.print(value + " ");
            }
        }
        pw.close();
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return the max
     */
    public int getMax() {
        return max;
    }

    /**
     * @return the image
     */
   
}
