/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.screen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pk.codeapp.methods.DefaultRules;
import pk.codeapp.model.Dupla;
import pk.codeapp.model.Path;
import pk.codeapp.model.Tower;

public class SelectionTower extends javax.swing.JFrame implements ActionListener, DefaultRules{

    //Inicialization of Variable
    private SelectTitan selectTitan;
    private int columnGame, rowGame;
    private int contTowersP1=0; // Cont of Towers to player 1
    private int contTowersP2=0; // Cont of Towers to player 2
    private int beforeColumn=-1; // Storage before column to clicked
    private int beforeRow=-1; // Storage before row to clicked
    public SelectionTower() {
        initComponents();
        this.setLocationRelativeTo(null); //Localization of Windows
         lblBackground.setIcon(new ImageIcon("src/pk/codeapp/tools/SelectTitan_Background.jpg")); // Image Background 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        towerPlayer1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select the Position of towers");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(360, 30, 620, 50);

        towerPlayer1.setOpaque(false);

        javax.swing.GroupLayout towerPlayer1Layout = new javax.swing.GroupLayout(towerPlayer1);
        towerPlayer1.setLayout(towerPlayer1Layout);
        towerPlayer1Layout.setHorizontalGroup(
            towerPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        towerPlayer1Layout.setVerticalGroup(
            towerPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        getContentPane().add(towerPlayer1);
        towerPlayer1.setBounds(0, 70, 1280, 590);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Player 2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(940, 110, 120, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Player 1");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(250, 110, 110, 30);

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 660, 110, 50);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/SelectTitan_Background.jpg"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        goBack();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SelectionTower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectionTower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectionTower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectionTower.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and disptowerPlayer1 form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectionTower().setVisible(true);
            }
        });
    }

   private void paintTabletoTowers(JPanel panel) { //Methods to paint matrix of table(Only part of player)
         panel.setLayout(new java.awt.GridLayout(rowGame,columnGame));
        int column = columnGame, row = rowGame;
        int midGame=(columnGame/2);
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                if(i==0 || j==0 || i==columnGame-1 || j== columnGame-1){
                 Path temp = new Path(i,j);
                temp.setEnabled(false);
                  
                 panel.add(temp);
                }
                else{
                if (i>=midGame){ //Paint the player 1 with gray
                Path temp = new Path(i,j);      
                temp.addActionListener(this);
                temp.setVisible(true);
        
                temp.setBackground(java.awt.Color.blue);
                panel.add(temp);
                }else{ //Paint the player 2 with Light gray
                Path temp = new Path(i,j);
                temp.addActionListener(this);
    
                temp.setVisible(true);
                temp.setBackground(java.awt.Color.red);
                panel.add(temp);}
            }}
        }
    }
    public void beforeWindows(SelectTitan window) { // Methods to obtain before Windows
        
        //Equals variables column and row
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JPanel towerPlayer1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e){ 
        Path temp = (Path) e.getSource();
        int half = columnGame/2;
        // each panel will have a difference of one pixel to calculate whith is clicked
        if(temp.getColumn()<=half){ //First Panel
            contTowersP1++;
            if(contTowersP1<=3){ // Check the num Tower is less than 3 (Panel 1)
            temp.setIcon(new ImageIcon("src/pk/codeapp/tools/tower.png"));
            temp.setEnabled(false);
            Tower newTower = new Tower(10000,new Dupla(temp.getColumn(),temp.getRow()),"player1");
            MainApp.methods.addTower(newTower);
            }else{return;}
        }
        else{ //Second Panel
            contTowersP2++;
            if(contTowersP2<=3){// Check the num Tower is less than 3 (Panel 2)
            temp.setIcon(new ImageIcon("src/pk/codeapp/tools/tower.png"));
            temp.setEnabled(false);
            Tower newTower = new Tower(10000,new Dupla(temp.getColumn(),temp.getRow()),"player2");
            MainApp.methods.addTower(newTower);
            }else{return;}}
        

        
    }

    @Override
    public void openWindow(JFrame frame) {
        selectTitan = (SelectTitan)frame;
        selectTitan.setVisible(false);
        this.setVisible(true);
        this.columnGame=selectTitan.getColumnGame();
        this.rowGame=selectTitan.getRowGame();
        paintTabletoTowers(towerPlayer1);

    }

    @Override
    public void goBack() {
       if(contTowersP1==0 || contTowersP2==0){
            JOptionPane.showMessageDialog(rootPane,"Please select more towers in the diferents player( Minumum 1 tower for player)");
        }
        else{
        this.dispose();
        selectTitan.setVisible(true);}
    }

    

}
