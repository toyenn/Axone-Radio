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
public class Patients { // Liste des patients d'une aile
    private Vector<Patient> ListePatients;
    
    public Patients(){
        ListePatients = new Vector<Patient>();
    }

    public Vector<Patient> getListePatients() {
        return ListePatients;
    }
    // ajoute un patient a laile
    public void AjouterPatient(Patient p){
        if(!this.getListePatients().contains(p)){
            this.getListePatients().add(p);
        }
    }
    
    public void AfficherInformationsPatients(){
        System.out.println("###############################################################");
        System.out.println("LISTE DES PATIENTS :");
        System.out.println("###############################################################");
        for(int i=0;i<this.getListePatients().size();i++){
            System.out.println("");
            this.getListePatients().get(i).InformationsPatient();
        }
    }
    
    
}
