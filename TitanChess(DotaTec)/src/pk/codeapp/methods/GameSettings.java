/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.methods;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pk.codeapp.model.Attack;
import pk.codeapp.model.GraphicsElement;

import pk.codeapp.model.Path;
import pk.codeapp.model.Titan;
import pk.codeapp.model.Tower;
import pk.codeapp.screen.MainApp;

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
    public void attack(Titan titan, GraphicsElement element, Attack attack, String elementArena)
    {
        int damage = getRadom(attack.getQuantityDamage() + 1) + 1;
        if (titan.getVitalElement().equals(elementArena)) {
            int plus = (int) (titan.getDamage() * 0.10);
            damage += plus;
        }

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
    }

    public boolean isSomebodyHere(int column, int row, GraphicsElement[][] graphicsElements)
    {
        if (graphicsElements[column][row] instanceof Tower) {
            return false;
        } else if (graphicsElements[column][row] instanceof Titan) {
            return false;
        }
        return true;
    }

    public int getRadom(int end)
    {

        int num = randomGenerator.nextInt(end);
        return num;
    }

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

}
