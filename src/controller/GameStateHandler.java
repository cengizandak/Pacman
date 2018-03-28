/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.GameData;

import java.awt.*;

/**
 *
 * @author shan
 */
// state of the game 
public abstract class GameStateHandler {

    protected GameData gs;

    public abstract void display(Graphics2D g2d);
}
