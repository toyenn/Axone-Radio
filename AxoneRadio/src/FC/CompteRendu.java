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

    private int idCR; // id spécifique à un cr
    private Examen exam; // examen lié au cr = unique
    private Professionnel Createur; // createur = dernier modificateur du cr

    private EtatCr etat; // etat du cr qui se modifie en fonction de qui ecrit
    private String texte; // texte du cr

    // initialisation d'un cr
    public CompteRendu(int id, Examen ex, Professionnel crea, EtatCr etat, String texte) { // lorsquon lit un exam sur la bd
        this.idCR = id;
        this.exam = ex;
        this.Createur = crea;
        this.etat = etat;
        this.texte = texte;

    }

    // initialisation d'un cr quand on initialise un exam
    public CompteRendu(Examen ex) { // lorsquon créée un cr, exam
        this.idCR = 0;
        this.exam = ex;
        this.Createur = ex.getPHresponsable(); // pardefault le PHresponsable est le créateur du cr
        this.etat = EtatCr.nonecrit;
        this.texte = "";

    }

    //ajoute du texte au cr
    public void AjouterTexte(String Texte) {
        this.texte = Texte;

    }

    // affiche les infos du cr (pour impression)
    public String toString() {
        String s = "Compte rendu :\n";
        s += "Etat : " + this.etat.toString() + "\n";

        s += texte;
        return s;
    }

    // Getteurs et setteurs
    public int getIdCR() {
        return idCR;
    }

    // modifie lid du cr
    public void setIdCR(int idCR) {
        this.idCR = idCR;
    }

    public void setEtat(EtatCr etat) {
        this.etat = etat;
    }

    // return l'examen lié au cr
    public Examen getExam() {
        return exam;
    }

// modifie l'examen lié au cr (pas très util)
    public void setExam(Examen exam) {
        this.exam = exam;
    }

    // modifie le createur (si on modifie le cr)
    public void setCreateur(Professionnel Createur) {
        this.Createur = Createur;
    }

    // modifie le texte du cr
    public void setTexte(String texte) {
        this.texte = texte;
    }

    // affiche les informations du cr
    public void afficherInfoCR() {
        System.out.println("Informations Compte rendu :");
        System.out.println(this.texte);
    }

    public Professionnel getCreateur() {
        return Createur;
    }

    public EtatCr getEtat() {
        return etat;
    }

    // affiche les infos du cr
    public String InfosCR(Services S) {
        String s = "";
        s += "Patient :\n----------------\n";
        s += "Id : " + this.exam.getPatient().getid() + "\n";
        s += "Nom : " + this.exam.getPatient().getNom() + "  ,prénom : " + this.exam.getPatient().getPrénom() + "\n";
        s += "Date Naissance : " + this.exam.getPatient().getDate().toString_DateNaissance() + " , ";
        s += "Genre : " + this.exam.getPatient().getGenre() + "\n";
        s += "Adresse : " + "       " + "\n";
        s += "----------------\n";
        s += "Professionnel ayant crée l'examen : ";
        s += this.Createur.getNom() + " " + this.Createur.getPrenom() + " , " + this.Createur.getId() + "\n";
        s += this.Createur.getService();
        s += "\n----------------\n";
        s += "Examen : \n" + "Date création : " + this.getExam().getDate().toString() + "\n";
        s += "Type : " + this.getExam().getType().toString() + "  ,Service demandeur : " + S.getNomService(this.getExam().getIDservice()) + "\n";
        s += "\n----------------\n";
        s += this.texte;
        return s;
    }

    public String getTexte() {
        return texte;
    }

}
