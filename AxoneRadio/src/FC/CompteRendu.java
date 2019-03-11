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
//    private String nom; // du patient
//    private String prénom; // du patient // Ou type patient carrement
    
    private int idCR;
    private Examen exam;
    private Professionnel Createur;
    // creer type examen ?
    
    private EtatCr etat;
    private String texte;
    
    public CompteRendu(int id,Examen ex,Professionnel crea, EtatCr etat,String texte){ // lorsquon lit un exam sur la bd
        this.idCR = id;
        this.exam = ex;
        this.Createur = crea;
        this.etat = etat;
        this.texte=texte;
        
    }
    
    public CompteRendu(Examen ex){ // lorsquon créée un cr, exam
        this.idCR = 0;//////////////////////PAS SUR
        this.exam = ex;
        this.Createur = ex.getPHresponsable(); // pardefault le PHresponsable est le créateur du cr
        this.etat = EtatCr.nonecrit;
        this.texte="";
        
    }
    
    public void AjouterTexte(String Texte){
        this.texte = Texte;
        
    }
    
    public String toString(){ // A AMELIORER
        String s="Compte rendu :\n";
        s+="Etat : "+this.etat.toString()+"\n";
        
        s+=texte;
        return s;
    }

    public int getIdCR() {
        return idCR;
    }

    public void setIdCR(int idCR) {
        this.idCR = idCR;
    }
    
    
    

    public void setEtat(EtatCr etat) {
        this.etat = etat;
    }

   
    public Examen getExam() {
        return exam;
    }

   

    public void setExam(Examen exam) {
        this.exam = exam;
    }

    public void setCreateur(Professionnel Createur) {
        this.Createur = Createur;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
    public void afficherInfoCR(){
        System.out.println("Informations Compte rendu :");
        System.out.println(this.texte);
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
