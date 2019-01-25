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
public class DossierMedicalRadiologique { // pour un patient
    private int id;
    private String nom;
    private String prénom;
    private DateNaissance date;
    private Genre genre;
    private Vector<Examen> listeExamens;

    
    // création d'un DMR vide avec les infos du patients
    public DossierMedicalRadiologique(int id, String nom, String prénom, DateNaissance date, Genre genre) { 
        this.id = id;
        this.nom = nom;
        this.prénom = prénom;
        this.date = date;
        this.genre = genre;
        this.listeExamens = new Vector<Examen>();
    }
    
    // fonction d'ajout d'un examen au DMR :
    
    public void AjouterExamen(Examen ExamAjouter){
        if(!this.listeExamens.contains(ExamAjouter)){
            this.listeExamens.add(ExamAjouter);
        }
    }
    
    
    
    // setteurs et getteurs :
    
    public int getid(){
        return this.id;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrénom() {
        return this.prénom;
    }

    public DateNaissance getDate() {
        return this.date;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public Vector<Examen> getListeExamens() {
        return this.listeExamens;
    }
    
    public void setid(int id){
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public void setDate(DateNaissance date) {
        this.date = date;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setListeExamens(Vector<Examen> listeExamens) {
        this.listeExamens = listeExamens;
    }
    
   
    
}
