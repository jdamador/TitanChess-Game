package pk.codeapp.model;
import java.io.Serializable;
import java.util.ArrayList;
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
    private String name;
    private int life;
    private int moves;
    private String vitalElement;
    private String icon;
    //Relation
    private ArrayList<Attack> attacks = new ArrayList(); // List of Attacks
    
    public Titan(String name,int life,int moves,String vElement,String icon){
        this.name=name;
        this.life=life;
        this.moves=moves;
        this.vitalElement=vElement;
        this.icon=icon;
    }
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
    
}