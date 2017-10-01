package pk.codeapp.methods;

//<editor-fold defaultstate="collapsed" desc="All imports here">
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import pk.codeapp.model.Arena;
import pk.codeapp.model.Attack;
import pk.codeapp.model.GraphicsElement;
import pk.codeapp.model.Titan;
import pk.codeapp.model.Tower;
import pk.codeapp.model.User;
//</editor-fold>
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jose Pablo Brenes
 */
public class Methods
{

    private User player1;
    private User player2;
    private ArrayList<User> players = new ArrayList();
    private File userFile = new File("src/pk/codeapp/tools/user.ser");
    String[] element = {"Buckbeak", "Foxy"};
    private boolean checkTowerPlayer1; // Boolean to cheek quantity of towers in player 1
    private boolean checkTowerPlayer2;// Boolean to cheek quantity of towers in player 2
    private GraphicsElement graphicsElements[][]; // Matrix of Game
    private int columnGame, rowGame;
    private Titan[] titans = new Titan[8];
    private ArrayList<Titan> withoutCreating = new ArrayList();

    /**
     * Register new user in the game
     *
     * @param userName
     * @param password
     * @param email
     * @return true or false when the creation is sucessfull
     */
    public boolean registerUser(String userName, String password, String email)
    {
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
    public User searchUser(String userName)
    {
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
        }
    }

    /**
     * Charge users from the binary file
     */
    public void readUser()
    {
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
    public Titan[] getTitans()
    {
        return titans;
    }

    public void setTitans(Titan[] titans)
    {
        this.titans = titans;
    }
public int getColumnGame()
    {
        return columnGame;
    }

    public void setColumnGame(int columnGame)
    {
        this.columnGame = columnGame;
    }

    public int getRowGame()
    {
        return rowGame;
    }

    public void setRowGame(int rowGame)
    {
        this.rowGame = rowGame;
    }

    public GraphicsElement[][] getGraphicsElements()
    {
        return graphicsElements;
    }

    public void setGraphicsElements(GraphicsElement[][] graphicsElements)
    {
        this.graphicsElements = graphicsElements;
    }

    public String[] getElement()
    {
        return element;
    }

    public void setElement(int i)
    {
        this.element[i] = null;
    }

    public User getActual()
    {
        return player1;
    }

    public void setActual(User actual)
    {
        System.out.println(actual);
        this.player1 = actual;
    }

    public User getPlayer2()
    {
        return player2;
    }

    public void setPlayer2(User player2)
    {
        this.player2 = player2;
    }

    public ArrayList<Titan> getWithoutCreating()
    {
        return withoutCreating;
    }
    //</editor-fold>
    
    
    //<editor-fold desc="Default Titans in the game" defaultstate="collapsed">
    public void defaulTitan()
    {
        //public Titan(String name, int life, int moves, int damage,int mana, String vitalElement, String icon,String gif,String imageBig)
        Titan titan = new Titan("Mewtwo", 40, 2, 150, 300, "Water", "src/pk/codeapp/tools/titans/Icons/titan6.png", "src/pk/codeapp/tools/titans/titan6.png",
                "src/pk/codeapp/tools/titans/titan6.gif", "src/pk/codeapp/tools/titans/Icons/icon6.png");
        Attack attack = new Attack("Aura Sphere", 100, 250);
        titan.addAttack(attack);
        addTitan(titan);

        titan = new Titan("Geb", 65, 3, 200, 300, "Land", "src/pk/codeapp/tools/titans/Icons/titan4.jpg", "src/pk/codeapp/tools/titans/titan4.jpg",
                "src/pk/codeapp/tools/titans/titan4.gif", "src/pk/codeapp/tools/titans/Icons/icon4.jpg");
        attack = new Attack("Bone stick", 50, 150);
        titan.addAttack(attack);
        addTitan(titan);

        titan = new Titan("Tretan", 40, 2, 200, 400, "Fire", "src/pk/codeapp/tools/titans/Icons/titan2.jpg", "src/pk/codeapp/tools/titans/titan2.jpg",
                "src/pk/codeapp/tools/titans/titan2.gif", "src/pk/codeapp/tools/titans/Icons/icon2.jpg");
        attack = new Attack("Heat Wave", 200, 300);
        titan.addAttack(attack);
        addTitan(titan);

        titan = new Titan("Western Dragon", 30, 1, 200, 200, "Air", "src/pk/codeapp/tools/titans/Icons/titan1.jpg", "src/pk/codeapp/tools/titans/titan1.jpg",
                "src/pk/codeapp/tools/titans/titan1.gif", "src/pk/codeapp/tools/titans/Icons/icon1.jpg");
         attack = new Attack("Ice Skewers", 120, 200);
        titan.addAttack(attack);
        addTitan(titan);
        
        titan = new Titan("Jack", 50, 3, 200, 200, "Land", "src/pk/codeapp/tools/titans/Icons/titan5.jpg", "src/pk/codeapp/tools/titans/titan5.jpg",
                "src/pk/codeapp/tools/titans/titan5.gif", "src/pk/codeapp/tools/titans/Icons/icon5.jpg");
       attack = new Attack("BreaksRocks", 90, 215);
        titan.addAttack(attack);
        addTitan(titan);
     
        titan = new Titan("Lucario", 46, 2, 200, 200, "Water", "src/pk/codeapp/tools/titans/Icons/titan3.jpg", "src/pk/codeapp/tools/titans/titan3.jpg",
                "src/pk/codeapp/tools/titans/titan3.gif", "src/pk/codeapp/tools/titans/Icons/icon3.jpg");
        attack = new Attack("Heal Pulse", 50, 150);
        titan.addAttack(attack);
        addTitan(titan);
        //--------------------------------------------------------------------------------------------------------------------------------------------

        titan = new Titan("Default1 ", 0, 0, 0, 0, "", "src/pk/codeapp/tools/titans/Icons/titan8.png", "src/pk/codeapp/tools/titans/titan8.png", "src/pk/codeapp/tools/titans/titan8.gif", "src/pk/codeapp/tools/titans/Icons/icon8.png");
        withoutCreating.add(titan);
        titan = new Titan("Default 2", 0, 0, 0, 0, "", "src/pk/codeapp/tools/titans/Icons/titan7.png", "src/pk/codeapp/tools/titans/titan7.png", "src/pk/codeapp/tools/titans/titan7.gif", "src/pk/codeapp/tools/titans/Icons/icon7.png");
        withoutCreating.add(titan);
    }
    //</editor-fold>

    

    public void setWithoutCreating(ArrayList<Titan> withoutCreating)
    {
        this.withoutCreating = withoutCreating;
    }
    /**
     * Add tower in the matrix
     * @param newTower 
     */
    public void addTower(Tower newTower)
    { 
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
/**
 * Panel selected
 * @param panel 
 */
    private void activeTowertoPlay(String panel)
    { // Methods to activate the verfication of the towers 
        if (panel.equals("player1")) {
            this.checkTowerPlayer1 = true;
        } else {
            this.checkTowerPlayer2 = true;
        }
    }
    /**
     * add titan in the list
     * @param titan
     * @return  true when is addedor false 
     */
    public boolean addTitan(Titan titan)
    {
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

    /**
     * Seach the position in the array and make one update from data
     * @param element 
     */
    public void updateInGraphicsElements(GraphicsElement element)
    {
        int row;
        int column;
        if (element instanceof Tower) {
            Tower tw = (Tower) element;
            column = tw.getPosition().getColumn();
            row = tw.getPosition().getRow();
        } else {
            Titan tw = (Titan) element;
            column = tw.getDupla().getColumn();
            row = tw.getDupla().getRow();
        }
        graphicsElements[column][row] = element;
      
    }
/**
 * Seach titan in the array
 * @param titan
 * @return  if exists return true and isn't return false
 */
    public boolean search(Titan titan)
    {
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

    public void updateDefaults(int index)
    {
        withoutCreating.remove(index);
    }

    public void addInDefaults(Titan titan)
    {
        withoutCreating.add(titan);
        for (int i = 0; i < titans.length; i++) {
            if (titans[i].equals(titan)) {
                titans[i] = null;
                break;
            }
        }
    }
    public ArrayList<User> getPlayers()
    {
        return players;
    }
    public void setPlayers(ArrayList<User> players)
    {
        this.players = players;
    }
}
