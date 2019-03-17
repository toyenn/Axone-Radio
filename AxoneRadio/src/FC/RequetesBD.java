/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FC;

import Interface.AfficheImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    public Connection getConn() {
        return conn;
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
            
            // récupération du nombre de résultats
            result.last();
            int nb = result.getRow(); // nbre de résultats
            result.beforeFirst();
            
            if(nb==0){
                System.out.println("MDP incorrect");
                Professionnel pro = new Professionnel(id, nom, prenom, log, motdepasse, service);
                return pro;
            }
            else{
                
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
            state.close();}
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        Professionnel pro = new Professionnel(id, nom, prenom, log, motdepasse, service);
        pro.InformationsProfessionnel();
        return pro;
        
    }
    
    
    public Professionnel getProfessionnel(int idP){
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
            ResultSet result = state.executeQuery("SELECT * FROM connexion WHERE idpersonnel=" + idP);
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
                id = result.getInt("idpersonnel");
                nom = result.getString("nom");
                prenom = result.getString("prenom");

                log = result.getString("login");
                motdepasse = result.getString("motdepasse");
                service = result.getString("service");

                
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Professionnel pro = new Professionnel(id, nom, prenom, log, motdepasse, service);
        //pro.InformationsProfessionnel();
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


        try {


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
       // pat.InformationsPatient();
        return pat;
    } 
    
    
    // affiche tout les personnes qui sont dans le service X le stocker dans une liste de patients ??
    // Créer une classe Patients ? pour stocker tous les patients là
    public Patients AfficherPatientsDansService(int IDService) { // ou chercher par nom et prenom ?
        Patients LISTEPATIENTS = new Patients();
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

//            System.out.println("AFFICHAGE DES PATIENTS DU SERVICE NUMERO : "+IDService);
//            System.out.println("*********************************************************");
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
                //pat.InformationsPatient();
                LISTEPATIENTS.AjouterPatient(pat);

                //System.out.print("\t" + result.getObject(i).toString() + "\t |");
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return LISTEPATIENTS;
        
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
    
    //modification dun cr en changeant letat ou en changeant le texte
    public void ModifierCR(Examen exam){
       
      


        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String url = "jdbc:mysql://localhost:3306/connexion";
//            url+= "?serverTimezone=UTC";
//            String user = "root";
//            String passwd = "";
//
//        Connection conn = DriverManager.getConnection(url, user, passwd);
            CompteRendu CR = exam.getCr();
            //Création d'un objet Statement
            Statement state = conn.createStatement();
            
            // erreur la :
           String Querry="UPDATE compterendu SET etatcr = '"+exam.getCr().getEtat().toString()+"' , textecr = '"+exam.getCr().getTexte()+"' WHERE idexam = "+exam.getCr().getExam().getIdExamen();
           state.executeUpdate(Querry);

            System.out.println("Le CR a bien été modifié ds la BD");
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
  
       
        
    }
    // ajout d'un CR :
    public void AjoutCR(Examen exam){
       
      


        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            String url = "jdbc:mysql://localhost:3306/connexion";
//            url+= "?serverTimezone=UTC";
//            String user = "root";
//            String passwd = "";
//
//        Connection conn = DriverManager.getConnection(url, user, passwd);
            CompteRendu CR = exam.getCr();
            //Création d'un objet Statement
            Statement state = conn.createStatement();
           String Querry="INSERT INTO `compterendu` (`idcr`, `idexam`, `idcreateur`, `etatcr`, `textecr`) VALUES ("+CR.getExam().getIdExamen()+", "+CR.getExam().getIdExamen()+", '"+CR.getCreateur().getId()+"', '"+CR.getEtat().toString()+"', '"+CR.getTexte()+"')";
           state.executeUpdate(Querry);

            System.out.println("Le CR a bien été ajouté à la BD");
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
  
       
        
    }
    
    public CompteRendu getCrExamen(Examen exam){
         
           CompteRendu cr = new CompteRendu(exam);
           int idCR;
           
           Professionnel Createur;
   
    
           EtatCr etat;
           String texte;
        
         

   
    int IDservice; 
        try {
//           

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet result = state.executeQuery("SELECT * FROM connexion WHERE login="+login+" AND motdepasse="+mdp);
            ResultSet result = state.executeQuery("SELECT * FROM compterendu WHERE idexam=" + exam.getIdExamen());
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
               idCR = result.getInt("idcr");
               Createur = this.getProfessionnel(result.getInt("idcreateur"));
               etat = EtatCr.valueOf((result.getString("etatcr")));
               texte = result.getString("textecr");
               
               
               
              
               cr = new CompteRendu(idCR,exam,Createur,etat,texte);
               
               
               
                
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cr;
    }
    
    public DossierMedicalRadiologique GetDMRPatient(Patient pat){ 
        DossierMedicalRadiologique DMR = new DossierMedicalRadiologique();
        int id = pat.getid();
        
         int idExamen;

    Professionnel PHresponsable;
    int idPH;
    DateN date;
    TypeExamen type;
    CompteRendu cr;
    int IDservice; 
        try {
//           

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet result = state.executeQuery("SELECT * FROM connexion WHERE login="+login+" AND motdepasse="+mdp);
            ResultSet result = state.executeQuery("SELECT * FROM examens WHERE idPatient=" + id);
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
               idExamen = result.getInt("idExamen");
               
               idPH = result.getInt("idPH");
               
               
               
               
               // NOT SURE ABOUT THAT
               PHresponsable = this.getProfessionnel(idPH);
               
               
               date = new DateN(result.getString("dateExam"));
               type = TypeExamen.valueOf(result.getString("typeExam"));
               
               IDservice = result.getInt("idService");
               Examen exam = new Examen(idExamen,pat,PHresponsable,date,type,IDservice);
               //cr = new CompteRendu(pat,PHresponsable);
               //azeexam.getCr().AjouterTexte(result.getString("CR"));
                exam.setCr(this.getCrExamen(exam));
//                System.out.println("lkndksnlksdnclknfkcnldvwnv");
//                exam.getCr().afficherInfoCR();
               //exam.getCr().setCreateur(PHresponsable);
               //exam.ajouterCr(cr);
               //exam.AfficherInformationsExamen();
               DMR.AjouterExamen(exam);
                
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return DMR;
        
    } // ou selon idPatient ? 
    // GESTION DES IMAGES
    public Images getImagesExamen(int idexam){// affiche la liste des images d'un examen
       Images LISTEIMAGES = new Images();
        int idImage;
     int idPatient;
     int idExamen;
     String nom;
   
        try {
//           

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet result = state.executeQuery("SELECT * FROM connexion WHERE login="+login+" AND motdepasse="+mdp);
            ResultSet result = state.executeQuery("SELECT * FROM pacs WHERE idExam=" + idexam);
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            while (result.next()) {
               idImage = result.getInt("idImage");
               idExamen = result.getInt("idExam");
               idPatient = result.getInt("idPatient");
               nom = result.getString("nomImage");
               
               Imagepacs img = new Imagepacs(idImage,idPatient,idExamen,nom);
               
               
               
               
               //exam.AfficherInformationsExamen();
               LISTEIMAGES.AjouterImage(img);
                
            }
            //LISTEIMAGES.AfficherInformationsImages();
            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return LISTEIMAGES;
    }
    

// ajout dune image a un examen cf travail Awa
    
    
    
    // GESTION DES SERVICES
    // créer méthode qui remplit les Services
    public Services CreerListeServices() { 
        Services LISTESERVICES = new Services();
        
         
        int idAile;
        String NomService;
        String NomAile;
        int nbPersonnes;

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
            ResultSet result = state.executeQuery("SELECT * FROM service");
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            
            while (result.next()) {
                 idAile = result.getInt("idService");
                  NomService = result.getString("ServicePrincipal");
                  NomAile = result.getString("Aile");
                  nbPersonnes = result.getInt("nbPatients");
                
                  Aile NouvelleAile = new Aile(idAile,NomAile,nbPersonnes);
                  LISTESERVICES.AjouterService(NomService);
                  LISTESERVICES.AjouterAileDansService(NomService, NouvelleAile);
                
                

                //System.out.print("\t" + result.getObject(i).toString() + "\t |");
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println("FIN DE LA RECHERCHE");
        //LISTESERVICES.AfficherInformationServices();
        return LISTESERVICES;
        
    }  

//    void ChargerListeImages(Patient p) {
//        
//    }
     public int getIntNomPrenomIdPatient(String s){ // return un id correspondant à un patient dans une chaine "nom prenom ,id"
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==','){
                return Integer.parseInt(s.substring(i+1));
            }
        }
           return 0; 
    }
    
     
     
     // chargement de toutes le infos d'un patient à partir de son id
     public Patient ChargementPatient(int id){
         Patient p =this.RecherchePatient(id); // charge le patient avec lid id
            p.setDMR(this.GetDMRPatient(p)); // charge le dmr du patient
            
            for(int i=0;i<p.getDMR().getListeExamens().size();i++){ // charge les images des examens et compte rendu
                Examen ex = p.getDMR().getListeExamens().get(i);
               
                ex.getCr().afficherInfoCR();
                ex.setLISTEIMAGES(this.getImagesExamen(ex.getIdExamen()));
            }
            return p;
     }
     
          public int getMaxIdExam(){
          int id=0;
         try {
//           

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet result = state.executeQuery("SELECT * FROM connexion WHERE login="+login+" AND motdepasse="+mdp);
            ResultSet result = state.executeQuery("SELECT MAX(idExamen) FROM examens");
            //On récupère les MetaData
           
           
            while (result.next()) {
               //id = result.getInt("idImage");
               id = result.getInt(1);
              
               
               
               
              
               
               
               
               
                
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
         return id;
     }
     
     
     public int getMaxIdImg(){
          int id=0;
         try {
//           

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            //ResultSet result = state.executeQuery("SELECT * FROM connexion WHERE login="+login+" AND motdepasse="+mdp);
            ResultSet result = state.executeQuery("SELECT MAX(idImage) FROM pacs");
            //On récupère les MetaData
           
           
            while (result.next()) {
               //id = result.getInt("idImage");
               id = result.getInt(1);
              
               
               
               
              
               
               
               
               
                
            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
         return id;
     }
     
     
     
     
     // ajouter image pacs
     // ajoute l'image selectionné au préalable dans le pacs
     public void ecrirePACS(Imagepacs img,String Cheminimg) {
        try {
                // enregistrement en local :
                //this.getIm().createFile(this.getIm().getImage(),"C:\\Users\\Nathan\\Pictures\\SIR\\resultatBD.pgm");
                
                RequetesBD req = new RequetesBD();
                
               PreparedStatement ps = req.getConn().prepareStatement("insert into pacs(idImage, nomImage,idExam,idPatient,image) values(?,?,?,?,?)");
                
              // InputStream is = new FileInputStream(new File("C:\\Users\\Nathan\\Pictures\\SIR\\resultatBD.pgm"));
               InputStream is = new FileInputStream(new File(Cheminimg));
               ps.setInt(1,img.getIdImage() );
               ps.setString(2,img.getNom());
               ps.setInt(3,img.getIdExamen());
                ps.setInt(4,img.getIdPatient());
               ps.setBlob(5,is);
               
              
               ps.executeUpdate();
               JOptionPane.showMessageDialog(null,"Data Inserted");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AfficheImage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AfficheImage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AfficheImage.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
