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
<<<<<<< HEAD
    private ArrayList<Titan> titans= new ArrayList();
    private GraphicsElement graphicsElements[][]; // Matrix of Game
    private int columnGame,rowGame; 
=======
    private Titan[] titans= new Titan[8];
>>>>>>> master
    //<editor-fold desc="Default list from titans" defaultstate="collapsed">
    private String[] imageTitans=
    {"src/pk/codeapp/tools/titans/titan1.jpg",
        "src/pk/codeapp/tools/titans/titan2.jpg",
        "src/pk/codeapp/tools/titans/titan3.jpg",
        "src/pk/codeapp/tools/titans/titan4.png",
        "src/pk/codeapp/tools/titans/titan5.jpg",
        "src/pk/codeapp/tools/titans/titan6.png",
        "src/pk/codeapp/tools/titans/titan7.png",null};
     private String[] gifTitans=
    {"src/pk/codeapp/tools/titans/titan1.gif",
        "src/pk/codeapp/tools/titans/titan2.gif",
        "src/pk/codeapp/tools/titans/titan3.gif",
        "src/pk/codeapp/tools/titans/titan4.gif",
        "src/pk/codeapp/tools/titans/titan5.gif",
        "src/pk/codeapp/tools/titans/titan6.gif",
        "src/pk/codeapp/tools/titans/titan7.gif",null};
    //</editor-fold>
        
    
    
    
    /**
     * Register new user in the game
     * @param userName
     * @param password
     * @param email
     * @return  true or false when the creation is sucessfull
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
     * @param userName
     * @return  the user found or null if the user is not
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
    public void writeUser() 
    {
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
                User save=players.get(i);
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

    public String[] getImageTitans() {
        return imageTitans;
    }

    public void setImageTitans(String[] imageTitans) {
        this.imageTitans = imageTitans;
    }

    public Titan[] getTitans() {
        return titans;
    }

    public void setTitans(Titan[] titans) {
        this.titans = titans;
    }
    
    
    //</editor-fold>

    public String[] getGifTitans() {
        return gifTitans;
    }

    public void setGifTitans(String[] gifTitans) {
        this.gifTitans = gifTitans;
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
    
    public void defaulTitan(){
      
       
        Titan titan = new Titan("Western Dragon", 600, 3, "Aire","",100);
        titans[0]=titan;
        titan = new Titan("Treatan", 700, 1, "Fire","",250);
        titans[1]=titan;
         titan = new Titan("Tololo", 800, 2, "Land","",230);
       titans[2]=titan;
        titan = new Titan("Buckbeak", 400, 2, "Aire","",300);
        titans[3]=titan;
         titan = new Titan("Geb", 1400, 3, "Land","",80);
        titans[4]=titan;
        titan = new Titan("Sobeck", 1000, 2, "Water","",100);
       titans[5]=titan;
         titan = new Titan("Foxy", 500, 1, "Fire","",500);
       titans[6]=titan;
       titans[7]=null;
    }
    public void addTower(Tower newTower){ // Add tower in the matrix
        if(graphicsElements==null){ //Check to empty
            graphicsElements=new GraphicsElement[columnGame][rowGame]; //Create a new Matrix
            graphicsElements[newTower.getPosition().getColumn()][newTower.getPosition().getRow()]=newTower;
        }
        else{      
            graphicsElements[newTower.getPosition().getColumn()][newTower.getPosition().getRow()]=newTower;
        }
    }
}