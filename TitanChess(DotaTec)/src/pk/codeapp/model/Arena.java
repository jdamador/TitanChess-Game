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
public class Arena {
    private String Elemento;
    private int quantityColumns;
    private int quantityRows;
    private GraphicsElement[][] board;
    public Arena(String Elemento,int qColums, int qRows){
        this.Elemento = Elemento;
        this.quantityColumns=qColums;
        this.quantityRows=qRows;
    }
    public Arena(){}
    public String getElemento() {
        return Elemento;
    }
    public void setElemento(String Elemento) {
        this.Elemento = Elemento;
    }

    public int getQuantityColumns() {
        return quantityColumns;
    }

    public void setQuantityColumns(int quantityColumns) {
        this.quantityColumns = quantityColumns;
    }

    public int getQuantityRows() {
        return quantityRows;
    }

    public void setQuantityRows(int quantityRows) {
        this.quantityRows = quantityRows;
    }
    
}