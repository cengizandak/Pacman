/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author rizaoguzongun
 */
public class ScoreFunctionality extends FruitFunctionality {
    
    public void functionality(Game game) {
        game.getData().setData_point(game.getData().getData_point() + 5);
    }
    
}
