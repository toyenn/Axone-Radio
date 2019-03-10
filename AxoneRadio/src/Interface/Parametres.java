/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import FC.Professionnel;
import FC.RequetesBD;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.stream.XMLStreamException;

public class Parametres extends javax.swing.JFrame {

    
    

    public Parametres() { // ajout des argument utilisateur et la fenetre de base
        initComponents();
       
        
        this.setLocationRelativeTo(null);// PERMET DE CENTRER LA FENETRE
       
        
         this.setResizable(false);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        buttonVal = new javax.swing.JButton();
        buttonAnnul = new javax.swing.JButton();
        jPasswordField3 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Parametres");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel4.setBackground(new java.awt.Color(204, 204, 255));
        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Changer Mot De passe");

        jLabel6.setText("Ancien mot de passe");

        jLabel7.setText("Nouveau mot de passe");

        jLabel8.setText("Confirmer nouveau mot de passe");

        buttonVal.setText("Valider");
        buttonVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonValActionPerformed(evt);
            }
        });

        buttonAnnul.setText("Annuler");
        buttonAnnul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAnnulActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("<html>Pour toute demande d'aide ou de signalisation de bug, <br>veuillez contacter le support à l'adresse mail :<br><b>axoneradio@gmail.com<b></html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonAnnul)
                        .addGap(18, 18, 18)
                        .addComponent(buttonVal)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4)
                            .addGap(98, 98, 98)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPasswordField1, jPasswordField2, jPasswordField3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVal)
                    .addComponent(buttonAnnul))
                .addGap(19, 19, 19))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPasswordField1, jPasswordField2, jPasswordField3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonValActionPerformed

        String s1, s2, s3;
       
        
        
       
        
        
        
//        s1 = new String(jPasswordField1.getPassword());
//        s2 = new String(jPasswordField2.getPassword());
//        s3 = new String(jPasswordField3.getPassword());
//        if (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
//            if (s2.equals(s3) && s1.equals(this.user.getMdp())) {
//
//                
//                if (BaseDonnee.modifierMdp(this.user.getLogin(), s2)) {
//                    System.out.println("new mdp : " + s2);
//                    this.user.setMdp(s2);
//                   
//                    
//                    JOptionPane.showMessageDialog(this, "Mot de passe modifié", "Information", JOptionPane.INFORMATION_MESSAGE);
//                    this.dispose();
//                } else {
//                    JOptionPane.showMessageDialog(this, "Le nouveau mot de passe est trop simple, il doit contenir au moins 5 caractères,\n dont au minimum 1 minuscule, 1 manuscule, 1 lettre, 1 nombre", "Erreur", JOptionPane.WARNING_MESSAGE);
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(this, "Les mots de passe ne correspondent pas", "Erreur", JOptionPane.WARNING_MESSAGE);
//            }
//        }
        // Reecriture du fichier xml avec la modification
                   
        
        
        
        

    }//GEN-LAST:event_buttonValActionPerformed

    private void buttonAnnulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAnnulActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_buttonAnnulActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAnnul;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonVal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the buttonAnnul
     */
    public javax.swing.JButton getButtonAnnul() {
        return buttonAnnul;
    }

    /**
     * @return the buttonVal
     */
    public javax.swing.JButton getButtonVal() {
        return buttonVal;
    }
    
    public void ResetChamps(){
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        jPasswordField3.setText("");
    }
    
    public boolean ChangementMDP(Professionnel pro,RequetesBD req){
        String s1 = new String(jPasswordField1.getPassword());
        String s2 = new String(jPasswordField2.getPassword());
        String s3 = new String(jPasswordField3.getPassword());
        if (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
            if (s2.equals(s3) && s1.equals(pro.getMotDePasse())) {

                
                if (pro.setMotDePasse(s3, req)) {
                    System.out.println("new mdp : " + s2);
                    
                   
                    
                    JOptionPane.showMessageDialog(this, "Mot de passe modifié", "Information", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                    //this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Le nouveau mot de passe est trop simple, il doit contenir au moins 5 caractères,\n dont au minimum 1 minuscule, 1 majuscule, 1 lettre, 1 nombre", "Erreur", JOptionPane.WARNING_MESSAGE);
                    return false;
                }

            } else {
                JOptionPane.showMessageDialog(this, "Les mots de passe ne correspondent pas", "Erreur", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        return false;
       
    }
}
