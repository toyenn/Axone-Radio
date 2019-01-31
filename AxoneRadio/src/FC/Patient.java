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
    private DateNaissance date;
    private Genre genre;
    boolean hospitalise;

    public Patient(int id, String nom, String prénom, DateNaissance date, Genre genre, boolean hospitalise) {
        this.id = id;
        this.nom = nom;
        this.prénom = prénom;
        this.date = date;
        this.genre = genre;
        this.hospitalise = false;
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
    
    
}
