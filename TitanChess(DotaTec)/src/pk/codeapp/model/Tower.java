package pk.codeapp.model;
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
public class Tower extends GraphicsElement{
    private int quantityStamina;
    private Dupla position;
    private String towerPlayer;
    public Tower(int quantityStamina,Dupla dupla,String player) {
        this.quantityStamina = quantityStamina;
        this.position=dupla;
        this.towerPlayer=player;
    }
    
    public int getQuantityStamina() {
        return quantityStamina;
    }

    public void setQuantityStamina(int quantityStamina) {
        this.quantityStamina = quantityStamina;
    }

    public Dupla getPosition() {
        return position;
    }
    
    public void setPosition(Dupla position) {
        this.position = position;
    }

    public String getTowerPlayer() {
        return towerPlayer;
    }

    public void setTowerPlayer(String towerPlayer) {
        this.towerPlayer = towerPlayer;
    }
    
}