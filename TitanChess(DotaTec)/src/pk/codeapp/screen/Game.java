package pk.codeapp.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pk.codeapp.methods.DefaultRules;
import pk.codeapp.model.Path;

public class Game extends javax.swing.JFrame  implements DefaultRules, ActionListener,Runnable{
    //Inicialization of Variables
    private SelectTitan selectTitan;
    private String elementArena;
    private int columnGame;
    private int rowGame;
    public Game() {
        initComponents();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGame = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelGame.setBorder(new javax.swing.border.MatteBorder(null));
        jPanelGame.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanelGame.setMinimumSize(new java.awt.Dimension(1280, 720));
        jPanelGame.setName(""); // NOI18N
        jPanelGame.setOpaque(false);
        jPanelGame.setPreferredSize(new java.awt.Dimension(1280, 720));

        javax.swing.GroupLayout jPanelGameLayout = new javax.swing.GroupLayout(jPanelGame);
        jPanelGame.setLayout(jPanelGameLayout);
        jPanelGameLayout.setHorizontalGroup(
            jPanelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1278, Short.MAX_VALUE)
        );
        jPanelGameLayout.setVerticalGroup(
            jPanelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 600));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 130, 50));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/BackgroundLand.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 630, 50, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        goBack();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.setVisible(true);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }
    private void paintBackground(String elementArena){ // Paint The arena of type respective
        System.out.println(elementArena);
        switch(elementArena){
            
            case "Fire": {lblBackground.setIcon(new ImageIcon("src/pk/codeapp/tools/BackgroundFire.jpg"));
            break;
            }
            case "Land": {lblBackground.setIcon(new ImageIcon("src/pk/codeapp/tools/BackgroundLand.jpg"));break;}
            case "Wind":{ lblBackground.setIcon(new ImageIcon("src/pk/codeapp/tools/BackgroundWind.jpg"));break;}
            case "Aqua":{ lblBackground.setIcon(new ImageIcon("src/pk/codeapp/tools/BackgroundAqua.jpg")); break;}
        }
    }
    @Override
    public void openWindow(JFrame frame) {
       selectTitan=(SelectTitan)frame;
       frame.setVisible(false);
       this.setVisible(true);
       columnGame=selectTitan.getColumnGame();
       rowGame=selectTitan.getRowGame();
       this.elementArena=selectTitan.getElementOfArena(); // Obtain the type of element arena
       // paintBackground(elementArena);
        paintTabletoTowers(jPanelGame);
    }

    @Override
    public void goBack() {
        this.dispose();
        selectTitan.setVisible(true);
    }
      private void paintTabletoTowers(JPanel panel) { //Methods to paint matrix of table(Only part of player)
        panel.setLayout(new java.awt.GridLayout(rowGame,columnGame));
        int column = columnGame, row = rowGame;
        int midGame=(columnGame/2)+1;
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                if (i>=midGame){
                Path temp = new Path(i,j);
                temp.addActionListener(this);
                temp.setVisible(true);
                temp.setBackground(java.awt.Color.GRAY);
                panel.add(temp);
                }else{
                Path temp = new Path(i,j);
                temp.addActionListener(this);
                temp.setVisible(true);
                temp.setBackground(java.awt.Color.lightGray);
                panel.add(temp);}
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanelGame;
    private javax.swing.JLabel lblBackground;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void run() {
        
    }
}
