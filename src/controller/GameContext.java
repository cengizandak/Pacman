/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.*;

/**
 * @author christos
 */
public class GameContext {
    private GameStateHandler gs;

    public GameContext() {
        this.gs = null;
    }

    public GameStateHandler getGs() {
        return gs;
    }

    public void setGs(GameStateHandler gs) {
        this.gs = gs;
    }

    public void doAction(Graphics2D g2d) {
        this.gs.display(g2d);
    }
}
