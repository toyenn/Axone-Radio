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

    // classe permettant de lire une image au format pgm et de stocker les données
    private static final int MAXVAL = 255; // max des niveaux de gris
    private int width = 0; // largeur de limage
    private int height = 0; // hauteur de l'image
    private int max = 0; // maximum de l'image
    private int[][] image = null; // image en 2d
    private int[] image1D = null; // image stockée dans un tableau 1D pour pouvoir l'afficher correctement

    // lire le fichier filename et stocker les données
    public LectureImagePGM(File filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(filename);
        scanner.next(); // magic number
        this.width = scanner.nextInt();
        //System.out.println("width :"+this.width);
        this.height = scanner.nextInt();
        //System.out.println("height :"+this.height);
        this.max = scanner.nextInt();
        //System.out.println("max :"+this.max);

        this.image = new int[height][width];
        this.image1D = new int[height * width];

        for (int i = 0; i < height * width; ++i) {

            // normaliser les valeurs
            int value = scanner.nextInt();
            value = (int) Math.round(((double) value) / max * MAXVAL);
            image1D[i] = value;

        }
        // conversion 1d en 2d
        image = new int[height][width];

        int taille = 0;
        for (int j = 0; j < height; j++) {
            for (int k = 0; k < width; k++) {
                image[j][k] = image1D[taille];
                taille++;
            }
        }

    }
// recupere le tableau 2D

    public int[][] getImage() {
        return image;
    }
// recupere le tableau 1D

    public int[] getImage1D() {
        return image1D;
    }
// lit le fichier pgm et return un tableau 2D correspondant

    public int[][] lirefichierPGM(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        scanner.next(); // magic number
        this.width = scanner.nextInt();
        this.height = scanner.nextInt();
        this.max = scanner.nextInt();

        // conversion 2D 1D
        image = new int[height][width];

        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                // normalize to 255
                int value = scanner.nextInt();
                value = (int) Math.round(((double) value) / max * MAXVAL);
                image[i][j] = value;
            }
        }
        return image;
    }
// modifie le tableau 1D

    public void setImage1D(int[] image1D) {
        this.image1D = image1D;
    }
// modifie 

    public void setImage(int[][] image) {
        this.image = image;
    }
// inverse les couleurs d'une image 2D

    public void inversionCouleurs(int[][] image) {

        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                image[i][j] = MAXVAL - image[i][j]; // donne 255 - la valeur du pixel
            }

        }

        this.MiseAJourTableau1D(); // met a jour le tableau 1D

    }

// permet d'augmenter la luminosité et le contraste dune image d'une certaine valeur
    public void augmenterContrasteEtlumi(LectureImagePGM imageDeBase, int puissancelumi, int puissancecontraste) {
        // lire limage de imageDeBase et modifier le contraste et la lumi de this
        int width = this.image[0].length;
        int height = this.image.length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (this.image[i][j] > (MAXVAL / 2)) { // le pixel est plus proche du blanc
                    //if(this.image[i][j]<(MAXVAL-puissancecontraste)){
                    result[i][j] = imageDeBase.image[i][j] + puissancecontraste + puissancelumi;
                    // }

                } else { // le pixel est plus proche du noir

                    result[i][j] = imageDeBase.image[i][j] - puissancecontraste + puissancelumi;

                }

                if (result[i][j] < 0) {
                    result[i][j] = 0;
                } else if (result[i][j] > MAXVAL) {
                    result[i][j] = MAXVAL;
                }
            }

        }
        this.image = result;
        this.MiseAJourTableau1D();

    }

    // permet d'augmenter le contraste  de puissance (attention si on dépasse 0 ou le max)
    public void augmenterContraste(int puissance) {
        int width = this.image[0].length;
        int height = this.image.length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (this.image[i][j] > (MAXVAL / 2)) { // le pixel est plus proche du blanc
                    if (this.image[i][j] < (MAXVAL - puissance)) {
                        result[i][j] = this.image[i][j] + puissance;
                    } else {
                        // result[i][j]=MAXVAL;
                        result[i][j] = this.image[i][j] + puissance;
                    }

                } else { // le pixel est plus proche du noir
                    if (this.image[i][j] > (puissance)) {
                        result[i][j] = this.image[i][j] - puissance;
                    } else {
                        //result[i][j]=0;
                        result[i][j] = this.image[i][j] + puissance;
                    }
                }
            }

        }
        this.image = result;
        this.MiseAJourTableau1D();
        //return result;

    }

    // augmente la luminosité de limage de puissance ( attention si on atteint 0 ou le max)
    public void augmenterLuminosité(int puissance) { // modifier pour faire une pondération ? (en pourcentage tousatoussa)
        int width = this.image[0].length;
        int height = this.image.length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                result[i][j] = this.image[i][j] + puissance;

                if (result[i][j] > MAXVAL) {
                    result[i][j] = MAXVAL;
                } else if (result[i][j] < 0) {
                    result[i][j] = 0;
                }
            }

        }
        this.image = result;
        this.MiseAJourTableau1D();

    }

    public void RotationGaucheImage() { // rotation gauche
        int temp = this.height;
        this.height = this.width;
        this.width = temp;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                result[i][j] = this.image[j][height - 1 - i];

            }

        }
        this.image = result;
        this.MiseAJourTableau1D();

    }
// met a jour le tableau 1D a partir du tableau 2D

    public void MiseAJourTableau1D() {
        System.out.println("Mise a jour du tableau 1D");
        int taille = 0;
        for (int j = 0; j < height; j++) {
            for (int k = 0; k < width; k++) {
                this.image1D[taille] = this.image[j][k];
                taille++;
            }
        }

    }

    public void RotationDroiteImage() { // rotation a 90 degres a droite
        int temp = this.height;
        this.height = this.width;
        this.width = temp;

        int[][] result = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                result[i][j] = this.image[width - j - 1][i];

            }

        }
        System.out.println("Dimension de image 2D : hauteur :" + height + ", largeur :" + width);

        this.image = result;
        this.MiseAJourTableau1D();

    }

    // pour faire rotation à 180 degres on cliquera 2 fois sur le 
    // creer un fichier a partir d'un tableau 2D
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
