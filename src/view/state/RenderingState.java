package view.state;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.Game;

import java.awt.*;

/**
 * @author shan
 */
// state of the game
public abstract class RenderingState {
    public abstract void display(Graphics2D g2d, Game game);

}
