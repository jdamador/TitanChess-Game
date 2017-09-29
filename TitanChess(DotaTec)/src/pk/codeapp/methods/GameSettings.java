/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.methods;

import java.util.ArrayList;
import java.util.Random;
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

    public boolean attack(Titan titan, GraphicsElement element2, Attack attack,String elementArena)
    {
        
        int damage = getRadom(attack.getQuantityDamage() + 1);
        if(titan.getVitalElement().equals(elementArena)){
            int plus = (int) (attack.getQuantityDamage()*0.10);
            damage+=plus;
        }
        if (element2 instanceof Tower) {
            
            Tower tower = ((Tower) element2);
             System.out.println(tower.getQuantityStamina());
            if (damage < tower.getQuantityStamina()) {
                tower.setQuantityStamina(tower.getQuantityStamina() - damage);
                titan.setMana(titan.getMana()-attack.getQuantityMana());
                System.out.println(tower.getQuantityStamina());
                methods.updateInGraphicsElements(element2);
            }else{
                tower.setQuantityStamina(0);
                 JOptionPane.showMessageDialog(null, "Attack sucessfully ------>Hit reach: "+damage);
                return false;
            }
        } else {
            Titan titan2= (Titan)element2;
            System.out.println(titan.getLife());
            if(damage<titan2.getLife()){
                titan2.setLife(titan2.getLife()-damage);
                System.out.println(titan.getLife());
                titan.setMana(titan.getMana()-attack.getQuantityMana());
                methods.updateInGraphicsElements(titan);
                System.out.println();
            }
            else{
                 titan2.setLife(0);
                  JOptionPane.showMessageDialog(null, "Attack sucessfully ------>Hit reach: "+damage);
                 return false;
            }
        }
        JOptionPane.showMessageDialog(null, "Attack sucessfully ------>Hit reach: "+damage);
       return true;
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

    public boolean checkRange(int column, int row, Titan actualTitan)
    {
        int columnTitan = actualTitan.getDupla().getColumn();
        int rowTitan = actualTitan.getDupla().getRow();
  
            if ((columnTitan + 1 == column && rowTitan == row)
                    || (columnTitan == column && rowTitan + 1 == row)
                    || (columnTitan == column && rowTitan - 1 == row)
                    ||(columnTitan-1== column && rowTitan == row)) {
                    return true;
            }
            return false;
        }
       

    
}
