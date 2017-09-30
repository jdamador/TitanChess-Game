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
import pk.codeapp.model.GraphicsElement;
import pk.codeapp.model.Path;
import pk.codeapp.model.Titan;
import pk.codeapp.model.Tower;
import static pk.codeapp.screen.MainApp.methods;

public class Game extends javax.swing.JFrame implements DefaultRules, ActionListener, Runnable {

    //Inicialization of Variables
    AuxAttackMode auxWindowstoAttack = new AuxAttackMode();
    private SelectTitan selectTitan;  // Before Windows
    private String elementArena;
    private int columnGame;
    private int rowGame;
    private int contTimeToDead = 0; // Cont the turn that pass to restart Titan
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

    public Game() {
        initComponents();
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {

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
        lblBackground = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 130, 50));

        btnEndTurn.setBackground(new java.awt.Color(0, 0, 0));
        btnEndTurn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEndTurn.setForeground(new java.awt.Color(255, 255, 255));
        btnEndTurn.setText("End Turn");
        btnEndTurn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnEndTurnActionPerformed(evt);
            }
        });
        getContentPane().add(btnEndTurn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 600, 110, 50));

        btnAttack.setText("Attack");
        btnAttack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAttackActionPerformed(evt);
            }
        });
        getContentPane().add(btnAttack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 600, 130, 50));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/BackgroundLand.jpg"))); // NOI18N
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 600, -1, -1));

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
        JOptionPane.showMessageDialog(rootPane, "Select your enemy!");
    }//GEN-LAST:event_btnAttackActionPerformed
    private void changePlayer() // Change turn of game
    {
        btnAttack.setEnabled(false);
        if (turnOfPlayer) { //Player 1  - Player 2
            turnOfPlayer = false;
            JOptionPane.showMessageDialog(rootPane, "Turn Player 2");
        } else { //Player 2  - Player 1
            turnOfPlayer = true;
            JOptionPane.showMessageDialog(rootPane, "Turn Player 1");
        }
        if (gameSettings.isDeadTitan()) {
            contTimeToDead++;
        }
    }

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

    private void paintBackground(String elementArena) { // Paint The arena of type respective
        System.out.println(elementArena);
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
    public void openWindow(JFrame frame) {
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
        init(); //Inicialization of init

    }

    @Override
    public void goBack() {
        this.dispose();
        selectTitan.setVisible(true);
    }

    private void paintTowersGame() { //Paint tower in the table
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

    private void paintStartTitans() { //Paint start champions in the table
        titans = MainApp.methods.getTitans();
        for (int i = 0; i < titans.length; i++) {

            Titan titan = titans[i];
            if (titan != null) {

                if (titan.getPlayer().equals("Player2")) {
                    if (getPositionOfTitan("player2") != null) {
                        System.out.println("Entro en el PLayer2");
                        Dupla dupla = getPositionOfTitan("player2");
                        titan.setDupla(dupla);
                        graphicsElements[titan.getDupla().getColumn()][titan.getDupla().getRow()] = titan; // Set  titan in new Position in the matrix of game 
                        Path buttonToPaint = gameSettings.searchButtonToPaint(buttons, titan.getDupla().getColumn(), titan.getDupla().getRow()); //Methods to return the button
                        System.out.println("Titan:" + titan.getName() + " Columna " + titan.getDupla().getColumn() + " Fila " + titan.getDupla().getRow());
                        buttonToPaint.setIcon(titan.getTiny());
                        buttonToPaint.setBackground(java.awt.Color.blue);
                    }
                } else {
                    if (getPositionOfTitan("player1") != null) {
                        System.out.println("Entro en el PLayer1");
                        Dupla dupla = getPositionOfTitan("player1");
                        titan.setDupla(dupla);
                        graphicsElements[titan.getDupla().getColumn()][titan.getDupla().getRow()] = titan; // Set  titan in new Position in the matrix of game 
                        Path buttonToPaint = gameSettings.searchButtonToPaint(buttons, titan.getDupla().getColumn(), titan.getDupla().getRow()); //Methods to return the button
                        System.out.println("Titan:" + titan.getName() + " Columna " + titan.getDupla().getColumn() + " Fila " + titan.getDupla().getRow());
                        buttonToPaint.setIcon(titan.getTiny());
                        buttonToPaint.setBackground(java.awt.Color.red);
                    }

                }

            }
        }
    }

    private Dupla getPositionOfTitan(String player) {
        for (int j = 0; j < rowGame; j++) {
            for (int i = 0; i < columnGame; i++) {
                if (graphicsElements[i][j] instanceof Tower) {
                    Tower tower = (Tower) graphicsElements[i][j];

                    if (tower.getTowerPlayer().equals(player)) {
                        System.out.println(graphicsElements[i][j + 1]);
                        System.out.println(i + "  " + j);
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

    private void paintTable(JPanel panel) { //Methods to paint matrix of table(Only part of player)
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelGame;
    private javax.swing.JLabel lblBackground;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) { // Click in the mouse

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

    private void movePosition(int column, int row, Path temp) { // Move Position of titan
        System.out.println("Entro a move Position" + " El contador es: " + contMovesTitan);
        if (contMovesTitan > 0) {
            System.out.println("Entro al contador");
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

    private void moveTitan(String player, int column, int row, Path temp) { // Methods to move titan 
        if (graphicsElements[column][row] instanceof Titan) {
            Titan titan = (Titan) graphicsElements[column][row];
            if (titan.getPlayer().equals(player)) {

                contMovesTitan = titan.getMoves();
                backupButton = temp; // Backup the button to move
                actualTitan = titan; // set Actual Titan
                JOptionPane.showMessageDialog(rootPane, "Move the Titan |All Movement " + titan.getMoves()); //Message to Move
                btnAttack.setEnabled(true);
                actionToRealice = "movePosition"; //set action to Moviment titan
            }
        }
    }

    public void obtainQuantityTower(int contTowersP1, int contTowersP2) {
        gameSettings.setContTowersP1(contTowersP1);
        gameSettings.setContTowersP2(contTowersP2);

    }

    private void whoWin() {
        if (gameSettings.getContTowersP1() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Congratulations Player 1, you've won.");

            /// 
        } else if (gameSettings.getContTowersP2() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Congratulations Player 2, you've won.");
            // 
        }
    }

    private void whoDead() { //Methods to titans is dead
        Titan titan2 = gameSettings.getTitan2();
        int column = titan2.getDupla().getColumn();
        int row = titan2.getDupla().getRow();
        if (gameSettings.isDeadTitan()) {

            graphicsElements[column][row] = null;
            Path path = gameSettings.searchButtonToPaint(buttons, column, row); // Paint and delete titan
            path.setIcon(null);

        }
        if (contTimeToDead == 4) { //Before to 1 turn paint and add titan in the matrix
            if (titan2.getPlayer().equals("Player1")) {
                titan2.setDupla(getPositionOfTitan("Player1"));
            } else {
                titan2.setDupla(getPositionOfTitan("Player2"));
            }
            graphicsElements[titan2.getDupla().getColumn()][titan2.getDupla().getRow()] = titan2;
            Path path = gameSettings.searchButtonToPaint(buttons, titan2.getDupla().getColumn(), titan2.getDupla().getRow());
            path.setIcon(titan2.getTiny());

            contTimeToDead = 0;
            gameSettings.setDeadTitan(false);
        }
    }

    // Start Thread of Game 
    private void init() { // Inicialization of Varaibles
        //Start Game 
        actionToRealice = "move";
        int playerStart = gameSettings.getRadom(2);
        if (playerStart == 0) { //Player 1  
            turnOfPlayer = true;
            JOptionPane.showMessageDialog(rootPane, "Turn Player 1");
        } else { //Player 2
            turnOfPlayer = false;
            JOptionPane.showMessageDialog(rootPane, "Turn Player 2");
        }

    }

    private void tick() { // Variables
        whoWin();
        whoDead();
    }

    private void render() { // Graphics

    }

    @Override
    public void run() {
        init();
        while (running) { // Main Loop

            tick();
            render();
        }
        stop();
    }

    public synchronized void start() {
        System.out.println("Entro al start");
        if (running) {
            return;
        }
        running = true;
        Thread thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
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
    private void enterAttackMode(ActionEvent e) {
        Path path = (Path) e.getSource();

        if (!gameSettings.isSomebodyHere(path.getColumn(), path.getRow(), graphicsElements)) {
            int column = path.getColumn();
            int row = path.getRow();
            if (gameSettings.checkRange(column, row, actualTitan)) {
                if (graphicsElements[column][row] instanceof Tower) {
                    Tower tower = (Tower) graphicsElements[column][row];
                    if (!tower.getTowerPlayer().equals(actualTitan.getPlayer())) {

                        auxWindowstoAttack.getToolsToAttack(actualTitan, tower, this, elementArena);

                    }

                } else {
                    Titan titan = (Titan) graphicsElements[column][row];
                    if (!titan.getPlayer().equals(actualTitan.getPlayer())) {

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

    public void changeStates(GraphicsElement element) {
        Dupla dupla;
        if (element instanceof Tower) {
            if (((Tower) element).getQuantityStamina() == 0) {
                dupla = ((Tower) element).getPosition();
                graphicsElements[dupla.getColumn()][dupla.getRow()] = null;

            }

        } else {
            if (element instanceof Titan) {
                if (((Titan) element).getLife() == 0) {
                    dupla = element.getDupla();
                    graphicsElements[dupla.getColumn()][dupla.getRow()] = null;
                }
            }

            actionToRealice = "move";
            mode = "pasive";
            changePlayer();
        }
    }

}
