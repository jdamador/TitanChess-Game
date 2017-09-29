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
public abstract class GraphicsElement {
    private Dupla dupla;
    
    public Dupla getDupla() {
        return dupla;
    }

    public void setDupla(Dupla dupla) {
        this.dupla = dupla;
    }
    
}