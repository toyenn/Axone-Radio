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
public class CompteRendu {
    private String nom; // du patient
    private String prénom; // du patient
    private Professionnel Createur;
    // creer une variable pour dire qui a validé le compte rendu ? (si ph -> c'est lui meme)
    
    private EtatCr etat;
    private String texte;
    
    public CompteRendu(Patient p, Professionnel pro){
        this.nom = p.getNom();
        this.prénom = p.getPrénom();
        this.etat = EtatCr.nonecrit;
        this.texte="";
        
    }
    
    public void AjouterTexte(String Texte){
        this.texte = Texte;
    }
    
    public String toString(){ // A AMELIORER
        String s="";
        
        s+=texte;
        return s;
    }

    public void setEtat(EtatCr etat) {
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public Professionnel getCreateur() {
        return Createur;
    }

    public EtatCr getEtat() {
        return etat;
    }

    public String getTexte() {
        return texte;
    }
    
    
}
