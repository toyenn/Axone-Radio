/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JFrame;

/**
 *
 * @author natfo
 */
public class VuePrincipale {
    
    private JFrame frame1,frame2,frame3;

    public VuePrincipale() {
        this.frame1 = new JFrame();
        this.frame2 = new JFrame();
        this.frame3 = new JFrame();
        
        this.frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame1.setResizable(false);
    }
    
    public void newFrame(JFrame frame){
        frame1.setVisible(false);
        this.frame1=frame;
        frame1.pack();
        frame1.setVisible(true);
        frame1.repaint();
        frame1.revalidate();      
    }
    
    public void changerWindow(JFrame frame){
        frame2.setVisible(false);
        frame2=frame;
        frame2.setVisible(true);
    }
    
    public void newWindow(JFrame frame){
        if (frame2.isVisible()){
            frame3=frame;
            frame3.setVisible(true);
        }
        else{
            frame2=frame;
            frame2.setVisible(true);
        }
    }

    /**
     * @return the frame
     */
    public JFrame getFrame() {
        return frame1;
    }
}
