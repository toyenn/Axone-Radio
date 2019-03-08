/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author natfo
 */
public class VuePrincipale {
    
    private JFrame frame;
    private JButton retour;

    public VuePrincipale() {
       // retour = new JButton();
       // retour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logoRetour.png")));
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    
    public void setMenuOn() {
        this.getFrame().pack();
        this.getFrame().setVisible(true);
        retour = new JButton();
        retour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logoRetour.png")));
        this.getFrame().repaint();
        this.getFrame().revalidate();
    }

    public void setMenuOff() {
        this.getFrame().setVisible(false);
    }
    
    public void newFrame(JFrame frame){
        this.setMenuOff();
        this.frame=frame;
        this.setMenuOn();        
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame;
    }
}
