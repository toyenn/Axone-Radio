/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.sql.*;
/**
 *
 * @author natfo
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        try {
//            //Connexion à la base de donnée:
//            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdTest1", "root", "Fm14021996");
//            //Création d'une requête:
//            Statement myStmt = myConn.createStatement();
//            //Execution de la querry sql:
//            ResultSet myRes = myStmt.executeQuery("select * from Utilisateur");
//            //Résultat:
//            while(myRes.next()){
//                System.out.println(myRes.getString("id"));
//            }
//        }
//        catch(Exception exc){
//            exc.printStackTrace();
//        }

// Deuxième éssai: 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        }
        catch(ClassNotFoundException ex) {
            System.out.println("Problème au chargement");
        }
        try{
            Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdTest1", "root", "Fm14021996");
        }
        catch(SQLException ex){
            System.err.println("Erreur");
        }
    }
    
}

