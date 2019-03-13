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

  

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    
    // change le mdp en local et sur la BD
    public boolean setMotDePasse(String mdp,RequetesBD req) {
        if(MdpValide(mdp)){
        this.motDePasse = mdp;
        req.ChangerMotDePasse(this, mdp);
        return true;
        }
        else{
           return false;
        }
    }
    public String toString(){
        return this.prénom+" "+this.nom;
    }
    
    public boolean MdpValide(String mdp){
        // 5 caractères minimum
        // 1 majuscule minimum
        // 1 minuscule minimum
        // 1 chiffre minimum
        //1 lettre minimum
        char c;
        int i=0;
        boolean majuscule = false;
        boolean minuscule = false;
        boolean lettre = false;
        boolean nombre=false;
        
        if(mdp.length()<5){
            System.out.println("Mot de Passe invalide : trop petit");
            return false;
        }
        
            while(i<mdp.length() && (majuscule==false || minuscule==false || lettre==false || nombre==false)){
            c = mdp.charAt(i);
            if((c>='0')&&(c<='9')){
  
                nombre = true;
              }
            else{

                lettre = true;
            }
            if((c>='a')&&(c<='z')){

                minuscule = true;
            }
            else if((c>='A')&&(c<='Z')){
               
                majuscule = true;
            }
            i++;
            
        }
        if(lettre && majuscule && minuscule && nombre){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    
}
