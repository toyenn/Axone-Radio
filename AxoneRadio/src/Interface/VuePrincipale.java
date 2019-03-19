/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author natfo
 */
public class VuePrincipale {
    
    private JFrame frame1,frame2;

    public VuePrincipale() {
        this.frame1 = new JFrame();
        this.frame2 = new JFrame();
        
        this.frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.frame1.setResizable(false);
    }
    
    public void setMenuOn() {
        frame1.pack();
        frame1.setVisible(true);
        frame1.repaint();
        frame1.revalidate();
    }
    
    public void newFrame(JFrame frame){
        this.frame1=frame;
        this.setMenuOn();        
    }
    
    public void changerWindow(JFrame frame){
        frame2.setVisible(false);
        frame2=frame;
        frame2.setVisible(true);
    }
    
    public void newWindow(JFrame frame){
        frame2 = frame;
        frame2.setVisible(true);
    }

    public JFrame getFrame() {
        return frame1;
    }
}
