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
}