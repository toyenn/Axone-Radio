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
public class Aile {

    private int idAile; // numero unique de l'aile
    private String nomAile; // nom de l'aile (A,B,C,D,...)
    private int nbPersonnes; // nb de personnes dans l'aile (interopérabilité

    // initialise les valeurs d'une aile
    public Aile(int idAile, String nomAile, int nbPersonnes) {
        this.idAile = idAile;
        this.nomAile = nomAile;
        this.nbPersonnes = nbPersonnes;
    }

    // Getteurs et setteurs d'une aile
    public int getIdAile() {
        return idAile;
    }

    public String getNomAile() {
        return nomAile;
    }

    public int getNbPersonnes() {
        return nbPersonnes;
    }

    public void setIdAile(int idAile) {
        this.idAile = idAile;
    }

    public void setNomAile(String nomAile) {
        this.nomAile = nomAile;
    }

    public void setNbPersonnes(int nbPersonnes) {
        this.nbPersonnes = nbPersonnes;
    }

    // affichage de l'information d'une aile
    public void AfficherInformationsAile() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("AILE :");
        System.out.println("Numero : " + this.idAile);
        System.out.println("Nom : " + this.getNomAile());
        System.out.println("Nb personnes : " + this.nbPersonnes);
        System.out.println("--------------------------------------------------------------------------------");
    }

}
