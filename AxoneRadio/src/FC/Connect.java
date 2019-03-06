
package FC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.*;

/**
 *
 * @author ndeyeawagaye
 */
public class Connect {

    static Statement state;
    private ResultSet result;

    

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        

        
        
        RequetesBD req= new RequetesBD();
//        req.Identification("Ginal", "mdp");
//        
//        System.out.println("ON VA MODIF LE MDP");
//        Professionnel pro = new Professionnel(123456,"Gina","Laurent","Ginal","mdp","Cardiologie");
//        
//        req.ChangerMotDePasse(pro, "mdp2");

            //req.RecherchePatient(5);
            req.AfficherPatientsDansService(1);
        

    }
    
    
    
}
