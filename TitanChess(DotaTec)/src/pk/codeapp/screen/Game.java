package pk.codeapp.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import pk.codeapp.methods.DefaultRules;
import pk.codeapp.methods.GameSettings;
import pk.codeapp.model.Dupla;
import pk.codeapp.model.Estadistics;
import pk.codeapp.model.GraphicsElement;
import pk.codeapp.model.Path;
import pk.codeapp.model.Titan;
import pk.codeapp.model.Tower;
import pk.codeapp.model.User;
import static pk.codeapp.screen.MainApp.methods;

public class Game extends javax.swing.JFrame implements DefaultRules, ActionListener, Runnable
{

    //Inicialization of Variables
    AuxAttackMode auxWindowstoAttack = new AuxAttackMode();
    private SelectTitan selectTitan;  // Before Windows
    private String elementArena;
    private int columnGame;
    private int rowGame;
    private int contTimeToDead = 0; // Cont the turn that pass to restart Titan
    private int contTowersP1;
    private int contTowersP2;
    private Titan titan2;
    private boolean deadTitan = false; // boolean to  check dead Titan
    private int contMovesTitan;//Cont the moves has actualTitan  
    private Titan actualTitan; // Titan actual clicked
    private boolean running; // thread Game)
    private boolean turnOfPlayer; // Define turn of player
    private String actionToRealice; // Action to  realize the player
    private int half = columnGame / 2; // Half Game
    private Path backupButton; // Backup the button to move
    private Thread thread; // Main thread Game 
    private GraphicsElement[][] graphicsElements = MainApp.methods.getGraphicsElements(); // Matrix of Game
    private ArrayList<Path> buttons = new ArrayList(); // List of buttons
    private GameSettings gameSettings = new GameSettings(MainApp.methods); // Methods to Game

    Titan titans[];
    private String mode;

    public Game()
    {
        initComponents();
          jPlife.setVisible(false);
         jPMana.setVisible(false);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {

                methods.writeUser();
                System.exit(0);
            }
        });
        mode = "pasive";
        btnAttack.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanelGame = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnEndTurn = new javax.swing.JButton();
        btnAttack = new javax.swing.JButton();
        paneTurn = new javax.swing.JPanel();
        lblShowTurn = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPlife = new javax.swing.JProgressBar();
        jPMana = new javax.swing.JProgressBar();
        lblPictureTitan = new javax.swing.JLabel();
        lblShowName = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
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

        getContentPane().add(jPanelGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 590));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 590, 130, 50));

        btnEndTurn.setBackground(new java.awt.Color(0, 0, 0));
        btnEndTurn.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        btnEndTurn.setForeground(new java.awt.Color(255, 255, 255));
        btnEndTurn.setText("End Turn");
        btnEndTurn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEndTurnActionPerformed(evt);
            }
        });
        getContentPane().add(btnEndTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 660, 130, 50));

        btnAttack.setBackground(new java.awt.Color(51, 51, 51));
        btnAttack.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        btnAttack.setForeground(new java.awt.Color(255, 255, 255));
        btnAttack.setText("Attack");
        btnAttack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAttackActionPerformed(evt);
            }
        });
        getContentPane().add(btnAttack, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 600, 130, 50));

        paneTurn.setBackground(new java.awt.Color(51, 51, 51));
        paneTurn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblShowTurn.setBackground(new java.awt.Color(51, 51, 51));
        lblShowTurn.setFont(new java.awt.Font("Century Schoolbook L", 1, 36)); // NOI18N
        lblShowTurn.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout paneTurnLayout = new javax.swing.GroupLayout(paneTurn);
        paneTurn.setLayout(paneTurnLayout);
        paneTurnLayout.setHorizontalGroup(
            paneTurnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneTurnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblShowTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        paneTurnLayout.setVerticalGroup(
            paneTurnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneTurnLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(lblShowTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(paneTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 650, -1, 50));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPlife.setBackground(new java.awt.Color(153, 153, 153));
        jPlife.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jPlife.setForeground(new java.awt.Color(0, 0, 0));
        jPlife.setStringPainted(true);
        jPanel1.add(jPlife, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 420, 30));

        jPMana.setBackground(new java.awt.Color(153, 153, 153));
        jPMana.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jPMana.setForeground(new java.awt.Color(0, 0, 0));
        jPMana.setStringPainted(true);
        jPanel1.add(jPMana, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 420, 30));

        lblPictureTitan.setBorder(new javax.swing.border.MatteBorder(null));
        lblPictureTitan.setMaximumSize(new java.awt.Dimension(80, 80));
        lblPictureTitan.setMinimumSize(new java.awt.Dimension(80, 80));
        lblPictureTitan.setName(""); // NOI18N
        lblPictureTitan.setPreferredSize(new java.awt.Dimension(242, 121));
        lblPictureTitan.setRequestFocusEnabled(false);
        jPanel1.add(lblPictureTitan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblShowName.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        lblShowName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lblShowName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 340, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 720, 130));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/BackgroundLand.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

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

    private void btnEndTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndTurnActionPerformed

        
        actionToRealice = "move";
        mode = "pasive";
        changePlayer();


    }//GEN-LAST:event_btnEndTurnActionPerformed

    private void btnAttackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAttackActionPerformed
    {//GEN-HEADEREND:event_btnAttackActionPerformed
        // TODO add your handling code here:
        mode = "attack";
        JOptionPane.showMessageDialog(rootPane, "Select your enemy!","Information",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAttackActionPerformed
    private void viewTitan(){
         // View titan 
        lblPictureTitan.setIcon(null);
         //Life
         jPlife.setVisible(false);
         jPMana.setVisible(false);
        jPlife.setMaximum(0);
        jPlife.setValue(0);
        jPlife.setStringPainted(true);
        jPlife.setString("Life");
        //Mana
        jPMana.setMaximum(0);
        jPMana.setValue(0);
        jPMana.setStringPainted(true);
        jPMana.setString("Mana");
        
    }
    private void changePlayer() // Change turn of game
    {
         increaseMana();
         viewTitan();
        btnAttack.setEnabled(false);
        if (turnOfPlayer) { //Player 1  - Player 2
            turnOfPlayer = false;
            JOptionPane.showMessageDialog(rootPane, "Turn Player 2");
            lblShowTurn.setText("Turn Player 2");
            paneTurn.setBackground(java.awt.Color.blue);
        } else { //Player 2  - Player 1
            turnOfPlayer = true;
            JOptionPane.showMessageDialog(rootPane, "Turn Player 1");
            lblShowTurn.setText("Turn Player 1");
            paneTurn.setBackground(java.awt.Color.red);
        }
        if (deadTitan) {
            System.out.println(contTimeToDead);
            this.contTimeToDead++;
        }
    }

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
    }

    /**
     * Get elementArena to check the image
     *
     * @param elementArena
     */
    private void paintBackground(String elementArena)
    { // Paint The arena of type respective

        switch (elementArena) {

            case "Fire": {
                lblBackground.setIcon(new ImageIcon("src/pk/codeapp/tools/BackgroundFire.jpg"));
                break;
            }
            case "Land": {
                lblBackground.setIcon(new ImageIcon("src/pk/codeapp/tools/BackgroundLand.jpg"));
                break;
            }
            case "Wind": {
                lblBackground.setIcon(new ImageIcon("src/pk/codeapp/tools/BackgroundWind.jpg"));
                break;
            }
            case "Aqua": {
                lblBackground.setIcon(new ImageIcon("src/pk/codeapp/tools/BackgroundAqua.jpg"));
                break;
            }
        }
    }

    @Override
    public void openWindow(JFrame frame)
    {
        selectTitan = (SelectTitan) frame;
        frame.setVisible(false);
        this.setVisible(true);
        columnGame = MainApp.methods.getColumnGame();
        rowGame = MainApp.methods.getRowGame();
        this.elementArena = selectTitan.getElementOfArena(); // Obtain the type of element arena
        paintBackground(elementArena); // Paint Background 
        paintTable(jPanelGame); //Paint table

        paintTowersGame(); // Paint towers and titans in the game
        paintStartTitans(); //Paint and set posicions in the game

        start();
    }

    @Override
    public void goBack()
    {
        this.dispose();
        selectTitan.goBack();
    }

    private void paintTowersGame()
    { //Paint tower in the table
        for (int j = 0; j < rowGame; j++) {
            for (int i = 0; i < columnGame; i++) {
                if (graphicsElements[i][j] instanceof Tower) {
                    Tower tower = (Tower) graphicsElements[i][j];
                    if (tower.getTowerPlayer().equals("player2")) {
                        Path buttonToPaint = gameSettings.searchButtonToPaint(buttons, tower.getPosition().getColumn(), tower.getPosition().getRow()); //Methods to return the button

                        buttonToPaint.setIcon(tower.getIcon());
                    } else {
                        Path buttonToPaint = gameSettings.searchButtonToPaint(buttons, tower.getPosition().getColumn(), tower.getPosition().getRow()); //Methods to return the button
                        buttonToPaint.setIcon(tower.getIcon());
                    }

                }
            }
        }
    }

    private void paintStartTitans()
    { //Paint start champions in the table
        titans = MainApp.methods.getTitans();
        for (int i = 0; i < titans.length; i++) {

            Titan titan = titans[i];
            if (titan != null) {

                if (titan.getPlayer().equals("Player2")) {
                    if (getPositionOfTitan("player2") != null) {

                        Dupla dupla = getPositionOfTitan("player2");
                        titan.setDupla(dupla);
                        graphicsElements[titan.getDupla().getColumn()][titan.getDupla().getRow()] = titan; // Set  titan in new Position in the matrix of game 
                        Path buttonToPaint = gameSettings.searchButtonToPaint(buttons, titan.getDupla().getColumn(), titan.getDupla().getRow()); //Methods to return the button

                        buttonToPaint.setIcon(titan.getTiny());
                        buttonToPaint.setBackground(java.awt.Color.blue);
                    }
                } else {
                    if (getPositionOfTitan("player1") != null) {

                        Dupla dupla = getPositionOfTitan("player1");
                        titan.setDupla(dupla);
                        graphicsElements[titan.getDupla().getColumn()][titan.getDupla().getRow()] = titan; // Set  titan in new Position in the matrix of game 
                        Path buttonToPaint = gameSettings.searchButtonToPaint(buttons, titan.getDupla().getColumn(), titan.getDupla().getRow()); //Methods to return the button

                        buttonToPaint.setIcon(titan.getTiny());
                        buttonToPaint.setBackground(java.awt.Color.red);
                    }

                }

            }
        }
    }

    private Dupla getPositionOfTitan(String player)
    {
        for (int j = 0; j < rowGame; j++) {
            for (int i = 0; i < columnGame; i++) {
                if (graphicsElements[i][j] instanceof Tower) {
                    Tower tower = (Tower) graphicsElements[i][j];

                    if (tower.getTowerPlayer().equals(player)) {

                        if (graphicsElements[i][j + 1] == null) {

                            return new Dupla(i, j + 1);
                        } else if (graphicsElements[i][j - 1] == null) {

                            return new Dupla(i, j - 1);
                        } else if (graphicsElements[i - 1][j] == null) {
                            return new Dupla(i - 1, j);
                        }
                    }
                }
            }
        }
        return null;
    }

    private void paintTable(JPanel panel)
    { //Methods to paint matrix of table(Only part of player)
        panel.setLayout(new java.awt.GridLayout(rowGame, columnGame));
        int column = columnGame, row = rowGame;
        int midGame = (columnGame / 2);
        for (int j = 0; j < row; j++) {
            for (int i = 0; i < column; i++) {
                if (i >= midGame) { //Paint the player 1 with gray
                    Path temp = new Path(i, j);
                    buttons.add(temp); // Add path in the list of buttons
                    temp.addActionListener(this);
                    temp.setVisible(true);
                    temp.setBackground(java.awt.Color.GRAY);
                    panel.add(temp);
                } else { //Paint the player 2 with Light gray
                    Path temp = new Path(i, j);
                    buttons.add(temp); // Add path in the list of buttons
                    temp.addActionListener(this);
                    temp.setVisible(true);
                    temp.setBackground(java.awt.Color.lightGray);
                    panel.add(temp);
                }
            }
        }
        gameSettings.setButtons(buttons); // Save buttons in the gameSettings
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAttack;
    private javax.swing.JButton btnEndTurn;
    private javax.swing.JButton jButton1;
    private javax.swing.JProgressBar jPMana;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelGame;
    private javax.swing.JProgressBar jPlife;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblPictureTitan;
    private javax.swing.JLabel lblShowName;
    private javax.swing.JLabel lblShowTurn;
    private javax.swing.JPanel paneTurn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e)
    { // Click in the mouse

        if (mode.equals("attack")) {
            enterAttackMode(e);
        } else {
            Path temp = (Path) e.getSource();
            int column = temp.getColumn();
            int row = temp.getRow();
            if (actionToRealice.equals("move")) { //Move
                if (turnOfPlayer) {
                    moveTitan("Player1", column, row, temp);
                } else {
                    moveTitan("Player2", column, row, temp);
                }
            } else if (actionToRealice.equals("movePosition")) {
                if (gameSettings.isSomebodyHere(column, row, graphicsElements)) {
                    movePosition(column, row, temp);
                }
            }
        }

    }


  

    private void increaseMana(){
        for (int j = 0; j < rowGame; j++) {
            for (int i = 0; i < columnGame; i++) {
            if(graphicsElements[i][j] instanceof Titan){
                Titan titan =(Titan)graphicsElements[i][j];
                int mana = titan.getMana();
                mana*=0.25;
                titan.setMana(titan.getMana()+mana);
                graphicsElements[i][j]=titan;
            }
            }}

    }

    private void movePosition(int column, int row, Path temp)
    { // Move Position of titan
        System.out.println("Entro a move Position" + " El contador es: " + contMovesTitan);
        if (contMovesTitan > 0) {

            if (gameSettings.checkRange(column, row, actualTitan)) { //Check range of titan

                graphicsElements[actualTitan.getDupla().getColumn()][actualTitan.getDupla().getRow()] = null; // Delete before position
                actualTitan.setDupla(new Dupla(column, row));
                backupButton.setIcon(null);
                if (backupButton.getColumn() > (methods.getColumnGame() / 2 - 1)) {
                    backupButton.setBackground(java.awt.Color.gray);
                } else {
                    backupButton.setBackground(null);
                }
                graphicsElements[column][row] = actualTitan; //set actual position in the matrix
                backupButton = temp;
                temp.setIcon(actualTitan.getTiny());
                if (actualTitan.getPlayer().equals("Player1")) {
                    temp.setBackground(java.awt.Color.red);
                } else {
                    temp.setBackground(java.awt.Color.blue);
                }

                contMovesTitan--;
                btnAttack.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Titan does not have more movements");
        }
    }
    /**
     * Methods to move the titan 
     * @param player
     * @param column
     * @param row
     * @param temp 
     */
    private void moveTitan(String player, int column, int row, Path temp)
    { // Methods to move titan 
        if (graphicsElements[column][row] instanceof Titan) {
            Titan titan = (Titan) graphicsElements[column][row];
            if (titan.getPlayer().equals(player)) {
                viewTitan(titan); 
                contMovesTitan = titan.getMoves();
                backupButton = temp; // Backup the button to move
                actualTitan = titan; // set Actual Titan
                JOptionPane.showMessageDialog(rootPane, "Move the Titan |All Movement " + titan.getMoves()); //Message to Move
                btnAttack.setEnabled(true);
                actionToRealice = "movePosition"; //set action to Moviment titan
            }
        }
    }
    
    private void viewTitan(Titan titan){
         jPlife.setVisible(true);
         jPMana.setVisible(true);
         jPlife.setMaximum(0);
          jPMana.setMaximum(0);
        lblPictureTitan.setIcon(titan.getImageBig());
         //Life
        jPlife.setMaximum(titan.getMaxLife());
        jPlife.setValue(titan.getLife());
        jPlife.setStringPainted(true);
        jPlife.setString("Life");
        //Mana
        jPMana.setMaximum(titan.getMaxMana());
        jPMana.setValue(titan.getMana());
        jPMana.setStringPainted(true);
        jPMana.setString("Mana");
    }
    public void obtainQuantityTower(int contTowersP1, int contTowersP2)
    {


        int index = searchUserToEdit(methods.getActual());
        int played = methods.getPlayers().get(index).getUserEstadistics().getPlayedGames();
        methods.getPlayers().get(index).getUserEstadistics().setPlayedGames(played+1);

        index = searchUserToEdit(methods.getPlayer2());
        played = methods.getPlayers().get(index).getUserEstadistics().getPlayedGames();
        methods.getPlayers().get(index).getUserEstadistics().setPlayedGames(played+1);


        System.out.println("Player 1 Towers: "+contTowersP1);
        System.out.println("Player 2 Towers: "+contTowersP2);

        this.contTowersP1 = contTowersP1;
        this.contTowersP2 = contTowersP2;

    }

    private void whoWin()
    {
       System.out.println("Tower Player 1: "+contTowersP1);
       System.out.println("Tower Player 2: " + contTowersP2);
        if (contTowersP1 == 0) {
            JOptionPane.showMessageDialog(rootPane, "Congratulations Player 1, you've won.");
           
            this.dispose();
            selectTitan.goBack();
           return;
            /// 
        
        } else if (contTowersP2 == 0) {
            JOptionPane.showMessageDialog(rootPane, "Congratulations Player 2, you've won.");
            this.dispose();
            selectTitan.goBack();
            return;
            // 
        }
    }

    private void whoDead()
    { //Methods to titans is dead
        if (deadTitan) {
            if (contTimeToDead == 4) { //Before to 1 turn paint and add titan in the matrix

                if (titan2.getPlayer().equals("Player1")) {

                    Dupla dupla = getPositionOfTitan("player1");
                    titan2.setDupla(dupla);

                } else {

                    Dupla dupla = getPositionOfTitan("player2");
                    titan2.setDupla(dupla);
                }
                titan2.setLife(titan2.getMaxLife());
                titan2.setMana(titan2.getMaxMana());
                graphicsElements[titan2.getDupla().getColumn()][titan2.getDupla().getRow()] = titan2;
                Path path = gameSettings.searchButtonToPaint(buttons, titan2.getDupla().getColumn(), titan2.getDupla().getRow());
                path.setIcon(titan2.getTiny());
                if (titan2.getPlayer().equals("Player1")) {
                    path.setBackground(java.awt.Color.red);
                } else {
                    path.setBackground(java.awt.Color.blue);
                }
                contTimeToDead = 0;
                deadTitan = false;
            }
        }
    }

    // Start Thread of Game 
    private void init()
    { // Inicialization of Varaibles
        //Start Game 
        actionToRealice = "move";
        int playerStart = gameSettings.getRadom(2);
        if (playerStart == 0) { //Player 1  
            turnOfPlayer = true;
            JOptionPane.showMessageDialog(rootPane, "Turn Player 1");
            lblShowTurn.setText("Turn Player 1");
            paneTurn.setBackground(java.awt.Color.red);
        } else { //Player 2
            turnOfPlayer = false;
            JOptionPane.showMessageDialog(rootPane, "Turn Player 2");
            lblShowTurn.setText("Turn Player 2");
            paneTurn.setBackground(java.awt.Color.blue);
        }

    }

    private void tick()
    { // Variables

        whoWin();
        whoDead();
    }

    private void render()
    { // Graphics

    }

    @Override
    public void run()
    {
        init();
        while (running) { // Main Loop

            tick();
            render();
        }
        stop();
    }

    public synchronized void start()
    {

        if (running) {
            return;
        }
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()
    {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();

        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method receives an ActionEvent to realize the attack
     *
     * @param e
     */
    private void enterAttackMode(ActionEvent e)
    {
        Path path = (Path) e.getSource();

        if (!gameSettings.isSomebodyHere(path.getColumn(), path.getRow(), graphicsElements)) {
            int column = path.getColumn();
            int row = path.getRow();
            if (gameSettings.checkRange(column, row, actualTitan)) {
                if (graphicsElements[column][row] instanceof Tower) {
                    Tower tower = (Tower) graphicsElements[column][row];
                    if (!tower.getTowerPlayer().equalsIgnoreCase(actualTitan.getPlayer())) {

                        auxWindowstoAttack.getToolsToAttack(actualTitan, tower, this, elementArena);

                    }
                } else {
                    Titan titan = (Titan) graphicsElements[column][row];
                    if (!titan.getPlayer().equalsIgnoreCase(actualTitan.getPlayer())) {

                        auxWindowstoAttack.getToolsToAttack(actualTitan, titan, this, elementArena);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "out of range");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "there is nobody there");
        }
    }

    public void changeStates(GraphicsElement element)
    {
        Dupla dupla;
        if (element instanceof Tower) {
            if (((Tower) element).getQuantityStamina() == 0) {
                Tower tower = (Tower)element;
                if (tower.getTowerPlayer().equals("player1")) {
                    contTowersP1--;
                } else {
                    contTowersP2--;
                }
                dupla = ((Tower) element).getPosition();
                graphicsElements[dupla.getColumn()][dupla.getRow()] = null;
                Path path = gameSettings.searchButtonToPaint(buttons, dupla.getColumn(), dupla.getRow());

                path.setIcon(new ImageIcon("src/pk/codeapp/tools/deletetower.png"));
                path.setEnabled(false);
            }
        } else {
            if (element instanceof Titan) {
                int midGame = (columnGame / 2);
                if (((Titan) element).getLife() == 0) {
                    increaseEstadistics((Titan) element);
                    titan2 = (Titan) element;
                    dupla = element.getDupla();
                    deadTitan = true;
                    graphicsElements[dupla.getColumn()][dupla.getRow()] = null;
                    Path path = gameSettings.searchButtonToPaint(buttons, dupla.getColumn(), dupla.getRow());
                    path.setIcon(null);
                    if (path.getColumn() > midGame - 1) {
                        path.setBackground(java.awt.Color.gray);
                    } else {
                        path.setBackground(java.awt.Color.lightGray);
                    }
                }
            }
        }
        actionToRealice = "move";
        mode = "pasive";
        changePlayer();
    }

    private void increaseEstadistics(Titan titan)
    {
        if (titan.getPlayer().equals("Player1")) {
            int index = searchUserToEdit(methods.getActual());
            Estadistics estadistics = methods.getPlayers().get(index).getUserEstadistics();
            estadistics.setDeadTitans(estadistics.getDeadTitans() + 1);
            methods.getPlayers().get(index).setUserEstadistics(estadistics);
        } else {
            int index = searchUserToEdit(methods.getPlayer2());
            Estadistics estadistics = methods.getPlayers().get(index).getUserEstadistics();
            estadistics.setDeadTitans(estadistics.getDeadTitans() + 1);
            methods.getPlayers().get(index).setUserEstadistics(estadistics);
        }
    }

    public int searchUserToEdit(User user)
    {
        ArrayList<User> users = methods.getPlayers();
        for (int i = 0; i < users.size(); i++) {
            if (user.equals(users.get(i))) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}
