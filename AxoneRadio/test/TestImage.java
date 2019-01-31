/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import FC.*;
import java.io.FileNotFoundException;
/**
 *
 * @author Nathan
 */
public class TestImage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        // int [][]picture = null;
        
        String url="‪";
        LectureImagePGM LECTEUR = new LectureImagePGM();
        //int [][]picture = LECTEUR.lirefichierPGM("C:\\Users\\Nathan\\Pictures\\SIR\\essai.pgm");
        
        LECTEUR.createFile(LECTEUR.inversionCouleurs(LECTEUR.lirefichierPGM("C:\\Users\\Nathan\\Pictures\\SIR\\essai.pgm")), "C:\\Users\\Nathan\\Pictures\\SIR\\resultat.pgm");
        System.out.println("FINI");
        
        LECTEUR.createFile(LECTEUR.augmenterContraste(LECTEUR.lirefichierPGM("C:\\Users\\Nathan\\Pictures\\SIR\\essai.pgm"),30), "C:\\Users\\Nathan\\Pictures\\SIR\\resultat2.pgm");
        System.out.println("FINI2");
    
    
    }  
    
}
