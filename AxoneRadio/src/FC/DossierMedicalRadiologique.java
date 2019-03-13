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
public class DossierMedicalRadiologique { // pour un patient
    
    
   
    private Vector<Examen> listeExamens;

    
    // création d'un DMR vide avec les infos du patients
    public DossierMedicalRadiologique() { 
        
        
        this.listeExamens = new Vector<Examen>();
    }
    
    // fonction d'ajout d'un examen au DMR :
    
    public void AjouterExamen(Examen ExamAjouter){
        if(!this.listeExamens.contains(ExamAjouter)){
            this.listeExamens.add(ExamAjouter);
        }
    }
    public int getIdMax(){
        int i=0;
        int max=1;
        while(i<this.listeExamens.size()){
            if(this.listeExamens.get(i).getIdExamen()>max){
                max = this.listeExamens.get(i).getIdExamen();
            }
            i++;
        }
        return max;
    }
    
    
    
 

    public Vector<Examen> getListeExamens() {
        return this.listeExamens;
    }
    
   

    public void setListeExamens(Vector<Examen> listeExamens) {
        this.listeExamens = listeExamens;
    }
    
    public void AfficherInformationsExamens(){
        System.out.println("*************************************");
        System.out.println("AFFICHAGE DU DMR DU PATIENT :");
        System.out.println("*************************************");
        for(int i=0;i<this.listeExamens.size();i++){
            this.getListeExamens().get(i).AfficherInformationsExamen();
            
        }
        System.out.println("*************************************");
    }
    
    public Examen GetExamenDMR(int id){
         int i=0;
        
        boolean trouve = false;
        while(!trouve && i<this.listeExamens.size()){
            if(this.listeExamens.get(i).getIdExamen()==id){
                trouve = true;
                //System.out.println("ON A TROUVE LEXAMEN");
                return this.listeExamens.get(i);
                
            }
            i++;
        }
        System.out.println("ERREUR EXAMEN INTROUVABLE");
        return null;
    }
    
   
    
}
