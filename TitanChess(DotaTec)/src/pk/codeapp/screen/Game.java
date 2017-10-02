package pk.codeapp.screen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private int contTowersP1 = 0;
    private int contTowersP2 = 0;
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
    private Estadistics estadisticsPlayer1 = methods.getActual().getUserEstadistics();
    private Estadistics estadisticsPlayer2 = methods.getPlayer2().getUserEstadistics();
    Titan titans[];
    private String mode;
    private Titan[] titansDead = new Titan[4];
    private int timeDead1 = -1; // Cont the turn that pass to restart Titanwa
    private int timeDead2 = -1;
    private int timeDead3 = -1;
    private int timeDead4 = -1;
    ImageIcon player1Icon = new ImageIcon("src/pk/codeapp/tools/player1.png");
    ImageIcon player2Icon = new ImageIcon("src/pk/codeapp/tools/player2.jpg");
    ImageIcon steeps = new ImageIcon("src/pk/codeapp/tools/steeps.jpg");
    ImageIcon winner = new ImageIcon("src/pk/codeapp/tools/winner.jpg");

    /**
     * Default constructor
     */
    public Game()
    {
        initComponents();
        jPLife.setVisible(false);
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
        jPLife = new javax.swing.JProgressBar();
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 670, 130, 50));

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
        getContentPane().add(btnEndTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 590, 130, 50));

        btnAttack.setBackground(new java.awt.Color(0, 0, 0));
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
        getContentPane().add(btnAttack, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 590, 130, 50));

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

        getContentPane().add(paneTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 640, -1, 50));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPLife.setBackground(new java.awt.Color(0, 153, 102));
        jPLife.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jPLife.setForeground(new java.awt.Color(0, 153, 102));
        jPLife.setToolTipText("");
        jPLife.setBorder(null);
        jPLife.setName(""); // NOI18N
        jPLife.setOpaque(false);
        jPLife.setRequestFocusEnabled(false);
        jPLife.setString("");
        jPLife.setStringPainted(true);
        jPLife.setVerifyInputWhenFocusTarget(false);
        jPanel1.add(jPLife, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 420, 30));

        jPMana.setBackground(new java.awt.Color(102, 255, 255));
        jPMana.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jPMana.setForeground(new java.awt.Color(102, 255, 255));
        jPMana.setBorder(null);
        jPMana.setOpaque(false);
        jPMana.setString("");
        jPMana.setStringPainted(true);
        jPMana.setVerifyInputWhenFocusTarget(false);
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
        JOptionPane.showMessageDialog(rootPane, "Select your enemy!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnAttackActionPerformed

    /**
     * Inicialices the labesl in null
     */
    private void viewTitan()
    {
        // View titan 
        lblPictureTitan.setIcon(null);
        lblShowName.setText(null);
        //Life
        jPLife.setVisible(false);
        jPMana.setVisible(false);
    }

    /**
     * This methods change de turn of the each player
     */
    private void changePlayer() // Change turn of game
    {

        viewTitan();
        btnAttack.setEnabled(false);
        if (turnOfPlayer) { //Player 1  - Player 2
            turnOfPlayer = false;
            increaseMana("Player1");
            JOptionPane.showMessageDialog(rootPane, "Turn Player 2", "Change of turn ", JOptionPane.INFORMATION_MESSAGE, player2Icon);
            lblShowTurn.setText("Turn Player 2");

            paneTurn.setBackground(java.awt.Color.blue);
        } else { //Player 2  - Player 1
            increaseMana("Player2");
            turnOfPlayer = true;
            JOptionPane.showMessageDialog(rootPane, "Turn Player 1", "Change of turn ", JOptionPane.INFORMATION_MESSAGE, player1Icon);
            lblShowTurn.setText("Turn Player 1");
            paneTurn.setBackground(java.awt.Color.red);
        }
        //Verify that one titan is dead
        System.out.println(timeDead1 + " " + timeDead2 + " " + timeDead3 + " " + timeDead4);

        timeDead1--;
        timeDead2--;
        timeDead3--;
        timeDead4--;
        whoDead();
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
     * Receives the element and set background
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

    /**
     * Default operation to open this windows
     *
     * @param frame
     */
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

    /**
     * this method paint the diferents tower in the board
     */
    private void paintTowersGame()
    { //Paint tower in the table
        for (int j = 0; j < rowGame; j++) {
            for (int i = 0; i < columnGame; i++) {
                if (graphicsElements[i][j] instanceof Tower) {
                    Tower tower = (Tower) graphicsElements[i][j];
                    if (tower.getTowerPlayer().equals("player2")) {
                        Path buttonToPaint = gameSettings.searchButtonToPaint(buttons, tower.getPosition().getColumn(), tower.getPosition().getRow()); //Methods to return the button
                        buttonToPaint.setText(tower.getQuantityStamina() + "");
                        buttonToPaint.setHorizontalTextPosition(0);
                        buttonToPaint.setFont(new java.awt.Font("Dialog", 1, 14));
                        buttonToPaint.setForeground(Color.red);
                        buttonToPaint.setIcon(tower.getIcon());
                    } else {
                        Path buttonToPaint = gameSettings.searchButtonToPaint(buttons, tower.getPosition().getColumn(), tower.getPosition().getRow()); //Methods to return the button
                        buttonToPaint.setIcon(tower.getIcon());
                        buttonToPaint.setText(tower.getQuantityStamina() + "");
                        buttonToPaint.setHorizontalTextPosition(0);
                        buttonToPaint.setFont(new java.awt.Font("Dialog", 1, 14));
                        buttonToPaint.setForeground(Color.red);
                    }
                }
            }
        }
    }

    /**
     * paint the start position the all titans work with the array that contains
     * the graphics elements
     */
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

    /**
     * This methods optain the new position to element in the array and board
     * receives the player
     *
     * @param player
     * @return the Dupla with new column and row
     */
    private Dupla getPositionOfTitan(String player)
    {
        Dupla aux = null;
        for (int j = 0; j < rowGame; j++) {
            for (int i = 0; i < columnGame; i++) {
                if (graphicsElements[i][j] instanceof Tower) {
                    Tower tower = (Tower) graphicsElements[i][j];

                    if (tower.getTowerPlayer().equalsIgnoreCase(player)) {
                        aux = tower.getPosition();
                        if (graphicsElements[i][j + 1] == null) {
                            return new Dupla(i, j + 1);

                        } else if (graphicsElements[i][j - 1] == null) {
                            return new Dupla(i, j - 1);

                        } else if (graphicsElements[i - 1][j] == null) {
                            return new Dupla(i - 1, j);

                        } else if (graphicsElements[i + 1][j] == null) {
                            return new Dupla(i + 1, j);
                            //alter position 
                        }
                    }
                }
            }

        }
        if (graphicsElements[aux.getColumn() + 2][aux.getRow()] == null) {
            return new Dupla(aux.getColumn() + 2, aux.getRow());
        }
        if (graphicsElements[aux.getColumn()][aux.getRow() + 2] == null) {
            return new Dupla(aux.getColumn(), aux.getRow() + 2);
        }
        return null;
    }

    /**
     * this method paint the board to the game
     *
     * @param panel receives the panel
     */
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
    private javax.swing.JProgressBar jPLife;
    private javax.swing.JProgressBar jPMana;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelGame;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblPictureTitan;
    private javax.swing.JLabel lblShowName;
    private javax.swing.JLabel lblShowTurn;
    private javax.swing.JPanel paneTurn;
    // End of variables declaration//GEN-END:variables

    /**
     * Default operation to button is pressed
     *
     * @param e
     */
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

    /**
     * Increase the mana, these increase 25% by turn
     */
    private void increaseMana(String player)
    {
        for (int j = 0; j < rowGame; j++) {
            for (int i = 0; i < columnGame; i++) {
                if (graphicsElements[i][j] instanceof Titan) {
                    if (((Titan) graphicsElements[i][j]).getPlayer().equalsIgnoreCase(player)) {
                        Titan titan = (Titan) graphicsElements[i][j];
                        int mana = titan.getMana();
                        mana *= 0.25;

                        titan.setMana(titan.getMana()+ mana);
                        graphicsElements[i][j] = titan;
                    }

                }
            }
        }
    }

    /**
     * This method make the titan move, receives the row and column, also the
     * new buttton in the board
     *
     * @param column
     * @param row
     * @param temp
     */
    private void movePosition(int column, int row, Path temp)
    { // Move Position of titan

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
     *
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
                JOptionPane.showMessageDialog(rootPane, "Movements available:" + titan.getMoves(), "Move the Titan", JOptionPane.INFORMATION_MESSAGE, steeps); //Message to Move
                btnAttack.setEnabled(true);
                actionToRealice = "movePosition"; //set action to Moviment titan
            }
        }
    }

    /**
     * Charge the information in the screen, requires the titan to show your
     * data sheet
     *
     * @param titan
     */
    private void viewTitan(Titan titan)
    {
        actualTitan = titan;
        lblShowName.setText(titan.getName() + "          " + "Lvl:" + titan.getLevel());
        jPLife.setVisible(true);
        jPMana.setVisible(true);
        lblPictureTitan.setIcon(titan.getImageBig());
        //Life
        jPLife.setMaximum(titan.getMaxLife());
        jPLife.setValue(titan.getLife());
        jPLife.setStringPainted(true);
        jPLife.setString("Life: " + titan.getLife() + "/" + titan.getMaxLife());
        jPLife.setOpaque(true);
        jPLife.setBackground(java.awt.Color.green);
        jPLife.setForeground(java.awt.Color.black);

        //Mana
        jPMana.setMaximum(titan.getMaxMana());
        jPMana.setValue(titan.getMana());
        jPMana.setOpaque(true);
        jPMana.setStringPainted(true);
        jPMana.setString("Mana: " + titan.getMana() + "/" + titan.getMaxMana());
        jPMana.setBackground(java.awt.Color.blue);
        jPMana.setForeground(java.awt.Color.black);

    }

    /**
     * this methis obtain the quantity of tower there is on the board
     *
     * @param contTowersP1
     * @param contTowersP2
     */
    public void obtainQuantityTower(int contTowersP1, int contTowersP2)
    {

        int index = searchUserToEdit(methods.getActual());
        int played = methods.getPlayers().get(index).getUserEstadistics().getPlayedGames();
        methods.getPlayers().get(index).getUserEstadistics().setPlayedGames(played + 1);

        index = searchUserToEdit(methods.getPlayer2());
        played = methods.getPlayers().get(index).getUserEstadistics().getPlayedGames();
        methods.getPlayers().get(index).getUserEstadistics().setPlayedGames(played + 1);

        this.contTowersP1 = contTowersP1;
        this.contTowersP2 = contTowersP2;

    }

    /**
     * This method verify that someone won
     *
     * @return true if there is a winner o false
     */
    private boolean whoWin()
    {
        int index;
        if (this.contTowersP1 == 0) {
            //if player 1 is lost
            JOptionPane.showMessageDialog(rootPane, "Congratulations Player 2, you've won.", "Congratulations", JOptionPane.INFORMATION_MESSAGE, winner);
            index = searchUserToEdit(methods.getPlayer2());
            estadisticsPlayer2.setWinGames(estadisticsPlayer2.getWinGames() + 1);
            //if player 1 is lost
            updateEstadics(estadisticsPlayer2, index);
            index = searchUserToEdit(methods.getActual());
            estadisticsPlayer1.setLostGames(estadisticsPlayer1.getLostGames() + 1);
            updateEstadics(estadisticsPlayer1, index);
            this.dispose();
            selectTitan.goBack();
            running = false;
            return true;
        } else if (this.contTowersP2 == 0) {
            //if player 1 is winner
            index = searchUserToEdit(methods.getActual());
            estadisticsPlayer1.setWinGames(estadisticsPlayer1.getWinGames() + 1);
            updateEstadics(estadisticsPlayer1, index);

            //if player 2 is lost
            index = searchUserToEdit(methods.getPlayer2());
            estadisticsPlayer2.setLostGames(estadisticsPlayer2.getLostGames() + 1);
            updateEstadics(estadisticsPlayer2, index);
            JOptionPane.showMessageDialog(rootPane, "Congratulations Player 1, you've won.", "Congratulations", JOptionPane.INFORMATION_MESSAGE, winner);
            this.dispose();
            selectTitan.goBack();
            running = false;
            return true;
        }
        return false;
    }

    /**
     * This method revive the dead titan after of one turn
     */
    private void whoDead()
    { //Methods to titans is dead

        Titan deadTitan = null;
        Dupla dupla = null;
        if (timeDead1 == 0) {
            System.out.println("aqui 1");
            deadTitan = titansDead[0];
            if (deadTitan.getPlayer().equalsIgnoreCase("Player1")) {
                dupla = getPositionOfTitan("Player1");
                reviveTitan(deadTitan, dupla);

            } else {
                dupla = getPositionOfTitan("Player2");
                reviveTitan(deadTitan, dupla);
            }
            timeDead1 = -1;
            titansDead[0] = null;
        } else if (timeDead2 == 0) {
            System.out.println("aqui 2");
            deadTitan = titansDead[1];
            if (deadTitan.getPlayer().equalsIgnoreCase("Player1")) {
                dupla = getPositionOfTitan("Player1");
                reviveTitan(deadTitan, dupla);

            } else {
                dupla = getPositionOfTitan("Player2");
                reviveTitan(deadTitan, dupla);
            }
            timeDead2 = -1;
            titansDead[1] = null;
        } else if (timeDead3 == 0) {
            System.out.println("aqui 3");
            deadTitan = titansDead[2];
            if (deadTitan.getPlayer().equalsIgnoreCase("Player1")) {
                dupla = getPositionOfTitan("Player1");
                reviveTitan(deadTitan, dupla);

            } else {
                dupla = getPositionOfTitan("Player2");
                reviveTitan(deadTitan, dupla);
            }
            timeDead3 = -1;
            titansDead[2] = null;
        } else if (timeDead4 == 0) {
            System.out.println("aqui 4");
            deadTitan = titansDead[3];
            if (deadTitan.getPlayer().equalsIgnoreCase("Player1")) {
                dupla = getPositionOfTitan("Player1");
                reviveTitan(deadTitan, dupla);
            } else {
                dupla = getPositionOfTitan("Player2");
                reviveTitan(deadTitan, dupla);
            }
            timeDead4 = -1;
            titansDead[4] = null;
        }

    }

    public void reviveTitan(Titan deadTitan, Dupla dupla)
    {
        System.out.println("Revive titan");
        deadTitan.setLife(deadTitan.getMaxLife());
        deadTitan.setMana(deadTitan.getMaxMana());
        graphicsElements[dupla.getColumn()][dupla.getRow()] = deadTitan;
        Path path = gameSettings.searchButtonToPaint(buttons, dupla.getColumn(), dupla.getRow());
        path.setIcon(deadTitan.getTiny());
        if (deadTitan.getPlayer().equals("Player1")) {
            path.setBackground(java.awt.Color.red);
        } else {
            path.setBackground(java.awt.Color.blue);
        }
        theyAreDead();
    }

    /**
     * This method verify if there is a dead titan
     *
     * @return
     */
    public boolean theyAreDead()
    {
        for (int i = 0; i < titansDead.length; i++) {
            if (titansDead[i] != null) {
                return true;
            }
        }
        return false;
    }
// Start Thread of Game 

    /**
     * Inicialices the game variables
     */
    private void init()
    { // Inicialization of Varaibles
        //Start Game 
        actionToRealice = "move";
        int playerStart = gameSettings.getRadom(2);
        if (playerStart == 0) { //Player 1  
            turnOfPlayer = true;
            JOptionPane.showMessageDialog(rootPane, "Turn Player 1", "Change of turn ", JOptionPane.INFORMATION_MESSAGE, player1Icon);
            lblShowTurn.setText("Turn Player 1");
            paneTurn.setBackground(java.awt.Color.red);
        } else { //Player 2
            turnOfPlayer = false;
            JOptionPane.showMessageDialog(rootPane, "Turn Player 2", "Change of turn ", JOptionPane.INFORMATION_MESSAGE, player2Icon);
            lblShowTurn.setText("Turn Player 2");
            paneTurn.setBackground(java.awt.Color.blue);

        }

    }

    private void tick()
    { // Variables

        whoDead();
    }

    private void render()
    { // Graphics

    }

    /**
     * Game loop
     */
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

    /**
     * Start game
     */
    public synchronized void start()
    {

        if (running) {
            return;
        }
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * Stop the thread
     */
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
                JOptionPane.showMessageDialog(rootPane, "Out of range", " I can not attack", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nobody is there", "I can not attack", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Verify if a titan or tower is dead and set the attributes, also call the
     * method that change the turn
     *
     * @param element
     * @param mana
     */
    public void changeStates(GraphicsElement element, int mana)
    {
        viewTitan(actualTitan);
        Dupla dupla;
        boolean flag = true;
        if (element instanceof Tower) {
            Tower tower = (Tower) element;
            dupla = ((Tower) element).getPosition();
            Path path = gameSettings.searchButtonToPaint(buttons, dupla.getColumn(), dupla.getRow());
            path.setText(tower.getQuantityStamina() + "");
            if (((Tower) element).getQuantityStamina() == 0) {
                flag = false;
                actionToRealice = "move";
                mode = "pasive";
                if (tower.getTowerPlayer().equals("player1")) {
                    contTowersP1--;
                } else {
                    contTowersP2--;
                }
                increaseLevelAndPowers(actualTitan);

                graphicsElements[dupla.getColumn()][dupla.getRow()] = null;

                increaseDetroyTowers(tower);
                path.setIcon(new ImageIcon("src/pk/codeapp/tools/deletetower.png"));
                path.setEnabled(false);
            }
        } else {
            if (element instanceof Titan) {
                int midGame = (columnGame / 2);
                if (((Titan) element).getLife() == 0) {
                    flag = false;
                    actionToRealice = "move";
                    mode = "pasive";
                    graphicsElements[((Titan) element).getDupla().getColumn()][((Titan) element).getDupla().getRow()] = null;
                    notWontDie((Titan) element);
                    addNewTitanKill(((Titan) element));
                    increaseDeadTitans((Titan) element);
                    increaseLevelAndPowers(actualTitan);

                    Path path = gameSettings.searchButtonToPaint(buttons, ((Titan) element).getDupla().getColumn(), ((Titan) element).getDupla().getRow());
                    path.setIcon(null);

                    if (path.getColumn() > midGame - 1) {
                        path.setBackground(java.awt.Color.gray);
                    } else {
                        path.setBackground(java.awt.Color.lightGray);
                    }
                }
            }
        }
        if (whoWin()) {

        } else {
            if (flag) {
                actionToRealice = "move";
                mode = "pasive";
                changePlayer();
            }
        }

    }

    /**
     * Increase the stadistic about the titans deads
     *
     * @param titan
     */
    private void increaseDeadTitans(Titan titan)
    {
        int index;
        if (titan.getPlayer().equalsIgnoreCase("Player2")) {
            index = searchUserToEdit(methods.getActual());
            estadisticsPlayer1.setDeadTitans(estadisticsPlayer1.getDeadTitans() + 1);
            updateEstadics(estadisticsPlayer1, index);
        } else {
            index = searchUserToEdit(methods.getPlayer2());
            estadisticsPlayer2.setDeadTitans(estadisticsPlayer1.getDeadTitans() + 1);
            updateEstadics(estadisticsPlayer2, index);
        }
    }

    /**
     * increase the stadistics about the enemy tower dead ithe deaths of the
     * towers themselves
     *
     * @param tower
     */
    private void increaseDetroyTowers(Tower tower)
    {
        int index;
        if (tower.getTowerPlayer().equalsIgnoreCase("Player2")) {
            index = searchUserToEdit(methods.getActual());
            estadisticsPlayer1.setDrestroyTower(estadisticsPlayer1.getDrestroyTower() + 1);

            updateEstadics(estadisticsPlayer1, index);

            index = searchUserToEdit(methods.getPlayer2());
            estadisticsPlayer2.setMyDeadTower(estadisticsPlayer2.getMyDeadTower() + 1);
            updateEstadics(estadisticsPlayer2, index);
        } else {
            index = searchUserToEdit(methods.getPlayer2());
            estadisticsPlayer2.setDrestroyTower(estadisticsPlayer2.getDrestroyTower() + 1);
            updateEstadics(estadisticsPlayer2, index);
            index = searchUserToEdit(methods.getActual());
            estadisticsPlayer1.setMyDeadTower(estadisticsPlayer1.getMyDeadTower() + 1);
            updateEstadics(estadisticsPlayer1, index);
        }
    }

    /**
     * Seach in the array and make update
     *
     * @param estadistics
     * @param index
     */
    public void updateEstadics(Estadistics estadistics, int index)
    {
        methods.getPlayers().get(index).setUserEstadistics(estadistics);
    }

    /**
     * Seach the user in the array
     *
     * @param user
     * @return the index where is located
     */
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

    /**
     * Add stadistic about the kill with a specific titan
     *
     * @param titan
     */
    private void addNewTitanKill(Titan titan)
    {
        int index;
        if (titan.getPlayer().equalsIgnoreCase("Player1")) {
            index = searchUserToEdit(methods.getPlayer2());
            estadisticsPlayer2.addNewTitanDead(actualTitan);
            updateEstadics(estadisticsPlayer2, index);
        } else {
            index = searchUserToEdit(methods.getActual());
            estadisticsPlayer1.addNewTitanDead(actualTitan);
            updateEstadics(estadisticsPlayer1, index);
        }
    }

    /**
     * '
     * Save the dead titans to revive them later
     *
     * @param titan
     */
    private void notWontDie(Titan titan)
    {
        if (titansDead[0] == (null)) {
            titansDead[0] = titan;
            timeDead1 = 4;

        } else if (titansDead[1] == (null)) {
            titansDead[1] = titan;
            timeDead2 = 4;

        } else if (titansDead[2] == (null)) {
            titansDead[2] = titan;
            timeDead3 = 4;

        } else if (titansDead[3] == (null)) {
            titansDead[3] = titan;
            timeDead4 = 4;

        }
    }

    private void increaseLevelAndPowers(Titan actualTitan)
    {
        actualTitan.setMana((int) (actualTitan.getMaxMana()* 0.25) + actualTitan.getMana());
        actualTitan.setLife((int) (actualTitan.getLife() * 0.25) + actualTitan.getLife());
        actualTitan.setLevel(actualTitan.getLevel() + 1);
        graphicsElements[actualTitan.getDupla().getColumn()][actualTitan.getDupla().getRow()] = actualTitan;
    }
}
