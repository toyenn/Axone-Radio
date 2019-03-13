/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.util.Vector;

/**
 *
 * @author Nathan
 */
public class Examen {
    private int idExamen;
    private Patient Patient;
    private Professionnel PHresponsable;
    private DateN date;
    private TypeExamen type;
    private CompteRendu cr;
    private int IDservice; // service qui a demandé l'examen (sert pour leur envoyer un message une fois l'examen fait
    
    private Images LISTEIMAGES;

    // examen sans type cr
    public Examen(int idExam,Patient Patient, Professionnel PHresponsable, DateN date, TypeExamen type, int IDservice) {
        this.idExamen = idExam;
        this.Patient = Patient;
        this.PHresponsable = PHresponsable;
        this.date = date;
        this.type = type;
        this.IDservice = IDservice;
        this.LISTEIMAGES = new Images();
        this.cr = new CompteRendu(this);
    }
    
     public Examen(Patient Patient, Professionnel PHresponsable, DateN date, TypeExamen type, int IDservice) {
        this.idExamen=0;
        this.Patient = Patient;
        this.PHresponsable = PHresponsable;
        this.date = date;
        this.type = type;
        this.IDservice = IDservice;
        this.LISTEIMAGES = new Images();
        this.cr = new CompteRendu(this);
    }

    public int getIdExamen() {
        return idExamen;
    }

    public Patient getPatient() {
        return Patient;
    }

    public Professionnel getPHresponsable() {
        return PHresponsable;
    }

    public DateN getDate() {
        return date;
    }

    public TypeExamen getType() {
        return type;
    }

    public CompteRendu getCr() {
        return cr;
    }

    public int getService() {
        return IDservice;
    }

    public int getIDservice() {
        return IDservice;
    }

    public Images getLISTEIMAGES() {
        return LISTEIMAGES;
    }

    public void setLISTEIMAGES(Images LISTEIMAGES) {
        this.LISTEIMAGES = LISTEIMAGES;
    }

    public void setCr(CompteRendu cr) {
        this.cr = cr;
    }
    

    
    
    public void AfficherInformationsExamen(){
        System.out.println("########################");
        System.out.println("INFORMATIONS DE L'EXAMEN :");
        System.out.println("########################");
        System.out.println("ID EXAMEN : "+this.idExamen);
        System.out.println("PATIENT : "+this.getPatient().getNom()+" "+this.getPatient().getPrénom());
        System.out.println("PH RESPO : "+this.getPHresponsable().getNom()+" "+this.getPHresponsable().getPrenom());
        System.out.println("DATE : "+this.getDate().toString());
        System.out.println("TYPE EXAM : " +this.getType().toString());
        this.getCr().afficherInfoCR();      
        System.out.println("SERVICE QUI A DEMANDE : "+this.getService());
        
        
       this.LISTEIMAGES.AfficherInformationsImages();
       System.out.println("########################");
    }
    
}
