/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.GameState;

/**
 *
 * @author shan
 */
// state of the game 
public abstract class GameStateHandler {

    protected GameState gs;

    public abstract void display();
}
