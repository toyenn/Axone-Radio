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
    private JButton retour;
    private GridBagConstraints c;

    public VuePrincipale() {
        this.frame1 = new JFrame();
        this.frame2 = new JFrame();
        this.retour = new JButton();
        this.retour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logoRetour.png")));
        
//        this.frame1.setLayout(new GridBagLayout());
//        c = new GridBagConstraints();
//        c.fill = GridBagConstraints.NORTHWEST;
//        this.frame1.add(retour,c);
        this.frame1.add(retour);
        
        this.frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame1.setResizable(false);
    }
    
    public void setMenuOn() {
        frame1.pack();
        frame1.setVisible(true);
        frame1.repaint();
        frame1.revalidate();
    }
    
    public void newFrame(JFrame frame){
        frame1.setVisible(false);
        this.frame1=frame;
        retour.repaint();
        this.setMenuOn();        
    }
    
    public void newWindow(JFrame frame){
        frame2 = frame;
        frame2.setVisible(true);
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame1;
    }
}
