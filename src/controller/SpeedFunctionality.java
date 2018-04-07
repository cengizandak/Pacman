/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author rizaoguzongun
 */
public class SpeedFunctionality implements FruitFunctionality {

    private ArrayList<Fruit> fruitList;

    private Pacman pacman;

    @Override
    public void functionality() {
        pacman.setPacmanState(Pacman.State.FAST);
        pacman.setSpeed(5); //probably won't use it, thinking about stopping the ghosts for a while
    }

    public SpeedFunctionality() {
        fruitList = new ArrayList();
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public void addFruit(Fruit fruit) {
        fruitList.add(fruit);
    }
    
    public void deleteFruit(Fruit fruit) {
        fruitList.remove(fruit);
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }
    
}
