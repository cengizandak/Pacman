/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.*;
import java.awt.event.KeyAdapter;

/**
 * @author christos
 */
public interface GameState {
    void showDisplay(Graphics2D g, Game game);

    void setState(Game game, GameContext context);
}
