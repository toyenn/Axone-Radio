/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nathan
 */
public class RequetesBD {

    String url;
    String user;
    String passwd;
    Connection conn;

    public RequetesBD() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        url = "jdbc:mysql://localhost:3306/connexion";
        url += "?serverTimezone=UTC";
        user = "root";
        passwd = "";

        conn = DriverManager.getConnection(url, user, passwd);
    }

    // GESTION DE LUTILISATEUR
    
    public void ChangerMotDePasse(Professionnel pro, String newmdp) {
        try {

            //Création d'un objet Statement
            Statement state = conn.createStatement();

            String query = "UPDATE connexion\n" + "SET motdepasse='" + newmdp + "'\nWHERE idpersonnel='" + pro.getId() + "'";
            state.executeUpdate(query);

            state.close();

            System.out.println("Modification du mot de passe réussi");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Professionnel Identification(String login, String mdp) {

        int id = 0;
        String nom = null;
        String prenom = null;
        String log = null;
        String motdepasse = null;
        String service = null;

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String url = "jdbc:mysql://localhost:3306/connexion";
//            url+= "?serverTimezone=UTC";
//            String user = "root";
//            String passwd = "";
//
//        Connection conn = DriverManager.getConnection(url, user, passwd);

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet result = state.executeQuery("SELECT * FROM connexion WHERE login="+login+" AND motdepasse="+mdp);
            ResultSet result = state.executeQuery("SELECT * FROM connexion WHERE login='" + login + "' AND motdepasse='" + mdp + "'");
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                id = result.getInt("idpersonnel");
                nom = result.getString("nom");
                prenom = result.getString("prenom");

                log = result.getString("login");
                motdepasse = result.getString("motdepasse");
                service = result.getString("service");

                //System.out.print("\t" + result.getObject(i).toString() + "\t |");
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Professionnel pro = new Professionnel(id, nom, prenom, log, motdepasse, service);
        pro.InformationsProfessionnel();
        return pro;
    }
    
    
    // GESTION DES PATIENTS
    public Patient RecherchePatient(int idPatient) { // ou chercher par nom et prenom ?

         int id =0;
     String nom = null;
     String prenom = null;
     DateN date = null;
     String genre = null;
     boolean hospitalise = false;
    
     int Service = 0;
//        
//        int id = 0;
//        String nom = null;
//        String prenom = null;
//        String log = null;
//        String motdepasse = null;
//        String service = null;

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String url = "jdbc:mysql://localhost:3306/connexion";
//            url+= "?serverTimezone=UTC";
//            String user = "root";
//            String passwd = "";
//
//        Connection conn = DriverManager.getConnection(url, user, passwd);

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet result = state.executeQuery("SELECT * FROM connexion WHERE login="+login+" AND motdepasse="+mdp);
            ResultSet result = state.executeQuery("SELECT * FROM patients WHERE idPatient=" + idPatient);
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                id = result.getInt("idPatient");
                nom = result.getString("nom");
                prenom = result.getString("prenom");
                date = new DateN(result.getString("dateN"));
                genre = result.getString("genre");
                String h = result.getString("hospitalise");
                if(h.equals("oui")){
                    hospitalise = true;
                }
                
                Service = result.getInt("idService");

                //System.out.print("\t" + result.getObject(i).toString() + "\t |");
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
  
        Patient pat = new Patient(id,nom,prenom,date,genre, hospitalise,Service);
        pat.InformationsPatients();
        return pat;
    } 
    
    
    // affiche tout les personnes qui sont dans le service X le stocker dans une liste de patients ??
    public void AfficherPatientsDansService(int IDService) { // ou chercher par nom et prenom ?

         int id =0;
     String nom = null;
     String prenom = null;
     DateN date = null;
     String genre = null;
     boolean hospitalise = false;
    
     int Service = 0;
//        
//        int id = 0;
//        String nom = null;
//        String prenom = null;
//        String log = null;
//        String motdepasse = null;
//        String service = null;

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String url = "jdbc:mysql://localhost:3306/connexion";
//            url+= "?serverTimezone=UTC";
//            String user = "root";
//            String passwd = "";
//
//        Connection conn = DriverManager.getConnection(url, user, passwd);

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet result = state.executeQuery("SELECT * FROM connexion WHERE login="+login+" AND motdepasse="+mdp);
            ResultSet result = state.executeQuery("SELECT * FROM patients WHERE idService=" + IDService);
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("AFFICHAGE DES PATIENTS DU SERVICE NUMERO : "+IDService);
            System.out.println("*********************************************************");
            while (result.next()) {
                id = result.getInt("idPatient");
                nom = result.getString("nom");
                prenom = result.getString("prenom");
                date = new DateN(result.getString("dateN"));
                genre = result.getString("genre");
                String h = result.getString("hospitalise");
                if(h.equals("oui")){
                    hospitalise = true;
                }
                
                Service = result.getInt("idService");
                Patient pat = new Patient(id,nom,prenom,date,genre, hospitalise,Service);
                pat.InformationsPatients();

                //System.out.print("\t" + result.getObject(i).toString() + "\t |");
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
  
        
        
    }  
    
    
    // GESTION DES EXAMENS
    
    // ajout d'un examen
    public void AjoutExamen(Examen exam){
       
      


        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String url = "jdbc:mysql://localhost:3306/connexion";
//            url+= "?serverTimezone=UTC";
//            String user = "root";
//            String passwd = "";
//
//        Connection conn = DriverManager.getConnection(url, user, passwd);

            //Création d'un objet Statement
            Statement state = conn.createStatement();
           String Querry="INSERT INTO `examens` (`idPH`, `idPatient`, `dateExam`, `typeExam`, `CR`, `idService`) VALUES ("+exam.getPHresponsable().getId()+", "+exam.getPatient().getid()+", '"+exam.getDate().toString()+"', '"+exam.getType().toString()+"', '"+exam.getCr().toString()+"', '"+exam.getService()+"')";
           state.executeUpdate(Querry);

            System.out.println("L'examen a bien été ajouté à la BD");
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
  
       
        
    }
    // GESTION DES IMAGES
    
    // ajout dune image a un examen
    
    
    
}
