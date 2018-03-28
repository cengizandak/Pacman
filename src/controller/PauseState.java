/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;

/**
 *
 * @author shan
 */
public class PauseState extends GameStateHandler {

    @Override
    public void display(Graphics2D g2d) {
        System.out.println("Pause the game");
    }

}
