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
public enum EtatCr {
    validé, attente, nonecrit;
    // validé si le PH a modifié le CR
    // attente si c'est l'interne qui a modifié le cr
    // nonecrit si le cr est vide

}
