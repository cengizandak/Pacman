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

    @Override
    public void functionality() {
        //necessary operations
        //make the Pacman faster for 10 seconds
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

}
