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
// donne une liste d'images 
public class Images {

    private Vector<Imagepacs> listeImages; // liste des images de lexamen

    // Initialise a vide la liste dimages
    public Images() {
        listeImages = new Vector<Imagepacs>();
    }

    // donne l'id maximum d'une image
    public int getIdMax() {
        int i = 0;
        int max = 1;
        while (i < this.listeImages.size()) {
            if (this.listeImages.get(i).getIdExamen() > max) {
                max = this.listeImages.get(i).getIdImage();
            }
            i++;
        }
        return max;
    }

    public Vector<Imagepacs> getListeImages() {
        return listeImages;
    }

    // ajoute une image a la liste si elle n'y est pas deja
    public void AjouterImage(Imagepacs img) {
        if (!this.getListeImages().contains(img)) {
            this.getListeImages().add(img);
        }
    }

    // recupere une image a la liste ayant pour id id
    public Imagepacs getImage(int id) {
        int i = 0;
        //System.out.println("service a trouver : "+nom);
        boolean trouve = false;
        while (!trouve && i < this.getListeImages().size()) {
            if (this.getListeImages().get(i).getIdImage() == id) {
                trouve = true;

                return this.getListeImages().get(i);

            }
            i++;
        }
        System.out.println("ERREUR CRITIQUE IMPOSSIBLE DE TROUVER LIMAGE");
        return null;
    }

    // recupere l'image avec le nom nom
    public Imagepacs getImage(String nom) {
        int i = 0;
        //System.out.println("service a trouver : "+nom);
        boolean trouve = false;
        while (!trouve && i < this.getListeImages().size()) {
            if (this.getListeImages().get(i).getNom().equals(nom)) {
                trouve = true;

                return this.getListeImages().get(i);

            }
            i++;
        }
        System.out.println("ERREUR CRITIQUE IMPOSSIBLE DE TROUVER LIMAGE");
        return null;
    }

    // affiche les informations dune image
    public void AfficherInformationsImages() {
        System.out.println("/////////////");
        System.out.println("LISTE IMAGES EXAMEN :");
        System.out.println("/////////////");
        for (int i = 0; i < this.getListeImages().size(); i++) {
            System.out.println("");
            this.getListeImages().get(i).InformationsImage();
        }
        System.out.println("/////////////");
    }
}
