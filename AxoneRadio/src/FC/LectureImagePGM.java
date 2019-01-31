/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Nathan
 */
public class LectureImagePGM {
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static final int MAXVAL = 255;
    private  int width = 0;
    private  int height = 0;
    private  int max = 0;
    private  int [][]image = null;
    //private int[][]image2 = null;
    
    
//       public LectureImagePGM(String filename) throws FileNotFoundException
//      {
//        Scanner scanner = new Scanner(new File(filename));
//        scanner.next(); // magic number
//        this.width = scanner.nextInt();
//        this.height = scanner.nextInt();
//        this.max = scanner.nextInt();
//
//        this.image = new int[height][width];
//
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
//
//      }
    
    
  public int[][] lirefichierPGM(String filename) throws FileNotFoundException
  {
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
  

    

    public int[][] inversionCouleurs(int[][] image) {
        int width = image[0].length;
        int height = image.length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                result[i][j] = MAXVAL - image[i][j];
            }
            
        }
        return result;
        
    }
    
    public int[][] augmenterContraste(int[][] image,int puissance) { // modifier pour faire une pondération ? (en pourcentage tousatoussa)
        int width = image[0].length;
        int height = image.length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if(image[i][j]>(MAXVAL/2)){ // le pixel est plus proche du blanc
                    if(image[i][j]<(MAXVAL-puissance)){
                        result[i][j]= image[i][j]+puissance;
                    }
                    else{
                        result[i][j]=MAXVAL;
                    }
                    
                }
                else{ // le pixel est plus proche du noir
                    if(image[i][j]>(puissance)){
                        result[i][j]= image[i][j]-puissance;
                    }
                    else{
                        result[i][j]=0;
                    }
                }
            }
            
        }
        return result;
        
    }
    

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
