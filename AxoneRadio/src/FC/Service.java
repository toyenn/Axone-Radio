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
public class Service { 
    
    
    private String nomService;
    private Vector<Aile> ListeAiles;

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
    
    public void AjouterAile(Aile a){
        String nom = a.getNomAile();
        int i = 0;
        boolean trouve = false;
        while (!trouve && i < this.getListeAiles().size()) {
            if(this.getListeAiles().get(i).getNomAile().equals(nom)){
                trouve=true;
        }
            i++;
    }
    if(!trouve){
        this.getListeAiles().add(a);
    }
    }
    
    public Aile getAile(String nom){
        int i=0;
        //System.out.println("Aile a trouver : "+nom);
        boolean trouve = false;
        while(!trouve && i<this.ListeAiles.size()){
            if(this.ListeAiles.get(i).getNomAile().equals(nom)){
                trouve = true;
                System.out.println("ON A TROUVE LAILE");
                return this.ListeAiles.get(i);
                
            }
            i++;
        }
        System.out.println("Aile introuvable");
        return null;
    }
    
    
    public void AfficherInformationsService(){
        System.out.println("--------------------------------");
        System.out.println("SERVICE de : "+this.nomService);
        for(int i=0;i<this.ListeAiles.size();i++){
            this.ListeAiles.get(i).AfficherInformationsAile();
        }
        System.out.println("--------------------------------");
    }
    
    
}
