package pk.codeapp.methods;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import pk.codeapp.model.Arena;
import pk.codeapp.model.Dupla;
import pk.codeapp.model.GraphicsElement;
import pk.codeapp.model.Titan;
import pk.codeapp.model.Tower;
import pk.codeapp.model.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jose Pablo Brenes
 */
public class Methods {

    private Arena arena;
    private User player1;
    private User player2;
    private boolean turn;
    private ArrayList<User> players = new ArrayList();
    private File userFile = new File("src/pk/codeapp/tools/user.ser");

    private boolean checkTowerPlayer1; // Boolean to cheek quantity of towers in player 1
    private boolean checkTowerPlayer2;// Boolean to cheek quantity of towers in player 2
    private GraphicsElement graphicsElements[][]; // Matrix of Game
    private int columnGame, rowGame;

    private Titan[] titans = new Titan[8];

    /**
     * Register new user in the game
     *
     * @param userName
     * @param password
     * @param email
     * @return true or false when the creation is sucessfull
     */
    public boolean registerUser(String userName, String password, String email) {
        boolean flag = false;
        for (User user : players) {
            flag = user.getName().equals(userName);
        }
        if (flag) {
            return false;
        } else {
            players.add(new User(userName, password, email));
            return true;
        }

    }

    /**
     * Search user in the player list
     *
     * @param userName
     * @return the user found or null if the user is not
     */
    public User searchUser(String userName) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(userName)) {
                return players.get(i);
            }

        }
        return null;
    }

    /**
     * Write user in the binary file
     */
    public void writeUser() {
        if (userFile.exists()) {
            userFile.delete();
            System.out.println("Deleted");
        }

        FileOutputStream file = null;
        ObjectOutputStream output = null;

        try {

            for (int i = 0; i < players.size(); i++) {
                file = new FileOutputStream(userFile, true);
                output = new ObjectOutputStream(file);
                User save = players.get(i);
                output.writeObject(save);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (output != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    /**
     * Charge users from the binary file
     */
    public void readUser() {

        try {
            FileInputStream saveFile = new FileInputStream(userFile);
            ObjectInputStream save;
            try {
                while (true) {
                    save = new ObjectInputStream(saveFile);
                    User load = (User) save.readObject();
                    players.add(load);
                    //Si se va a buscar un objeto en especifico se puede poner aqui el la condicion
                }

            } catch (EOFException e) {
            }
            saveFile.close();
        } catch (Exception exc) {
        }

    }

    //<editor-fold desc="*All getter and setter here*" defaultstate="collapsed">
    public Titan[] getTitans() {
        return titans;
    }

    public void setTitans(Titan[] titans) {
        this.titans = titans;
    }

    //</editor-fold>
    public void defaulTitan() {
        //public Titan(String name, int life, int moves, int damage,int mana, String vitalElement, String icon,String gif,String imageBig)
        Titan titan = new Titan("Mewtwo", 400, 3, 200, 200, "Water", "src/pk/codeapp/tools/titans/Icons/titan6.png", "src/pk/codeapp/tools/titans/titan6.png", "src/pk/codeapp/tools/titans/titan6.gif");
        addTitan(titan);
        titan = new Titan("Geb", 400, 3, 200, 200, "Land", "src/pk/codeapp/tools/titans/Icons/titan4.jpg", "src/pk/codeapp/tools/titans/titan4.jpg", "src/pk/codeapp/tools/titans/titan4.gif");
        addTitan(titan);
        titan = new Titan("Tretan", 400, 3, 200, 200, "Fire", "src/pk/codeapp/tools/titans/Icons/titan2.jpg", "src/pk/codeapp/tools/titans/titan2.jpg", "src/pk/codeapp/tools/titans/titan2.gif");
        addTitan(titan);
        titan = new Titan("Western Dragon", 400, 3, 200, 200, "Air", "src/pk/codeapp/tools/titans/Icons/titan1.jpg", "src/pk/codeapp/tools/titans/titan1.jpg", "src/pk/codeapp/tools/titans/titan1.gif");
        addTitan(titan);
        titan = new Titan("Jack", 400, 3, 200, 200, "Land", "src/pk/codeapp/tools/titans/Icons/titan5.jpg", "src/pk/codeapp/tools/titans/titan5.jpg", "src/pk/codeapp/tools/titans/titan5.gif");
        addTitan(titan);
        titan = new Titan("Lucario", 400, 3, 200, 200, "Water", "src/pk/codeapp/tools/titans/Icons/titan3.jpg", "src/pk/codeapp/tools/titans/titan3.jpg", "src/pk/codeapp/tools/titans/titan3.gif");
        addTitan(titan);

    }

    public int getColumnGame() {
        return columnGame;
    }

    public void setColumnGame(int columnGame) {
        this.columnGame = columnGame;
    }

    public int getRowGame() {
        return rowGame;
    }

    public void setRowGame(int rowGame) {
        this.rowGame = rowGame;
    }

    public void addTower(Tower newTower) { // Add tower in the matrix
        if (checkTowerPlayer1 == false || checkTowerPlayer2 == false) {
            activeTowertoPlay(newTower.getTowerPlayer()); //Methods to active tower to play
        }
        if (graphicsElements == null) { //Check to empty
            graphicsElements = new GraphicsElement[columnGame][rowGame]; //Create a new Matrix
            graphicsElements[newTower.getPosition().getColumn()][newTower.getPosition().getRow()] = newTower; //Add
        } else {
            graphicsElements[newTower.getPosition().getColumn()][newTower.getPosition().getRow()] = newTower;//Add
        }
    }

    private void activeTowertoPlay(String panel) { // Methods to activate the verfication of the towers 
        if (panel.equals("player1")) {
            this.checkTowerPlayer1 = true;
        } else {
            this.checkTowerPlayer2 = true;
        }
    }

    public boolean addTitan(Titan titan) {
        if (!search(titan)) {
            for (int i = 0; i < titans.length; i++) {

                if (titans[i] == null) {
                    titans[i] = titan;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean search(Titan titan) {
        boolean flag = false;
        for (int i = 0; i < titans.length; i++) {
            if (titans[i] != null) {
                if (titans[i].getIcon().equals(titan.getIcon())) {
                    flag = true;
                    break;
                }
            }

        }
        return flag;
    }
}
