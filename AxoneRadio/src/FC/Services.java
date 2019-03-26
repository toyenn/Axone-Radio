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
// classe principale : contient une liste de tous les services du CHU
public class Services {

    private Vector<Service> listeServices; // liste des services

    public Services() {
        this.listeServices = new Vector<Service>();
    }

    public Vector<Service> getListeServices() {
        return listeServices;
    }
    
   
    // ajoute un service a la liste si il n'y ait pas deja
    public void AjouterService(String s){
        
        int i = 0;
        boolean trouve = false;
        while (!trouve && i < this.getListeServices().size()) {
            if(this.getListeServices().get(i).getNomService().equals(s)){
                trouve=true;
        }
            i++;
    }
    if(!trouve){
        Service NouveauService = new Service(s);
        this.listeServices.add(NouveauService);
    }
    }

    public void AjouterAileDansService(Service S, Aile a) {
        S.AjouterAile(a);
    }
    // ajoute une aile dans un service precis
    public void AjouterAileDansService(String nomService, Aile a) {
        int i = 0;
        boolean trouve = false;
        while (!trouve && i < this.getListeServices().size()) {
            if(this.getListeServices().get(i).getNomService().equals(nomService)){
                trouve=true;
                this.getListeServices().get(i).AjouterAile(a);
        }
            i++;
    }
       
    }
    // return le service ayant le nom nom
    public Service getService(String nom){
        int i=0;
        //System.out.println("service a trouver : "+nom);
        boolean trouve = false;
        while(!trouve && i<this.listeServices.size()){
            if(this.listeServices.get(i).getNomService().equals(nom)){
                trouve = true;
                //System.out.println("ON A TROUVE LE SERVICE");
                return this.listeServices.get(i);
                
            }
            i++;
        }
        return null;
    }
    // return le nom d'un service a partir de son id
    public String getNomService(int id){
        String s="";
        int i=0;
        int j=0;
        //System.out.println("service a trouver : "+nom);
        boolean trouve = false;
        while(!trouve && i<this.listeServices.size()){
            while(!trouve && j<this.listeServices.get(i).getListeAiles().size()){
                if(this.listeServices.get(i).getListeAiles().get(j).getIdAile()==id){
                    s=this.listeServices.get(i).getNomService()+", "+this.listeServices.get(i).getListeAiles().get(j).getNomAile();
                    
                    trouve = true;
                 
           
                
                
            }
                j++;
            }
            
            i++;
        }
        return s;
    }
    
    // affiche les informations des services (liste des services)
    public void AfficherInformationServices(){
        System.out.println("**********************************************************************************************************");
        System.out.println("INFORMATIONS DES SERVICES DU CHU :");
        System.out.println("**********************************************************************************************************");
        for(int i=0;i<this.listeServices.size();i++){
            this.listeServices.get(i).AfficherInformationsService();
        }
        System.out.println("**********************************************************************************************************");
    }
}
