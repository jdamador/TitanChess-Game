/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.methods;

import java.util.ArrayList;
import pk.codeapp.model.Attack;
import pk.codeapp.model.GraphicsElement;

import pk.codeapp.model.Path;

/**
 *
 * @author Jose Pablo Brenes
 */
public class GameSettings {
    
        public Path searchButtonToPaint(ArrayList buttons,int column,int row){
            for (int i = 0; i < buttons.size(); i++) {
                Path button = (Path)buttons.get(i);
                if(button.getColumn()==column && button.getRow() == row){
                    return button;
                }
            }return null;
        }
        public void attack(GraphicsElement element1, GraphicsElement element2, Attack attack){
            
        }
}
