/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.screen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import pk.codeapp.methods.DefaultRules;
import pk.codeapp.methods.Methods;
import pk.codeapp.model.Titan;

/**
 *
 * @author amador
 */
public class Lobby extends javax.swing.JFrame implements DefaultRules {

    private Methods methods = MainApp.methods;
    private MainApp beforeWindow;
    Titan titans[] ;

    /**
     * Creates new form Lobby
     */
    public Lobby() {
        initComponents();
        titans= methods.getTitans();
        this.setLocationRelativeTo(null);
        chargeTitans();
       
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {

                methods.writeUser();
                System.exit(0);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        btnTitan2 = new javax.swing.JButton();
        btnTitan1 = new javax.swing.JButton();
        btnTitan3 = new javax.swing.JButton();
        btnTitan4 = new javax.swing.JButton();
        btnTitan5 = new javax.swing.JButton();
        btnTitan6 = new javax.swing.JButton();
        btnTitan7 = new javax.swing.JButton();
        btnTitan8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblGifImage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        information = new javax.swing.JList<>();
        lblLobbyBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        btnTitan2.setBackground(new java.awt.Color(0, 0, 0));
        btnTitan2.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        btnTitan2.setForeground(new java.awt.Color(255, 255, 255));
        btnTitan2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTitan2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTitan2ActionPerformed(evt);
            }
        });

        btnTitan1.setBackground(new java.awt.Color(0, 0, 0));
        btnTitan1.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        btnTitan1.setForeground(new java.awt.Color(255, 255, 255));
        btnTitan1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTitan1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTitan1ActionPerformed(evt);
            }
        });

        btnTitan3.setBackground(new java.awt.Color(0, 0, 0));
        btnTitan3.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        btnTitan3.setForeground(new java.awt.Color(255, 255, 255));
        btnTitan3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTitan3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTitan3ActionPerformed(evt);
            }
        });

        btnTitan4.setBackground(new java.awt.Color(0, 0, 0));
        btnTitan4.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        btnTitan4.setForeground(new java.awt.Color(255, 255, 255));
        btnTitan4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTitan4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTitan4ActionPerformed(evt);
            }
        });

        btnTitan5.setBackground(new java.awt.Color(0, 0, 0));
        btnTitan5.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        btnTitan5.setForeground(new java.awt.Color(255, 255, 255));
        btnTitan5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTitan5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTitan5ActionPerformed(evt);
            }
        });

        btnTitan6.setBackground(new java.awt.Color(0, 0, 0));
        btnTitan6.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        btnTitan6.setForeground(new java.awt.Color(255, 255, 255));
        btnTitan6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTitan6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTitan6ActionPerformed(evt);
            }
        });

        btnTitan7.setBackground(new java.awt.Color(0, 0, 0));
        btnTitan7.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        btnTitan7.setForeground(new java.awt.Color(255, 255, 255));
        btnTitan7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTitan7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTitan7ActionPerformed(evt);
            }
        });

        btnTitan8.setBackground(new java.awt.Color(0, 0, 0));
        btnTitan8.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        btnTitan8.setForeground(new java.awt.Color(255, 255, 255));
        btnTitan8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTitan8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnTitan8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTitan1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTitan2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTitan3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTitan4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTitan5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTitan6, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTitan7, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTitan8, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTitan2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTitan1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTitan4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTitan3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTitan6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTitan5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTitan8, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTitan7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 510, 520));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/playGame.png"))); // NOI18N
        jButton9.setOpaque(false);
        jButton9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 610, 220, 100));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Estadistics");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 610, 210, 100));

        lblGifImage.setBackground(new java.awt.Color(0, 0, 0));
        lblGifImage.setFont(new java.awt.Font("Century Schoolbook L", 1, 36)); // NOI18N
        lblGifImage.setForeground(new java.awt.Color(255, 255, 255));
        lblGifImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblGifImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 470));

        information.setBackground(new java.awt.Color(51, 51, 51));
        information.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        information.setFont(new java.awt.Font("Century Schoolbook L", 1, 14)); // NOI18N
        information.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(information);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 780, 220));

        lblLobbyBackground.setBackground(new java.awt.Color(0, 0, 0));
        lblLobbyBackground.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        lblLobbyBackground.setForeground(new java.awt.Color(255, 255, 255));
        lblLobbyBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/Lobby_Background.jpg"))); // NOI18N
        getContentPane().add(lblLobbyBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTitan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitan1ActionPerformed
        // TODO add your handling code here:
        chargeGif(0);
    }//GEN-LAST:event_btnTitan1ActionPerformed

    private void btnTitan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitan2ActionPerformed
        // TODO add your handling code here:
        chargeGif(1);
    }//GEN-LAST:event_btnTitan2ActionPerformed

    private void btnTitan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitan3ActionPerformed
        // TODO add your handling code here:
        chargeGif(2);
    }//GEN-LAST:event_btnTitan3ActionPerformed

    private void btnTitan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitan4ActionPerformed
        // TODO add your handling code here:
        chargeGif(3);
    }//GEN-LAST:event_btnTitan4ActionPerformed

    private void btnTitan5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitan5ActionPerformed
        // TODO add your handling code here:
        chargeGif(4);
    }//GEN-LAST:event_btnTitan5ActionPerformed

    private void btnTitan6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitan6ActionPerformed
        // TODO add your handling code here:
        chargeGif(5);
    }//GEN-LAST:event_btnTitan6ActionPerformed

    private void btnTitan7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitan7ActionPerformed
        // TODO add your handling code here:
        chargeGif(6);
    }//GEN-LAST:event_btnTitan7ActionPerformed

    private void btnTitan8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTitan8ActionPerformed
        // TODO add your handling code here:
        chargeGif(7);
    }//GEN-LAST:event_btnTitan8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        SelectTitan selectTitan = new SelectTitan();
        selectTitan.openWindows(this);
        
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lobby.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lobby().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTitan1;
    private javax.swing.JButton btnTitan2;
    private javax.swing.JButton btnTitan3;
    private javax.swing.JButton btnTitan4;
    private javax.swing.JButton btnTitan5;
    private javax.swing.JButton btnTitan6;
    private javax.swing.JButton btnTitan7;
    private javax.swing.JButton btnTitan8;
    private javax.swing.JList<String> information;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGifImage;
    private javax.swing.JLabel lblLobbyBackground;
    // End of variables declaration//GEN-END:variables

    //<editor-fold desc="Chage image in the buttons" defaultstate="collapsed">
    private void chargeTitans() {
        
        for (int i = 0; i < titans.length; i++) {
            JButton btn = getButton(i+1);
            if(btn==null)break;
            
            if (titans[i] != null) {
                btn.setIcon(titans[i].getImageBig());

            } else {
                btn.setIcon(null);
                btn.setText("Coming soon...");
            }
        }

    }

    public void showInfo(int show) {

        Titan[] titans = methods.getTitans();
        if (show <= titans.length) {
            information.setModel(titans[show].toModel());
        }
    }
    //</editor-fold>

    @Override
    public void openWindow(JFrame frame) {
        this.setVisible(true);
        this.beforeWindow = (MainApp) frame;
        beforeWindow.setVisible(false);
    }

    @Override
    public void goBack() {
        this.dispose();
        beforeWindow.setVisible(true);
    }

    public void chargeGif(int icon) {
        if(titans[icon]==null){
            lblGifImage.setText("Coming soon...");
            lblGifImage.setIcon(null);
            DefaultListModel model= new DefaultListModel();
            model.addElement("No information available yet");
            information.setModel(model);
        }else{
            lblGifImage.setText("");
            lblGifImage.setIcon(titans[icon].getGif());
            information.setModel(titans[icon].toModel());
        }
    }

    public JButton getButton(int select) {
        switch (select) {
            case 1: {
                return btnTitan1;
            }
            case 2: {
                return btnTitan2;
            }
            case 3: {
                return btnTitan3;
            }
            case 4: {
                return btnTitan4;
            }
            case 5: {
                return btnTitan5;
            }
            case 6: {
                return btnTitan6;
            }
            case 7: {
                return btnTitan7;
            }
            case 8: {
                return btnTitan8;
            }
        }
        return null;
    }

}
