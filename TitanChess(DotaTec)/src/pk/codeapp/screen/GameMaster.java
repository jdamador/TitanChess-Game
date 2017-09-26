/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.screen;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pk.codeapp.methods.DefaultRules;
import pk.codeapp.methods.Methods;
import pk.codeapp.model.Attack;
import pk.codeapp.model.Titan;

/**
 *
 * @author amador
 */
public class GameMaster extends javax.swing.JFrame implements DefaultRules {

    private MainApp beforeWindow;
    private Methods methods = MainApp.methods;
    private Titan[] titans;

    /**
     * Creates new form GameMaster
     */
    public GameMaster() {
        titans = methods.getTitans();
        initComponents();
        chargeTitansInComboBox();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        addAttack = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtAttackName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cmbAttackTitans = new javax.swing.JComboBox<>();
        btnAddAttack = new javax.swing.JButton();
        sliderDamageAttack = new javax.swing.JSlider();
        sliderManaAttack = new javax.swing.JSlider();
        lblName = new javax.swing.JLabel();
        createNewTitan = new javax.swing.JPanel();
        txtNewName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cmbNewMoves = new javax.swing.JComboBox<>();
        jButton9 = new javax.swing.JButton();
        cmbNewPath = new javax.swing.JComboBox<>();
        slideNewLife = new javax.swing.JSlider();
        slideNewMana = new javax.swing.JSlider();
        slideNewDamage = new javax.swing.JSlider();
        jLabel19 = new javax.swing.JLabel();
        cmbVitalElement = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        deleteTitan = new javax.swing.JPanel();
        cmbShowTitans = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        modifyTitan = new javax.swing.JPanel();
        txtNewName2 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        cmbMoves3 = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        cmbPathImage2 = new javax.swing.JComboBox<>();
        sliderDamage6 = new javax.swing.JSlider();
        sliderDamage7 = new javax.swing.JSlider();
        sliderDamage8 = new javax.swing.JSlider();
        jLabel36 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addAttack.setForeground(new java.awt.Color(255, 255, 255));
        addAttack.setOpaque(false);
        addAttack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Schoolbook L", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Add Attack");
        addAttack.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        txtAttackName.setBackground(new java.awt.Color(102, 102, 102));
        txtAttackName.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        txtAttackName.setForeground(new java.awt.Color(255, 255, 255));
        addAttack.add(txtAttackName, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 400, -1));

        jLabel9.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Name:");
        addAttack.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Damage:");
        addAttack.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        addAttack.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, -1, -1));

        jLabel11.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Mana:");
        addAttack.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, -1, -1));

        cmbAttackTitans.setBackground(new java.awt.Color(102, 102, 102));
        cmbAttackTitans.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        cmbAttackTitans.setForeground(new java.awt.Color(255, 255, 255));
        addAttack.add(cmbAttackTitans, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 400, 30));

        btnAddAttack.setBackground(new java.awt.Color(51, 51, 51));
        btnAddAttack.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAddAttack.setForeground(new java.awt.Color(255, 255, 255));
        btnAddAttack.setText("Add Attack");
        btnAddAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAttackActionPerformed(evt);
            }
        });
        addAttack.add(btnAddAttack, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, -1, -1));

        sliderDamageAttack.setFont(new java.awt.Font("Century Schoolbook L", 1, 14)); // NOI18N
        sliderDamageAttack.setForeground(new java.awt.Color(255, 255, 255));
        sliderDamageAttack.setMajorTickSpacing(50);
        sliderDamageAttack.setMaximum(300);
        sliderDamageAttack.setMinimum(50);
        sliderDamageAttack.setPaintLabels(true);
        sliderDamageAttack.setPaintTicks(true);
        addAttack.add(sliderDamageAttack, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 400, 60));

        sliderManaAttack.setFont(new java.awt.Font("Century Schoolbook L", 1, 14)); // NOI18N
        sliderManaAttack.setForeground(new java.awt.Color(255, 255, 255));
        sliderManaAttack.setMajorTickSpacing(50);
        sliderManaAttack.setMaximum(400);
        sliderManaAttack.setMinimum(50);
        sliderManaAttack.setPaintLabels(true);
        sliderManaAttack.setPaintTicks(true);
        addAttack.add(sliderManaAttack, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 400, 60));

        lblName.setBackground(new java.awt.Color(102, 102, 102));
        lblName.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/GameMaster_Background.jpg"))); // NOI18N
        addAttack.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        jTabbedPane1.addTab("Add Atack", addAttack);

        createNewTitan.setOpaque(false);
        createNewTitan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNewName.setBackground(new java.awt.Color(102, 102, 102));
        txtNewName.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        txtNewName.setForeground(new java.awt.Color(255, 255, 255));
        createNewTitan.add(txtNewName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 420, -1));

        jLabel2.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name:");
        createNewTitan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, 20));

        jLabel4.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Life");
        createNewTitan.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mana");
        createNewTitan.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Moves");
        createNewTitan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, -1, -1));

        jLabel7.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Path");
        createNewTitan.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Schoolbook L", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Create New TITAN");
        createNewTitan.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Make Changes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        createNewTitan.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 630, -1, -1));

        cmbNewMoves.setBackground(new java.awt.Color(102, 102, 102));
        cmbNewMoves.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        cmbNewMoves.setForeground(new java.awt.Color(255, 255, 255));
        cmbNewMoves.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cmbNewMoves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNewMovesActionPerformed(evt);
            }
        });
        createNewTitan.add(cmbNewMoves, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, 140, 30));

        jButton9.setBackground(new java.awt.Color(51, 51, 51));
        jButton9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Back");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        createNewTitan.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, -1, -1));

        cmbNewPath.setBackground(new java.awt.Color(102, 102, 102));
        cmbNewPath.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        cmbNewPath.setForeground(new java.awt.Color(255, 255, 255));
        cmbNewPath.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geb", "Foxy", "Sobeck" }));
        cmbNewPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNewPathActionPerformed(evt);
            }
        });
        createNewTitan.add(cmbNewPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, 380, 30));

        slideNewLife.setFont(new java.awt.Font("Century Schoolbook L", 1, 14)); // NOI18N
        slideNewLife.setForeground(new java.awt.Color(255, 255, 255));
        slideNewLife.setMajorTickSpacing(50);
        slideNewLife.setMaximum(700);
        slideNewLife.setMinimum(400);
        slideNewLife.setPaintLabels(true);
        slideNewLife.setPaintTicks(true);
        createNewTitan.add(slideNewLife, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 400, 60));

        slideNewMana.setFont(new java.awt.Font("Century Schoolbook L", 1, 14)); // NOI18N
        slideNewMana.setForeground(new java.awt.Color(255, 255, 255));
        slideNewMana.setMajorTickSpacing(50);
        slideNewMana.setMaximum(400);
        slideNewMana.setMinimum(50);
        slideNewMana.setPaintLabels(true);
        slideNewMana.setPaintTicks(true);
        createNewTitan.add(slideNewMana, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 400, 60));

        slideNewDamage.setFont(new java.awt.Font("Century Schoolbook L", 1, 14)); // NOI18N
        slideNewDamage.setForeground(new java.awt.Color(255, 255, 255));
        slideNewDamage.setMajorTickSpacing(50);
        slideNewDamage.setMaximum(300);
        slideNewDamage.setMinimum(50);
        slideNewDamage.setPaintLabels(true);
        slideNewDamage.setPaintTicks(true);
        createNewTitan.add(slideNewDamage, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 400, 60));

        jLabel19.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Damage");
        createNewTitan.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, -1, -1));

        cmbVitalElement.setBackground(new java.awt.Color(102, 102, 102));
        cmbVitalElement.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        cmbVitalElement.setForeground(new java.awt.Color(255, 255, 255));
        cmbVitalElement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Air", "land", "Fire", "Water" }));
        cmbVitalElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVitalElementActionPerformed(evt);
            }
        });
        createNewTitan.add(cmbVitalElement, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 140, 30));

        jLabel12.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Vital Element");
        createNewTitan.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, -1, -1));

        jLabel25.setBackground(new java.awt.Color(102, 102, 102));
        jLabel25.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/GameMaster_Background.jpg"))); // NOI18N
        createNewTitan.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        jLabel26.setBackground(new java.awt.Color(102, 102, 102));
        jLabel26.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/GameMaster_Background.jpg"))); // NOI18N
        createNewTitan.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        jTabbedPane1.addTab("Create Titan", createNewTitan);

        deleteTitan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteTitan.add(cmbShowTitans, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 270, 30));

        jButton1.setText("Delete");
        deleteTitan.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 160, 50));

        jButton7.setBackground(new java.awt.Color(51, 51, 51));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        deleteTitan.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, -1, -1));

        jLabel18.setFont(new java.awt.Font("Century Schoolbook L", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Delete Titan");
        deleteTitan.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/GameMaster_Background.jpg"))); // NOI18N
        deleteTitan.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        jTabbedPane1.addTab("Delete Titan", deleteTitan);

        modifyTitan.setOpaque(false);
        modifyTitan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNewName2.setBackground(new java.awt.Color(102, 102, 102));
        txtNewName2.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        txtNewName2.setForeground(new java.awt.Color(255, 255, 255));
        modifyTitan.add(txtNewName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 420, -1));

        jLabel30.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Name:");
        modifyTitan.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, 20));

        jLabel31.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Life");
        modifyTitan.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, -1, -1));

        jLabel32.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Mana");
        modifyTitan.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, -1, -1));

        jLabel33.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Moves");
        modifyTitan.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, -1, -1));

        jLabel34.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Path");
        modifyTitan.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, -1, -1));

        jLabel35.setFont(new java.awt.Font("Century Schoolbook L", 1, 48)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Create New TITAN");
        modifyTitan.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jButton6.setBackground(new java.awt.Color(51, 51, 51));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Create Titan");
        modifyTitan.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 630, -1, -1));

        cmbMoves3.setBackground(new java.awt.Color(102, 102, 102));
        cmbMoves3.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        cmbMoves3.setForeground(new java.awt.Color(255, 255, 255));
        cmbMoves3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Move", "2 Moves", "3 Moves" }));
        cmbMoves3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMoves3ActionPerformed(evt);
            }
        });
        modifyTitan.add(cmbMoves3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 590, 420, 30));

        jButton11.setBackground(new java.awt.Color(51, 51, 51));
        jButton11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Back");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        modifyTitan.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, -1, -1));

        cmbPathImage2.setBackground(new java.awt.Color(102, 102, 102));
        cmbPathImage2.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        cmbPathImage2.setForeground(new java.awt.Color(255, 255, 255));
        cmbPathImage2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPathImage2ActionPerformed(evt);
            }
        });
        modifyTitan.add(cmbPathImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 420, 30));

        sliderDamage6.setFont(new java.awt.Font("Century Schoolbook L", 1, 14)); // NOI18N
        sliderDamage6.setForeground(new java.awt.Color(255, 255, 255));
        sliderDamage6.setMajorTickSpacing(50);
        sliderDamage6.setMaximum(700);
        sliderDamage6.setMinimum(400);
        sliderDamage6.setPaintLabels(true);
        sliderDamage6.setPaintTicks(true);
        modifyTitan.add(sliderDamage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 420, 60));

        sliderDamage7.setFont(new java.awt.Font("Century Schoolbook L", 1, 14)); // NOI18N
        sliderDamage7.setForeground(new java.awt.Color(255, 255, 255));
        sliderDamage7.setMajorTickSpacing(50);
        sliderDamage7.setMaximum(400);
        sliderDamage7.setMinimum(50);
        sliderDamage7.setPaintLabels(true);
        sliderDamage7.setPaintTicks(true);
        modifyTitan.add(sliderDamage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 500, 420, 60));

        sliderDamage8.setFont(new java.awt.Font("Century Schoolbook L", 1, 14)); // NOI18N
        sliderDamage8.setForeground(new java.awt.Color(255, 255, 255));
        sliderDamage8.setMajorTickSpacing(50);
        sliderDamage8.setMaximum(300);
        sliderDamage8.setMinimum(50);
        sliderDamage8.setPaintLabels(true);
        sliderDamage8.setPaintTicks(true);
        modifyTitan.add(sliderDamage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 420, 60));

        jLabel36.setFont(new java.awt.Font("Century Schoolbook L", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Damage");
        modifyTitan.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, -1, -1));

        jButton4.setText("Load");
        modifyTitan.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, -1, -1));

        jLabel37.setBackground(new java.awt.Color(102, 102, 102));
        jLabel37.setFont(new java.awt.Font("Century Schoolbook L", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pk/codeapp/tools/GameMaster_Background.jpg"))); // NOI18N
        modifyTitan.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        jTabbedPane1.addTab("Modify Titan", modifyTitan);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPathImage2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPathImage2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPathImage2ActionPerformed

    private void cmbMoves3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMoves3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMoves3ActionPerformed

    private void cmbNewPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNewPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNewPathActionPerformed

    private void cmbNewMovesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNewMovesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbNewMovesActionPerformed

    private void btnAddAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAttackActionPerformed
     
    }//GEN-LAST:event_btnAddAttackActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        goBack();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbVitalElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVitalElementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVitalElementActionPerformed

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
            java.util.logging.Logger.getLogger(GameMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameMaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameMaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addAttack;
    private javax.swing.JButton btnAddAttack;
    private javax.swing.JComboBox<String> cmbAttackTitans;
    private javax.swing.JComboBox<String> cmbMoves3;
    private javax.swing.JComboBox<String> cmbNewMoves;
    private javax.swing.JComboBox<String> cmbNewPath;
    private javax.swing.JComboBox<String> cmbPathImage2;
    private javax.swing.JComboBox<String> cmbShowTitans;
    private javax.swing.JComboBox<String> cmbVitalElement;
    private javax.swing.JPanel createNewTitan;
    private javax.swing.JPanel deleteTitan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel lblName;
    private javax.swing.JPanel modifyTitan;
    private javax.swing.JSlider slideNewDamage;
    private javax.swing.JSlider slideNewLife;
    private javax.swing.JSlider slideNewMana;
    private javax.swing.JSlider sliderDamage6;
    private javax.swing.JSlider sliderDamage7;
    private javax.swing.JSlider sliderDamage8;
    private javax.swing.JSlider sliderDamageAttack;
    private javax.swing.JSlider sliderManaAttack;
    private javax.swing.JTextField txtAttackName;
    private javax.swing.JTextField txtNewName;
    private javax.swing.JTextField txtNewName2;
    // End of variables declaration//GEN-END:variables

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

    public void chargeTitansInComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel();

        for (int i = 0; i < titans.length; i++) {
            if (titans[i] != null) {
                model.addElement(titans[i].getName());
            }
        }
        cmbAttackTitans.setModel(model);
        cmbShowTitans.setModel(model);
        cmbShowTitans.setModel(model);

    }
 
}
