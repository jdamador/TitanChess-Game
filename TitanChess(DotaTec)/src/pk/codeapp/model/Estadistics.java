
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

    public int getPlayedGames()
    {
        return playedGames;
    }

    public void setPlayedGames(int playedGames)
    {
        this.playedGames = playedGames;
    }

    public int getLostGames()
    {
        return lostGames;
    }

    public void setLostGames(int lostGames)
    {
        this.lostGames = lostGames;
    }

    public int getWinGames()
    {
        return winGames;
    }

    public void setWinGames(int winGames)
    {
        this.winGames = winGames;
    }

    public int getDeadTitans()
    {
        return deadTitans;
    }

    public void setDeadTitans(int deadTitans)
    {
        this.deadTitans = deadTitans;
    }

    public int getDrestroyTower()
    {
        return drestroyTower;
    }

    public void setDrestroyTower(int drestroyTower)
    {
        this.drestroyTower = drestroyTower;
    }

    public int getMyDeadTower()
    {
        return myDeadTower;
    }

    public void setMyDeadTower(int myDeadTower)
    {
        this.myDeadTower = myDeadTower;
    }

    public Titan[] getName()
    {
        return name;
    }

    public void setName(Titan[] name)
    {
        this.name = name;
    }

    public int[] getDeads()
    {
        return deads;
    }

    public void setDeads(int[] deads)
    {
        this.deads = deads;
    }

    public int getPerformance()
    {
        return performance;
    }

    public void setPerformance(int performance)
    {
        this.performance = performance;
    }

    public Estadistics()
    {
        this.playedGames =0;
        this.lostGames = 0;
        this.winGames = 0;
        this.deadTitans = 0;
        this.drestroyTower = 0;
        this.myDeadTower = 0;
        this.performance = 0;
    }

    public Estadistics(int playedGames, int lostGames, int winGames, int deadTitans, int drestroyTower, int myDeadTower, int performance)
    {
        this.playedGames = playedGames;
        this.lostGames = lostGames;
        this.winGames = winGames;
        this.deadTitans = deadTitans;
        this.drestroyTower = drestroyTower;
        this.myDeadTower = myDeadTower;
        this.performance = performance;
    }
    
    
}
