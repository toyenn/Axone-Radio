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
public enum TypeExamen { // peut se compléter suivant les examens disponibles dans le CHU
    Scanner("Scanner"),
    IRM("IRM");
    
    private String name="";
    
    TypeExamen(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
   
    
    
}
