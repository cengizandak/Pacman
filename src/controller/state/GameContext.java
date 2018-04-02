/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.state;

import model.GameData;

import java.awt.*;

/**
 * @author christos
 */
public class GameContext {
    private GameState gameState;

    public GameContext() {
        this.gameState = null;
    }

    public GameState getGs() {
        return gameState;
    }

    public void setGs(GameState gameState) {
        this.gameState = gameState;
    }

    public void doAction() {
        this.gameState.display();
    }

    public void doAction(Graphics2D g2d) {
        this.gameState.display(g2d);
    }

    public void doAction(Graphics2D g2d, GameData gameDate) {
        this.gameState.display(g2d, gameDate);
    }
}
