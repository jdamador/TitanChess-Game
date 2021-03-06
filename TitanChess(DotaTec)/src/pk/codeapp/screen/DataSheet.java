/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.screen;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import pk.codeapp.methods.DefaultRules;
import pk.codeapp.model.Estadistics;
import pk.codeapp.model.User;
import static pk.codeapp.screen.MainApp.methods;

/**
 *
 * @author Daniel Amador
 */
public class DataSheet extends javax.swing.JFrame implements DefaultRules
{

    Lobby beforeWindow;
    Estadistics actual;

    /**
     * Creates new form DataSheet
     */
    public DataSheet()
    {
        initComponents();
        //<editor-fold defaultstate="collapsed" desc="Charge information in the label">
        User us = MainApp.methods.getActual();
        actual = us.getUserEstadistics();
        System.out.println(actual);
        lblWinGames.setText(actual.getWinGames() + "");
        lblDeadTitans.setText(actual.getDeadTitans() + "");
        actual.calcPerformance();
        lblTowerDestroyed.setText(actual.getMyDeadTower() + "");
        lblGameLost.setText(actual.getLostGames() + "");
        lblGamesPlayed.setText(actual.getPlayedGames() + "");
        lblPerformance.setText(actual.getPerformance() + "%");
        lblDestroyedTower.setText(actual.getDrestroyTower() + "");
        //</editor-fold>
        this.setLocationRelativeTo(null);
        chargeKillsFromTitans();
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {

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

        jLabel24 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        image8 = new javax.swing.JLabel();
        image1 = new javax.swing.JLabel();
        image2 = new javax.swing.JLabel();
        image3 = new javax.swing.JLabel();
        image7 = new javax.swing.JLabel();
        image5 = new javax.swing.JLabel();
        image6 = new javax.swing.JLabel();
        image4 = new javax.swing.JLabel();
        data8 = new javax.swing.JLabel();
        data1 = new javax.swing.JLabel();
        data2 = new javax.swing.JLabel();
        data3 = new javax.swing.JLabel();
        data4 = new javax.swing.JLabel();
        data5 = new javax.swing.JLabel();
        data6 = new javax.swing.JLabel();
        data7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblDestroyedTower = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDeadTitans = new javax.swing.JLabel();
        lblTowerDestroyed = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblGamesPlayed = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblGameLost = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblWinGames = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblPerformance = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel24.setText("Kills:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GameMaster");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 80, 40));

        jPanel1.setBackground(new java.awt.Color(0, 77, 64));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/titans/Icons/titan8.png"))); // NOI18N
        image8.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(image8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 80, 80));

        image1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/titans/Icons/titan1.jpg"))); // NOI18N
        image1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(image1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 80));

        image2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/titans/Icons/titan2.jpg"))); // NOI18N
        image2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(image2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 80, 80));

        image3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/titans/Icons/titan3.jpg"))); // NOI18N
        image3.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(image3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 80, 80));

        image7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/titans/Icons/titan7.png"))); // NOI18N
        image7.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(image7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 80, 80));

        image5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/titans/Icons/titan5.jpg"))); // NOI18N
        image5.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(image5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, 80));

        image6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/titans/Icons/titan6.png"))); // NOI18N
        image6.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(image6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 80, 80));

        image4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/titans/Icons/titan4.jpg"))); // NOI18N
        image4.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.add(image4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 80, 80));

        data8.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        data8.setForeground(new java.awt.Color(255, 255, 255));
        data8.setText("Kills:");
        jPanel1.add(data8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        data1.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        data1.setForeground(new java.awt.Color(255, 255, 255));
        data1.setText("Kills:");
        jPanel1.add(data1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        data2.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        data2.setForeground(new java.awt.Color(255, 255, 255));
        data2.setText("Kills:");
        jPanel1.add(data2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        data3.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        data3.setForeground(new java.awt.Color(255, 255, 255));
        data3.setText("Kills:");
        jPanel1.add(data3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        data4.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        data4.setForeground(new java.awt.Color(255, 255, 255));
        data4.setText("Kills:");
        jPanel1.add(data4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        data5.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        data5.setForeground(new java.awt.Color(255, 255, 255));
        data5.setText("Kills:");
        jPanel1.add(data5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        data6.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        data6.setForeground(new java.awt.Color(255, 255, 255));
        data6.setText("Kills:");
        jPanel1.add(data6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        data7.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        data7.setForeground(new java.awt.Color(255, 255, 255));
        data7.setText("Kills:");
        jPanel1.add(data7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 520, 270));

        jPanel3.setBackground(new java.awt.Color(0, 77, 64));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Number of destroyed tower :");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 50));

        lblDestroyedTower.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDestroyedTower.setForeground(new java.awt.Color(255, 255, 255));
        lblDestroyedTower.setText("destroyedTower");
        jPanel3.add(lblDestroyedTower, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Number of own towers destroyed:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Number of dead Titans:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        lblDeadTitans.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDeadTitans.setForeground(new java.awt.Color(255, 255, 255));
        lblDeadTitans.setText("deadTitans");
        jPanel3.add(lblDeadTitans, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, -1));

        lblTowerDestroyed.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTowerDestroyed.setForeground(new java.awt.Color(255, 255, 255));
        lblTowerDestroyed.setText("towersDestroyed");
        jPanel3.add(lblTowerDestroyed, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 670, 220));

        jPanel2.setBackground(new java.awt.Color(0, 77, 64));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Number of games played:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblGamesPlayed.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblGamesPlayed.setForeground(new java.awt.Color(255, 255, 255));
        lblGamesPlayed.setText("gamesPlayed");
        jPanel2.add(lblGamesPlayed, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Number of games lost:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblGameLost.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblGameLost.setForeground(new java.awt.Color(255, 255, 255));
        lblGameLost.setText("gameLost");
        jPanel2.add(lblGameLost, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Number of win games:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        lblWinGames.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblWinGames.setForeground(new java.awt.Color(255, 255, 255));
        lblWinGames.setText("winGames");
        jPanel2.add(lblWinGames, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Performance:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        lblPerformance.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPerformance.setForeground(new java.awt.Color(255, 255, 255));
        lblPerformance.setText("performance");
        jPanel2.add(lblPerformance, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 520, 220));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/estadistics.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
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
            java.util.logging.Logger.getLogger(DataSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new DataSheet().setVisible(true);
            }
        });
    }
 // <editor-fold defaultstate="collapsed" desc="Variables">        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel data1;
    private javax.swing.JLabel data2;
    private javax.swing.JLabel data3;
    private javax.swing.JLabel data4;
    private javax.swing.JLabel data5;
    private javax.swing.JLabel data6;
    private javax.swing.JLabel data7;
    private javax.swing.JLabel data8;
    private javax.swing.JLabel image1;
    private javax.swing.JLabel image2;
    private javax.swing.JLabel image3;
    private javax.swing.JLabel image4;
    private javax.swing.JLabel image5;
    private javax.swing.JLabel image6;
    private javax.swing.JLabel image7;
    private javax.swing.JLabel image8;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblDeadTitans;
    private javax.swing.JLabel lblDestroyedTower;
    private javax.swing.JLabel lblGameLost;
    private javax.swing.JLabel lblGamesPlayed;
    private javax.swing.JLabel lblPerformance;
    private javax.swing.JLabel lblTowerDestroyed;
    private javax.swing.JLabel lblWinGames;
    // End of variables declaration//GEN-END:variables
//</editor-fold>
    @Override
    public void openWindow(JFrame frame)
    {
        this.beforeWindow = (Lobby) frame;
        this.setVisible(true);
        beforeWindow.setVisible(false);
    }
    @Override
    public void goBack()
    {
        this.dispose();
        beforeWindow.setVisible(true);
    }

    public void chargeKillsFromTitans()
    {  
        JLabel[] data = {data1, data2, data3, data4, data5, data6, data7, data8};
        
        int[] kills = actual.getKills();
        for (int i = 0; i < kills.length; i++) {
          
            data[i].setText("Kills: " + kills[i]);
        }
    }
}
