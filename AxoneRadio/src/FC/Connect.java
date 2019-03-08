
package FC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author ndeyeawagaye
 */
public class Connect {

//    static Statement state;
//    private ResultSet result;

    

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        

        
        
        RequetesBD req= new RequetesBD();
        ////////////////////////////// TEST NUMERO 1 : CONNEXION DUNE PERSONNE//////////////////////////////
        
      // req.Identification("Ginal", "mdp3");

        ////////////////////////////// TEST NUMERO 2 : MODIFICATION DU MOT DE PASSE//////////////////////////////
//        
//        System.out.println("MODIFICATION DU MOT DE PASSE");
//        //Professionnel pro = new Professionnel(123456,"Gina","Laurent","Ginal","mdp","Cardiologie");
//        
//        req.ChangerMotDePasse(123456, "mdp3");


          ////////////////////////////// TEST NUMERO 3 : RECHERCHE D'UN PATIENT QUI A UN ID 5//////////////////////////////
            //req.RecherchePatient(5);
            
    ////////////////////////////// TEST NUMERO 4 : AJOUT D'UN EXAMEN POUR UN PATIENT DONNE//////////////////////////////
    ///////////////////////////// ATTENTION ON NE PEUT PAS AJOUTER 2X lE MEME EXAM DANS LA BD//////////////////////////
    
//            req.AfficherPatientsDansService(1);
//            Professionnel pro = new Professionnel(123456 , "Gina", "Laurent", "Ginal", "mdp2", "Cardiologie");
//            Patient pat = req.RecherchePatient(1);
//            DateN d = new DateN();
//            CompteRendu cr = new CompteRendu(pat,pro);
//            cr.AjouterTexte("ceci est un texte pour le cr");
//            Examen ex = new Examen(10,pat, pro, d, TypeExamen.IRM, cr, pat.getService());
//            ex.AfficherInformationsExamen();
//            
//            req.AjoutExamen(ex);


  ////////////////////////////// TEST NUMERO 5 : CHARGEMENT ET AFFICHAGE DU DMR DUN PATIENT EN PARTICULIER//////////////////////////////
//        Patient pat = req.RecherchePatient(1);
//        req.GetDMRPatient(pat);
        
        
 ////////////////////////////// TEST NUMERO 6 : TEST DE LA RECUPERATION DE PATIENTS DUNE AILE//////////////////////////////
        
        //Patients LISTEPATIENTS = req.AfficherPatientsDansService(1);
        
        
 ////////////////////////////// TEST NUMERO 7 : TEST DE LA RECHERCHE D'UN PATIENT ET DE L'AFFICHAGE DE SES DONNEES ET+++ DE SES EXAMS//////////////////////////////
        
//            Patient pat = req.RecherchePatient(1);
//            pat.setDMR(req.GetDMRPatient(pat));
//            pat.InformationsPatient();


////////////////////////////// TEST NUMERO 8 : TEST DE LA RECHERCHE DE TOUT LES PATIENTS DUNE AILE, DU CHARGEMENT DES INFOS DES PATIENTS ET DES DMR PUIS AFFICHAGE COMPLET //////////////////////////////

//            // création de la liste de tous les services du CHU :
//            Services CHU = req.CreerListeServices();
//            // Récupération du de la première aile du premier service
//            int idAile = CHU.getListeServices().get(0).getListeAiles().get(0).getIdAile();
//            // récupération de tous les patients de cette aile
//            Patients LISTEPATIENTS = req.AfficherPatientsDansService(idAile);
//            // ajout du DMR de chaque patient de cette aile
//            for(int i=0;i<LISTEPATIENTS.getListePatients().size();i++){
//                LISTEPATIENTS.getListePatients().get(i).setDMR(req.GetDMRPatient(LISTEPATIENTS.getListePatients().get(i)));
//            }
//           // Affichage des informations :
//            LISTEPATIENTS.AfficherInformationsPatients();


////////////////////////////// TEST NUMERO 9 : AFFICHAGE DE LISTE DES IMAGES DUN EXAMEN //////////////////////////////

               // req.getImagesExamen(4);

////////////////////////////// TEST NUMERO 10 : AFFICHAGE D'UNE FENETRE IMAGE ET ESSAI DE SAUVEGARDER MODIF //////////////////////////////
//try {
//            Imagepacs I = new Imagepacs(21,1,4,"nom");
//            AfficheImage frame = new AfficheImage(I); // id de limage en parametre puis idpatient puis idexam
//            frame.setVisible(true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//            
//
    }
    
    
    
}
