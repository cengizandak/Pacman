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
public class ImmortalityFunctionality implements FruitFunctionality {

    private ArrayList<Fruit> fruitList;  //maybe just remove this, and based on the enum in the fruit, call the function
    
    private Pacman pacman;

    @Override
    public void functionality(Game game) {
        game.pacman.setPacmanState(Pacman.State.IMMORTAL);
    }

    public ImmortalityFunctionality() {
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
