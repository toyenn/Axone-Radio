/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author natfo
 */
public class VuePrincipale {
    
    JFrame frame;

    public VuePrincipale() {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    
    public void setMenuOn() {
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.repaint();
        this.frame.revalidate();
    }

    public void setMenuOff() {
        this.frame.setVisible(false);
    }
    
    public void setPanel(JPanel panel){
        this.frame.add(panel);
    }
    
    public void newFrame(JFrame frame){
        this.setMenuOff();
        this.frame=frame;
        this.setMenuOn();        
    }
}
