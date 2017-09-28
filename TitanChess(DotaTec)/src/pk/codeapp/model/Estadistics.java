
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.model;

import java.io.Serializable;

/**
 *
 * @author amador
 */
public class Estadistics implements Serializable {
    private int playedGames;
    private int lostGames;
    private int winGames;
    private int deadTitans;
    private int drestroyTower;
    private int myDeadTower;
    private Titan[] name=new Titan[8];
    private int deads[]= new int[8];
    private int performance;
}
