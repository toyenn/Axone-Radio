/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

/**
 *
 * @author Nathan
 */
public class Imagepacs {

    private int idImage; // id unique de limage
    private int idPatient; // id du patient correspondant peut se recuperer avec exam
    private int idExamen;// id de l'examen correspondant
    private String nom; // nom de l'image a sauvegarder

    // initialisation de l'image
    public Imagepacs(int idImage, int idPatient, int idExamen, String nom) {
        this.idImage = idImage;
        this.idPatient = idPatient;
        this.idExamen = idExamen;
        this.nom = nom;
    }

    // Getteurs et setteurs
    public int getIdImage() {
        return idImage;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public String getNom() {
        return nom;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // donne les informations de l'image
    public void InformationsImage() {
        System.out.println("~~~~~~~~");
        System.out.println("INFORMATIONS IMAGE :");
        System.out.println("~~~~~~~~");
        System.out.println("ID : " + this.idImage);
        System.out.println("NOM : " + this.getNom());
        System.out.println("ID EXAMEN : " + this.idExamen);
        System.out.println("ID PATIENT : " + this.idPatient);
        System.out.println("~~~~~~~~");
    }

}
