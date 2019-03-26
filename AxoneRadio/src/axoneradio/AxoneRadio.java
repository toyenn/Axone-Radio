/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package axoneradio;
import Interface.Controlleur;
import java.sql.SQLException;
import javax.swing.JTable;
/**
 *
 * @author Nathan
 */
public class AxoneRadio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        new Controlleur();
        JTable table;
        table = new JTable();
    }
    
}
