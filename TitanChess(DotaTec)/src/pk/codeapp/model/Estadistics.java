
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.codeapp.model;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author amador
 */
public class Estadistics implements Serializable
{

    private int playedGames;
    private int lostGames;
    private int winGames;
    private int deadTitans;
    private int drestroyTower;
    private int myDeadTower;
    //<editor-fold defaultstate="collapsed" desc="Icons">
    private String[] name = {"src/pk/codeapp/tools/titans/Icons/titan1.jpg",
        "src/pk/codeapp/tools/titans/Icons/titan2.jpg",
         "src/pk/codeapp/tools/titans/Icons/titan3.jpg",
         "src/pk/codeapp/tools/titans/Icons/titan4.jpg",
         "src/pk/codeapp/tools/titans/Icons/titan5.jpg",
        "src/pk/codeapp/tools/titans/Icons/titan6.png",
        "src/pk/codeapp/tools/titans/Icons/titan7.png",
        "src/pk/codeapp/tools/titans/Icons/titan8.png"};
    //</editor-fold>
    
    private int[] kills = new int[8];
    private int performance;
   
//<editor-fold desc="All getter and setter here" defaultstate="collapsed">
    public int getPlayedGames()
    {
        return playedGames;
    }

    public void setPlayedGames(int playedGames)
    {
        calcPerformance();
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
        calcPerformance();
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

    public int[] getKills()
    {
        return kills;
    }

    public void setKills(int[] kills)
    {
        this.kills = kills;
    }

   
   
    public int getPerformance()
    {
        return performance;
    }

    public void setPerformance(int performance)
    {
        this.performance = performance;
    }

    public String[] getName()
    {
        return name;
    }
    //</editor-fold>
    
    
    /** 
     * Default constractor inicializes the attiributes in zero
     */
    public Estadistics()
    {
        this.playedGames = 0;
        this.lostGames = 0;
        this.winGames = 0;
        this.deadTitans = 0;
        this.drestroyTower = 0;
        this.myDeadTower = 0;
        this.performance = 0;
    }
/**
 * Constructor, receives the attibutes to make the instance
 * @param playedGames 
 * @param lostGames
 * @param winGames
 * @param deadTitans
 * @param drestroyTower
 * @param myDeadTower
 * @param performance 
 */
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
    /**
     * Calculate the player performance, requires that played games is different from zero
     */
    public void calcPerformance()
    {
        if (winGames != 0 && playedGames != 0) {
            this.performance = winGames * 100 / playedGames;
        }
    }
    /**
     * Update kill in titan specific, requires the titans
     * @param titan 
     */
    public void addNewTitanDead(Titan titan){
        for (int i = 0; i < name.length; i++) {
            
           if(titan.path.equals(name[i])){
               kills[i]=kills[i]+1;
                break;
           }  
        }
    }

}
