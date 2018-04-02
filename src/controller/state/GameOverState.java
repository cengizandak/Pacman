/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.state;

import model.GameData;

import java.awt.*;

/**
 * @author shan
 */
public class GameOverState extends GameState {

    @Override
    public void display() {
        System.out.println("u loser!");
    }

    @Override
    public void display(Graphics2D g2d) {

    }

    @Override
    public void display(Graphics2D g2d, GameData gameDate) {

    }

}
