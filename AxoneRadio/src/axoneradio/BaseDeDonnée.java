 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package axoneradio;

/**
 *
 * @author ndeyeawagaye
 */


import java.sql.*; 
public class BaseDeDonnée {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
           //1.se connecter
            Connection myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Patient","root","Saliouisone1");
   
            //2.creer une phrase
            Statement myStmt = myConn.createStatement();
           //3.Executer SQL requete
           ResultSet myRs = myStmt.executeQuery("select * from Patient");
           //4.Process the result set
           while(myRs.next()){
               System.out.println(myRs.getString("Nom")+ ", "+ myRs.getString("Nom"));
           }
       }

    catch(Exception exc) {
        exc.printStackTrace();
    }
      
    }
 
    
}
