package pk.codeapp.model;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jose Pablo Brenes
 */
public class User implements Serializable{
    private String name;
    private String password;
    private String email;
    private Estadistics  userEstadistics= new Estadistics(0,0,0,0,0,0,0);
    /**
     * Create new user, receives the attributes to create the instance
     * @param name
     * @param password
     * @param email 
     */
    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
       
    }
    /*All getter and setter here*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Estadistics getUserEstadistics()
    {   
        
        return userEstadistics;
    }

    public void setUserEstadistics(Estadistics userEstadistics)
    {
        this.userEstadistics = userEstadistics;
    }
    
}