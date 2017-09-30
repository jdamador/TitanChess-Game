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



    private Titan titan2;
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

    public void attack(Titan titan, GraphicsElement element2, Attack attack, String elementArena)
    {
     
        int damage = getRadom(attack.getQuantityDamage() + 1) + 1;
        if (titan.getVitalElement().equals(elementArena)) {
            int plus = (int) (attack.getQuantityDamage() * 0.10);
            damage += plus;
        }
        System.out.println(elementArena);
        if (element2 instanceof Tower) {
            Tower tower = ((Tower) element2);
            System.out.println(tower);
            if (damage < tower.getQuantityStamina()) {
                tower.setQuantityStamina(tower.getQuantityStamina() - damage);
                titan.setMana(titan.getMana() - attack.getQuantityMana());
                JOptionPane.showMessageDialog(null, "Damage caused :" + damage);
                methods.updateInGraphicsElements(tower);
                methods.updateInGraphicsElements(titan);
                return;
            } else {

                tower.setQuantityStamina(0);
                methods.updateInGraphicsElements(tower);
                methods.updateInGraphicsElements(titan);
                 JOptionPane.showMessageDialog(null, "Damage caused :" + damage);
            }
        } else {
            if(element2 instanceof Titan){
            titan2 = (Titan) element2;

            }

            if (damage < titan2.getLife()) {
                titan.setLife(titan2.getLife() - damage);
                titan.setMana(titan.getMana() - attack.getQuantityMana());
                  JOptionPane.showMessageDialog(null, "Damage caused :" + damage);
                methods.updateInGraphicsElements(titan2);
                methods.updateInGraphicsElements(titan);
              
            } else {

                titan2.setLife(0);
                  JOptionPane.showMessageDialog(null, "Damage caused :" + damage);

            
                titan2.setLife(0);
                

                methods.updateInGraphicsElements(titan2);
                methods.updateInGraphicsElements(titan);
               
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
        return titan2;
    }

    public void setTitan2(Titan titan2)
    {
        this.titan2 = titan2;
    }

}
