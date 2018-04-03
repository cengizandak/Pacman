/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.state;

import controller.Game;

import java.awt.*;

/**
 * @author shan
 */
public class PauseRender extends RenderingState {

    @Override
    public void display() {
        System.out.println("Pause the game");
    }

    @Override
    public void display(Graphics2D g2d) {

    }

    @Override
    public void display(Graphics2D g2d, Game game) {

    }

}
