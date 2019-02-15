
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
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/connexion";
            String user = "root";
            String passwd = "ok";

        Connection conn = DriverManager.getConnection(url, user, passwd);
//        state.executeUpdate("INSERT INTO connexion (idpersonnel,nom,prenom,motdepasse) VALUES('1234009','Toyen', 'Nathan','ok')");
//        System.out.println("insertion reussi");
      

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery("SELECT * FROM connexion");
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("\n**********************************");
            //On affiche le nom des colonnes
            for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
            }

            System.out.println("\n**********************************");

            while (result.next()) {
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");
                }

                System.out.println("\n---------------------------------");

            }

            result.close();
            state.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
