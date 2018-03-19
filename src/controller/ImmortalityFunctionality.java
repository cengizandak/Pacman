/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;

/**
 *
 * @author rizaoguzongun
 */
public class ImmortalityFunctionality implements FruitFunctionality {

    private Fruit fruit1;

    private Fruit fruit2;

    @Override
    public void functionality() {
        //necessary operations
    }

    public ImmortalityFunctionality(Fruit fruit1, Fruit fruit2) {
        this.fruit1 = fruit1;
        this.fruit2 = fruit2;
    }

    public Fruit getFruit1() {
        return fruit1;
    }

    public void setFruit1(Fruit fruit1) {
        this.fruit1 = fruit1;
    }

    public Fruit getFruit2() {
        return fruit2;
    }

    public void setFruit2(Fruit fruit2) {
        this.fruit2 = fruit2;
    }

}
