/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Fruit;

/**
 *
 * @author rizaoguzongun
 */
public abstract class FruitFunctionality {
    
    private Fruit fruit;

    public abstract void functionality(Game game);

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }
    
}
