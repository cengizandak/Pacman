/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author rizaoguzongun
 */
public class ComboFunctionality extends FruitFunctionality {

    private ArrayList<FruitFunctionality> fruitList;

    public ComboFunctionality() {
        fruitList = new ArrayList();
    }

    public void functionality(Game game) {
        for (FruitFunctionality ff : fruitList) {
            ff.functionality(game);
        }
    }
    
    public ArrayList<FruitFunctionality> getFruitList() {
        return fruitList;
    }

    public void addFruit(FruitFunctionality fruit) {
        fruitList.add(fruit);
    }
    
    public void deleteFruit(FruitFunctionality fruit) {
        fruitList.remove(fruit);
    }

}
