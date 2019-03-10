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
public class Patient {

    private int id;
    private String nom;
    private String prénom;
    private DateN date;
    private String genre;
    boolean hospitalise;

    public int Service;
    //public String Aile;

    public DossierMedicalRadiologique DMR;

    public Patient(int id, String nom, String prénom, DateN date, String genre, boolean hospitalise, int Service) {
        this.id = id;
        this.nom = nom;
        this.prénom = prénom;
        this.date = date;
        this.genre = genre;
        this.hospitalise = hospitalise;
        this.Service = Service;
        DMR = new DossierMedicalRadiologique();
    }

    // setteurs et getteurs :
    public int getid() {
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrénom() {
        return this.prénom;
    }

    public DateN getDate() {
        return this.date;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public void setDate(DateN date) {
        this.date = date;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getService() {
        return Service;
    }

    public DossierMedicalRadiologique getDMR() {
        return DMR;
    }

    public void setDMR(DossierMedicalRadiologique DMR) {
        this.DMR = DMR;
    }
    
    public String NomPrenomIdPatient(){
        return this.nom+" "+this.prénom+" ,"+this.id;
    }
    
   
    
   

    public void InformationsPatient() {
        System.out.println("--------------------------------------------");
        System.out.println("INFORMATIONS PATIENT :");
        System.out.println("--------------------------------------------");
        System.out.println("ID : " + this.id);
        System.out.println("NOM : " + this.nom);
        System.out.println("PRENOM : " + this.prénom);
        System.out.println("DATEN : "+this.date.toString_DateNaissance());
        System.out.println("GENRE : " + this.genre);
        System.out.println("HOSPITALISE : " + this.hospitalise);
        System.out.println("SERVICE ID : " + this.Service);
        System.out.println("--------------------------------------------");
        
        
        DMR.AfficherInformationsExamens();
        System.out.println("--------------------------------------------");
        

    }

}
