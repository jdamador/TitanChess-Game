/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.methods;
//<editor-fold desc="****all imports here****"  defaultstate="collapsed">

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import pk.codeapp.model.Attack;
import pk.codeapp.model.GraphicsElement;
import pk.codeapp.model.Path;
import pk.codeapp.model.Titan;
import pk.codeapp.model.Tower;
//</editor-fold>

/**
 *
 * @author Jose Pablo Brenes
 */
public class GameSettings
{

    private Titan defender;
    private ArrayList<Path> buttons;
    Random randomGenerator = new Random();
    Methods methods;

    public GameSettings(Methods methods)
    {
        this.methods = methods;
    }

    public Path searchButtonToPaint(ArrayList buttons, int column, int row)
    {
        for (int i = 0; i < buttons.size(); i++) {
            Path button = (Path) buttons.get(i);
            if (button.getColumn() == column && button.getRow() == row) {
                return button;
            }
        }
        return null;
    }

    /**
     * Receives the actual titan, element to attack, attack selected and arena's
     * element
     *
     * @param titan
     * @param element
     * @param attack
     * @param elementArena
     */
    public int attack(Titan titan, GraphicsElement element, Attack attack, String elementArena)
    {
        /**
         * Calculate the damage from attack
         */
        int damage = getRadom(attack.getQuantityDamage() + 1) + 1;
        if (titan.getVitalElement().equals(elementArena)) {
            int plus = (int) (titan.getDamage() * 0.10);
            damage += plus;
        }
        /**
         * Verify if the element is a instance from Tower and apply the attack
         */
        if (element instanceof Tower) {
            Tower tower = ((Tower) element);
            if (damage < tower.getQuantityStamina()) {
                tower.setQuantityStamina(tower.getQuantityStamina() - damage);
                titan.setMana(titan.getMana() - attack.getQuantityMana());
                JOptionPane.showMessageDialog(null, "Damage caused :" + damage);
                methods.updateInGraphicsElements(tower);
                methods.updateInGraphicsElements(titan);
            } else {
                tower.setQuantityStamina(0);
                JOptionPane.showMessageDialog(null, "Damage caused :" + damage);
                methods.updateInGraphicsElements(tower);
                methods.updateInGraphicsElements(titan);
            }
        } else {
            /**
             * Verify if the element is instance from Titan and apply the attack
             */
            if (element instanceof Titan) {
                defender = (Titan) element;
                int defense = getRadom(defender.getDefense() + 1) + 1;
                int newDamege = damage - defense;
                if (newDamege < 0) {
                    newDamege = 1;
                }
                if (damage < defender.getLife()) {
                    defender.setLife(defender.getLife() - damage);
                    titan.setMana(titan.getMana() - attack.getQuantityMana());
                    JOptionPane.showMessageDialog(null, "Damage caused :" + damage);
                    methods.updateInGraphicsElements(defender);
                    methods.updateInGraphicsElements(titan);

                } else {
                    defender.setLife(0);
                    JOptionPane.showMessageDialog(null, "Damage caused :" + damage);
                    methods.updateInGraphicsElements(defender);
                    methods.updateInGraphicsElements(titan);
                }
            }
        }
        return titan.getMana();
    }

    /**
     * check if anyone is there
     *
     * @param column
     * @param row
     * @param graphicsElements
     * @return return true if he found anything or false
     */
    public boolean isSomebodyHere(int column, int row, GraphicsElement[][] graphicsElements)
    {
        if (graphicsElements[column][row] instanceof Tower) {
            return false;
        } else if (graphicsElements[column][row] instanceof Titan) {
            return false;
        }
        return true;
    }
/**
 * That methods calculate a random number
 *
 * @param end recivies a max number
 * @return  the new number
 */
    public int getRadom(int end)
    {

        int num = randomGenerator.nextInt(end);
        return num;
    }
/**
 * Check range to attack or move, this range is up, dawn, back and ahead
 * @param column
 * @param row
 * @param actualTitan
 * @return  true if is allow or false 
 */
    public boolean checkRange(int column, int row, Titan actualTitan) //Checks the click this in range titan
    {
        int columnTitan = actualTitan.getDupla().getColumn();
        int rowTitan = actualTitan.getDupla().getRow();

        if ((columnTitan + 1 == column && rowTitan == row)
                || (columnTitan == column && rowTitan + 1 == row)
                || (columnTitan == column && rowTitan - 1 == row)
                || (columnTitan - 1 == column && rowTitan == row)) {
            return true;
        }
        return false;
    }
    //<editor-fold defaultstate="collapsed" desc="***All getter and setter here***">
    public ArrayList<Path> getButtons()
    {
        return buttons;
    }

    public void setButtons(ArrayList<Path> buttons)
    {
        this.buttons = buttons;
    }

    public Titan getTitan2()
    {
        return defender;
    }

    public void setTitan2(Titan titan2)
    {
        this.defender = titan2;
    }
    //</editor-fold>
}
