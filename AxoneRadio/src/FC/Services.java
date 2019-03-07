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
public class Services {

    private Vector<Service> listeServices;

    public Services() {
        this.listeServices = new Vector<Service>();
    }

    public Vector<Service> getListeServices() {
        return listeServices;
    }
    
   
    
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
    
    public void AfficherInformationServices(){
        System.out.println("*****************************************************");
        System.out.println("INFORMATIONS DES SERVICES DU CHU :");
        System.out.println("*****************************************************");
        for(int i=0;i<this.listeServices.size();i++){
            this.listeServices.get(i).AfficherInformationsService();
        }
        System.out.println("*****************************************************");
    }
}
