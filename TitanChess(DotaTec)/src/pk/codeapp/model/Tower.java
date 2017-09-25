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

    public Tower(int quantityStamina) {
        this.quantityStamina = quantityStamina;
    }
    
    public int getQuantityStamina() {
        return quantityStamina;
    }

    public void setQuantityStamina(int quantityStamina) {
        this.quantityStamina = quantityStamina;
    }
    
}