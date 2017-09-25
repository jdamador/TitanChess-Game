package pk.codeapp.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Pablo Brenes
 */
public class Attack {
    private String nameAttack;
    private int quantityMana;
    private int quantityDamage;

    public Attack(String nameAttack, int quantityMana, int quantityDamage) {
        this.nameAttack = nameAttack;
        this.quantityMana = quantityMana;
        this.quantityDamage = quantityDamage;
    }

    public String getNameAttack() {
        return nameAttack;
    }

    public void setNameAttack(String nameAttack) {
        this.nameAttack = nameAttack;
    }

    public int getQuantityMana() {
        return quantityMana;
    }

    public void setQuantityMana(int quantityMana) {
        this.quantityMana = quantityMana;
    }

    public int getQuantityDamage() {
        return quantityDamage;
    }

    public void setQuantityDamage(int quantityDamage) {
        this.quantityDamage = quantityDamage;
    }
    
}