/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.model;

import javax.swing.JButton;

/**
 *
 * @author Jose Pablo Brenes
 */
public class Path extends JButton{
    private int column;
    private int row;
public Path(int column,int row){
        super();
        this.column=column;
        this.row=row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
    
}
