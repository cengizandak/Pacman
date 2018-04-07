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
    
    private int coordinateX;

    private int coordinateY;
    
    private Functionality function;

    private State state;
    
    public enum Functionality {
        SPEED, IMMORTALITY
    }
    
    public enum State {
        EATEN, NOTEATEN;
    }

    public Fruit(int coordinateX, int coordinateY, Functionality function) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.function = function;
        this.state = State.NOTEATEN;
        name = "fruit"; //name is not important, might even remove it later
    }

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

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
    
}
