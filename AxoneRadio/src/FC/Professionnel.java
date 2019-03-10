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
public class Professionnel { // classe abstraite ou interface ?
    private String nom;
    private String prénom;
    private int id;
    private String service;
    private String login;
    private String motDePasse;

    

    public Professionnel(int id,String nom, String prénom, String login, String motDePasse, String service) {
        this.nom = nom;
        this.prénom = prénom;
        this.id = id;
        this.service = service;
        this.login = login;
        this.motDePasse = motDePasse;
    }
    
    public void InformationsProfessionnel(){
        System.out.println("INFORMATIONS DE LA PERSONNE :\n");
        System.out.println("*************************");
        System.out.println("ID : "+this.id);
        System.out.println("NOM : "+this.nom);
        System.out.println("PRENOM : "+this.prénom);
        System.out.println("LOGIN : "+this.login);
        System.out.println("MOT DE PASSE : "+this.motDePasse);
        System.out.println("SERVICE : "+this.service);
         System.out.println("*************************");
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }
    
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prénom;
    }
    
    public String getService() {
        return service;
    }
    
    
}
