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
    private int idImage;
    private int idPatient;
    private int idExamen;
    private String nom;

    public Imagepacs(int idImage, int idPatient, int idExamen, String nom) {
        this.idImage = idImage;
        this.idPatient = idPatient;
        this.idExamen = idExamen;
        this.nom = nom;
    }

    
    
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
    public void InformationsImage(){
        System.out.println("~~~~~~~~");
        System.out.println("INFORMATIONS IMAGE :");
        System.out.println("~~~~~~~~");
        System.out.println("ID : " + this.idImage);
        System.out.println("NOM : " + this.getNom());
        System.out.println("ID EXAMEN : " +this.idExamen);
        System.out.println("ID PATIENT : "+this.idPatient);
        System.out.println("~~~~~~~~");
    }
    
    
}
