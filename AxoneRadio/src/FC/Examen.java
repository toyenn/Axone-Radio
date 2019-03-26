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

    private int idExamen; // id unique d'un examen
    private Patient Patient; // patient impliqué dans lexamen
    private Professionnel PHresponsable; // PH createur de lexamen ou manipulateur radio ou interne
    private DateN date; // date de realisation de lexam
    private TypeExamen type; // type d'exam
    private CompteRendu cr; // compte rendu de lexam
    private int IDservice; // service qui a demandé l'examen (sert pour leur envoyer un message une fois l'examen fait

    private Images LISTEIMAGES; // liste dimages de lexam (vide au debut)

    // examen sans type cr
    public Examen(int idExam, Patient Patient, Professionnel PHresponsable, DateN date, TypeExamen type, int IDservice) {
        this.idExamen = idExam;
        this.Patient = Patient;
        this.PHresponsable = PHresponsable;
        this.date = date;
        this.type = type;
        this.IDservice = IDservice;
        this.LISTEIMAGES = new Images();
        this.cr = new CompteRendu(this);
    }

    // initialise un examen en creant une liste dimages vide et avec un etat defini
    public Examen(Patient Patient, Professionnel PHresponsable, DateN date, TypeExamen type, int IDservice) {
        this.idExamen = 0;
        this.Patient = Patient;
        this.PHresponsable = PHresponsable;
        this.date = date;
        this.type = type;
        this.IDservice = IDservice;
        this.LISTEIMAGES = new Images();
        this.cr = new CompteRendu(this);
    }

    // Getteurs et setteurs
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

    // donne les informations d'un examen (liste des images,...
    public String InformationsExam() {
        String s = "";
        s += "EXAMEN NUMERO ";
        s += this.getIdExamen();
        s += "\n Date de l'examen : ";
        s += this.getDate().toString();
        s += "\nType d'examen : ";
        s += this.getType().toString();
        //s+="\nService demandeur : "+a.getNomService(this.getIdExamen());

        s += "\n\n\nINFORMATIONS PATIENT :";
        s += "\nID : " + this.getPatient().getId();
        s += "\nNom : " + this.getPatient().getNom();
        s += "\nPrénom : " + this.getPatient().getPrénom();
        s += "\nDate de Naissance : " + this.getPatient().getDate().toString_DateNaissance();
        s += "\nGenre : " + this.getPatient().getGenre();
        s += "\nAdresse : " + this.getPatient().getAdresse();
        s += "\nHospitalise : " + this.getPatient().isHospitalise();
        s += "\n\n";

        s += "\nINFORMATIONS CREATEUR EXAMEN :";
        s += "\nID : " + this.getPHresponsable().getId();
        s += "\nNom : " + this.getPHresponsable().getNom();
        s += "\nPrénom : " + this.getPHresponsable().getPrenom();
        s += "\nService : " + this.getPHresponsable().getService();
        s += "\n\n\n";

        s += "COMPTE RENDU : (" + this.getCr().getEtat() + ")";
        s += "\nCreateur : " + this.getCr().getCreateur().getNom() + " " + this.getCr().getCreateur().getPrenom();
        s += "\n" + this.getCr().getTexte();

        return s;

    }

    // affiche les informations d'un examen
    public void AfficherInformationsExamen() {
        System.out.println("########################");
        System.out.println("INFORMATIONS DE L'EXAMEN :");
        System.out.println("########################");
        System.out.println("ID EXAMEN : " + this.idExamen);
        System.out.println("PATIENT : " + this.getPatient().getNom() + " " + this.getPatient().getPrénom());
        System.out.println("PH RESPO : " + this.getPHresponsable().getNom() + " " + this.getPHresponsable().getPrenom());
        System.out.println("DATE : " + this.getDate().toString());
        System.out.println("TYPE EXAM : " + this.getType().toString());
        this.getCr().afficherInfoCR();
        System.out.println("SERVICE QUI A DEMANDE : " + this.getService());

        this.LISTEIMAGES.AfficherInformationsImages();
        System.out.println("########################");
    }

    public boolean contientinfoExam(Services s, String recherche) {//return true ssi letexte dans recherche contient un peu d'info de exam
// idexam, nom ph, prenom ph, date exam, type exam
        if (recherche == "") {
            return true;
        }
        if (String.valueOf(this.idExamen).toUpperCase().contains(recherche.toUpperCase())) {
            return true;
        } else if (this.PHresponsable.getNom().toUpperCase().contains(recherche.toUpperCase())) {
            return true;
        } else if (this.PHresponsable.getPrenom().toUpperCase().contains(recherche.toUpperCase())) {
            return true;
        } else if (this.getType().toString().toUpperCase().contains(recherche.toUpperCase())) {
            return true;
        } else if (s.getNomService(this.getIDservice()).toUpperCase().contains(recherche.toUpperCase())) {
            return true;
        } else {
            return false;
        }

    }

}
