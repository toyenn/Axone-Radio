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
public class Service { // contient une liste des ailes d'un service

    private String nomService; // nom du service (cardio,...)
    private Vector<Aile> ListeAiles; // BLOC A ? BLOC B?...

    public Service(String nomService) {
        this.nomService = nomService;
        this.ListeAiles = new Vector<Aile>();
    }

    public String getNomService() {
        return nomService;
    }

    public Vector<Aile> getListeAiles() {
        return ListeAiles;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public void setListeAiles(Vector<Aile> ListeAiles) {
        this.ListeAiles = ListeAiles;
    }

    // ajoute une aile au service si elle n'y ait pas deja
    public void AjouterAile(Aile a) {
        String nom = a.getNomAile();
        int i = 0;
        boolean trouve = false;
        while (!trouve && i < this.getListeAiles().size()) {
            if (this.getListeAiles().get(i).getNomAile().equals(nom)) {
                trouve = true;
            }
            i++;
        }
        if (!trouve) {
            this.getListeAiles().add(a);
        }
    }

    // recupere l'aile d'un service ayant le nom "nom"
    public Aile getAile(String nom) {
        int i = 0;

        boolean trouve = false;
        while (!trouve && i < this.ListeAiles.size()) {
            if (this.ListeAiles.get(i).getNomAile().equals(nom)) {
                trouve = true;

                return this.ListeAiles.get(i);

            }
            i++;
        }

        return null;
    }

    // donne les informations du service
    public void AfficherInformationsService() {
        System.out.println("--------------------------------");
        System.out.println("SERVICE de : " + this.nomService);
        for (int i = 0; i < this.ListeAiles.size(); i++) {
            this.ListeAiles.get(i).AfficherInformationsAile();
        }
        System.out.println("--------------------------------");
    }

}
