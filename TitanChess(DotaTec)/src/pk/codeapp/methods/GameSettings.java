/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.methods;

import java.util.ArrayList;
import java.util.Random;
import pk.codeapp.model.Attack;
import pk.codeapp.model.GraphicsElement;

import pk.codeapp.model.Path;
import pk.codeapp.model.Titan;
import pk.codeapp.model.Tower;

/**
 *
 * @author Jose Pablo Brenes
 */
public class GameSettings {
         Random randomGenerator = new Random();
         
        public Path searchButtonToPaint(ArrayList buttons,int column,int row){
            for (int i = 0; i < buttons.size(); i++) {
                Path button = (Path)buttons.get(i);
                if(button.getColumn()==column && button.getRow() == row){
                    return button;
                }
            }return null;
        }
        public void attack(Titan titan, GraphicsElement element2, Attack attack){
              int getDamage= getRadom(attack.getQuantityDamage()+1);
             if(element2 instanceof Tower){
                 if(getDamage<((Tower) element2).getQuantityStamina()){
                     
                 }
             }
             
        }
        
        
        public int getRadom( int end){
            
            int num= randomGenerator.nextInt(end);
            return num;
        }
}
