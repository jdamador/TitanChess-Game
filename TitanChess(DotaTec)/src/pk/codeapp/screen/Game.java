package pk.codeapp.screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import pk.codeapp.methods.DefaultRules;
import pk.codeapp.methods.GameSettings;
import pk.codeapp.model.Dupla;
import pk.codeapp.model.GraphicsElement;
import pk.codeapp.model.Path;
import pk.codeapp.model.Titan;
import pk.codeapp.model.Tower;

public class Game extends javax.swing.JFrame implements DefaultRules, ActionListener, Runnable {

    //Inicialization of Variables
    private SelectTitan selectTitan;  // Before Windows
    private String elementArena;
    private int columnGame;
    private int rowGame;
    private boolean running; // thread Game)
    private Thread thread; // Main thread Game 
    private GraphicsElement[][] graphicsElements = MainApp.methods.getGraphicsElements(); // Matrix of Game
    private ArrayList<Path> buttons = new ArrayList(); // List of buttons
    private GameSettings gameSettings = new GameSettings(); // Methods to Game

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

        getContentPane().add(jPanelGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 590));

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
        paintStartTitans() ; //Paint and set posicions in the game
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
                        System.out.println("Establece icono al boton");
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
            
            for (int i = 0; i < MainApp.methods.getTitans().length; i++) {
                    Titan titans[]=MainApp.methods.getTitans();
                    Titan titan = titans[i];
                    if(titan!=null){
                    if (titan.getPlayer().equals("Player2")) {
                        titan.setDupla(setPositionStartTitan()); // get Position of titan in the game
                    } else {
                        titan.setDupla(setPositionStartTitan());
                    }
                    graphicsElements[titan.getDupla().getColumn()][titan.getDupla().getRow()]=titan; // Set  titan in new Position in the matrix of game 
                    Path buttonToPaint = gameSettings.searchButtonToPaint(buttons, titan.getDupla().getColumn(), titan.getDupla().getRow()); //Methods to return the button
                    System.out.println("Titan:"+titan.getName()+" Columna "+titan.getDupla().getColumn()+ " Fila "+titan.getDupla().getRow());
                    buttonToPaint.setIcon(titan.getTiny());
                }}
            }
        
    

    private Dupla setPositionStartTitan() { // Methods to get position of titans in the table
        for (int j = 0; j < rowGame; j++) {
            for (int i = 0; i < columnGame; i++) {
                if (graphicsElements[i][j] instanceof Tower) {
                    Tower tower = (Tower) graphicsElements[i][j];
                    if (tower.getTowerPlayer().equals("Player2")) {
                        if (graphicsElements[i][j + 1].equals(null)) { // Checks to in front of towers be null
                            return new Dupla(i, j + 1);
                        } else { // if the first position this titan else set down of tower
                            if (graphicsElements[i + 1][j].equals(null)) { //Checks to down of tower
                                return new Dupla(i + 1, j);
                            }
                        }
                    } else {
                        if (graphicsElements[i][j + 1].equals(null)) { // Checks to in front of towers be null
                            return new Dupla(i, j + 1);
                        } else { // if the first position this titan else set down of tower
                            if (graphicsElements[i + 1][j].equals(null)) { //Checks to down of tower
                                return new Dupla(i + 1, j);
                    }
                }
            }
        }
        
    }}return null;}

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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanelGame;
    private javax.swing.JLabel lblBackground;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // Start Thread of Game 
    private void init() { // Inicialization of Varaibles

    }

    private void tick() { // Variables

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
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
