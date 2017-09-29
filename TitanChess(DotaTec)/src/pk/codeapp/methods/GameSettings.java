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
public class GameSettings {

    private int contTowersP1;
    private int contTowersP2;
    private boolean deadTitan;
    private Titan titan2;
    private ArrayList<Path> buttons;
    Random randomGenerator = new Random();
    Methods methods;

    public GameSettings(Methods methods) {
        this.methods = methods;

    }

    public Path searchButtonToPaint(ArrayList buttons, int column, int row) {
        for (int i = 0; i < buttons.size(); i++) {
            Path button = (Path) buttons.get(i);
            if (button.getColumn() == column && button.getRow() == row) {
                return button;
            }
        }
        return null;
    }

    public boolean attack(Titan titan, GraphicsElement element2, Attack attack, String elementArena) {

        int damage = getRadom(attack.getQuantityDamage() + 1);
        if (titan.getVitalElement().equals(elementArena)) {
            int plus = (int) (attack.getQuantityDamage() * 0.10);
            damage += plus;
        }

        if (element2 instanceof Tower) {

            Tower tower = ((Tower) element2);

            if (damage < tower.getQuantityStamina()) {
                tower.setQuantityStamina(tower.getQuantityStamina() - damage);
                titan.setMana(titan.getMana() - attack.getQuantityMana());

                methods.updateInGraphicsElements(tower);
                methods.updateInGraphicsElements(titan);
                JOptionPane.showMessageDialog(null, damage);
                return true;
            } else {
                if (tower.getTowerPlayer().equals("Player1")) //Less tower 
                {
                    contTowersP1--;
                } else {
                    contTowersP2--;
                }

                tower.setQuantityStamina(0);

                methods.updateInGraphicsElements(tower);
                methods.updateInGraphicsElements(titan);
                return false;
            }

        } else {
            titan2 = (Titan) element2;

            if (damage < titan2.getLife()) {
                titan.setLife(titan2.getLife() - damage);
                titan.setMana(titan.getMana() - attack.getQuantityMana());
                methods.updateInGraphicsElements(titan2);
                methods.updateInGraphicsElements(titan);
                JOptionPane.showMessageDialog(null, damage);
                return true;
            } else {
                deadTitan = true;
                titan2.setLife(0);
                deadTitan = true; // Active dead titan
                methods.updateInGraphicsElements(titan2);
                methods.updateInGraphicsElements(titan);
                return false;
            }

        }

    }

    public boolean isSomebodyHere(int column, int row, GraphicsElement[][] graphicsElements) {
        if (graphicsElements[column][row] instanceof Tower) {
            return false;
        } else if (graphicsElements[column][row] instanceof Titan) {
            return false;
        }
        return true;
    }

    public int getRadom(int end) {

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

    public int getContTowersP1() {
        return contTowersP1;
    }

    public void setContTowersP1(int contTowersP1) {
        this.contTowersP1 = contTowersP1;
    }

    public int getContTowersP2() {
        return contTowersP2;
    }

    public void setContTowersP2(int contTowersP2) {
        this.contTowersP2 = contTowersP2;
    }

    public boolean isDeadTitan() {
        return deadTitan;
    }

    public void setDeadTitan(boolean deadTitan) {
        this.deadTitan = deadTitan;
    }

    public ArrayList<Path> getButtons() {
        return buttons;
    }

    public void setButtons(ArrayList<Path> buttons) {
        this.buttons = buttons;
    }

    public Titan getTitan2() {
        return titan2;
    }

    public void setTitan2(Titan titan2) {
        this.titan2 = titan2;
    }

}
