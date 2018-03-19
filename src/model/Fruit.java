/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author shan
 */
public class Fruit {
    private String name;
    public enum Functionality { 
        SPEED, IMMORTALITY}
    private Functionality function;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Functionality getFunction() {
        return function;
    }

    public void setFunction(Functionality function) {
        this.function = function;
    }

    public Fruit(String name, Functionality function) {
        this.name = name;
        this.function = function;
    }

    
    
    
    
}
