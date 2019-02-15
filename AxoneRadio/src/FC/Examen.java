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
public class Examen {
    private int idExamen;
    
    private PH PHresponsable;
    private Date date;
    private TypeExamen type;
    private CompteRendu cr;
    private Service service; // service qui a demandé l'examen (sert pour leur envoyer un message une fois l'examen fait
    
    private Vector<String> listeImages;  // type string car nom des images mais peut changer
}
