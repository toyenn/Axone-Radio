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
    
    
    Patient patient;
    private Vector<Examen> listeExamens;

    
    // création d'un DMR vide avec les infos du patients
    public DossierMedicalRadiologique(Patient patient) { 
        this.patient = patient;
        
        this.listeExamens = new Vector<Examen>();
    }
    
    // fonction d'ajout d'un examen au DMR :
    
    public void AjouterExamen(Examen ExamAjouter){
        if(!this.listeExamens.contains(ExamAjouter)){
            this.listeExamens.add(ExamAjouter);
        }
    }
    
    
    
 

    public Vector<Examen> getListeExamens() {
        return this.listeExamens;
    }
    
   

    public void setListeExamens(Vector<Examen> listeExamens) {
        this.listeExamens = listeExamens;
    }
    
   
    
}
