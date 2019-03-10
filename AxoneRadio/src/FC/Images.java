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
public class Images {
    private Vector<Imagepacs> listeImages;
    
    public Images(){
        listeImages = new Vector<Imagepacs>();
    }

    public Vector<Imagepacs> getListeImages() {
        return listeImages;
    }
    
     public void AjouterImage(Imagepacs img){
        if(!this.getListeImages().contains(img)){
            this.getListeImages().add(img);
        }
    }
     
     public Imagepacs getImage(int id){
          int i=0;
        //System.out.println("service a trouver : "+nom);
        boolean trouve = false;
        while(!trouve && i<this.getListeImages().size()){
            if(this.getListeImages().get(i).getIdImage()==id){
                trouve = true;
               
                return this.getListeImages().get(i);
                
            }
            i++;
        }
         System.out.println("ERREUR CRITIQUE IMPOSSIBLE DE TROUVER LIMAGE");
        return null;
     }
     
     public Imagepacs getImage(String nom){
          int i=0;
        //System.out.println("service a trouver : "+nom);
        boolean trouve = false;
        while(!trouve && i<this.getListeImages().size()){
            if(this.getListeImages().get(i).getNom().equals(nom)){
                trouve = true;
               
                return this.getListeImages().get(i);
                
            }
            i++;
        }
         System.out.println("ERREUR CRITIQUE IMPOSSIBLE DE TROUVER LIMAGE");
        return null;
     }
    
    public void AfficherInformationsImages(){
        System.out.println("/////////////");
        System.out.println("LISTE IMAGES EXAMEN :");
        System.out.println("/////////////");
        for(int i=0;i<this.getListeImages().size();i++){
            System.out.println("");
            this.getListeImages().get(i).InformationsImage();
        }
        System.out.println("/////////////");
    }
}
