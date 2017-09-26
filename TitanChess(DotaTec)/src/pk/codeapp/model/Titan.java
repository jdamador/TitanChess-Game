package pk.codeapp.model;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.ListModel;
import pk.codeapp.model.GraphicsElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Pablo Brenes
 */
public class Titan extends GraphicsElement implements Serializable{
    //Default attributes
    private String name;
    private int life;
    private int moves;
    private String vitalElement;
    private int damage;
    private int mana;
    //Graphics Attibutes
     private ImageIcon icon;
     private ImageIcon gif;
     private ImageIcon imageBig;
    //Relation
    private ArrayList<Attack> attacks = new ArrayList(); // List of Attacks
    //Player
    private String player;

    public Titan(String name, int life, int moves, int damage,int mana, String vitalElement, String icon,String imageBig,String gif) {
        //init attributes
        this.name = name;
        this.life = life;
        this.moves = moves;
        this.vitalElement = vitalElement;
        this.damage = damage;
        this.mana=mana;
        //init graphics elements
        this.icon= new ImageIcon(icon);
        this.gif= new ImageIcon(gif);
        this.imageBig = new ImageIcon(imageBig);
        //Create basic Attack
        Attack basic = new Attack("Hit", 80, 70);
        attacks.add(basic);
    }
    //<editor-fold desc="*Getter and Setter*" defaultstate=""collapsed">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public String getVitalElement() {
        return vitalElement;
    }


    public void setVitalElement(String vitalElement) {
        this.vitalElement = vitalElement;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public ImageIcon getGif() {
        return gif;
    }

    public void setGif(ImageIcon gif) {
        this.gif = gif;
    }
    
    //</editor-fold>

    public ImageIcon getImageBig() {
        return imageBig;
    }

    public void setImageBig(ImageIcon imageBig) {
        this.imageBig = imageBig;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    


    public DefaultListModel<String> toModel() {
        DefaultListModel<String> model= new DefaultListModel();
        model.addElement("Name:   "+this.name+ "    Vital Element:    "+this.vitalElement);
        model.addElement("Life:   "+this.life + "     Maximun Damage  "+this.damage+"     Quantity Mana:  "+this.mana);
        model.addElement("Moves:  "+this.moves);
       model.addElement("Attacks: ");
    
        model.addElement("------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < attacks.size(); i++) {
         Attack attack =attacks.get(i);
         model.addElement("Name: "+attack.getNameAttack()+" Maximum Damage:  "+ attack.getQuantityDamage()+ " Loss Mana: "+attack.getQuantityMana());
            
        }
        return model;
    }

    public void addAttack(Attack attack) {
        attacks.add(attack);
    }
    
}