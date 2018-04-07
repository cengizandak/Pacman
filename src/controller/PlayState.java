/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.state.*;

import java.awt.*;

import model.GameData;

/**
 * @author christos
 */

public class PlayState implements GameState {

    @Override
    public void showDisplay(Graphics2D g, Game game) {
        new PlayRender().display(g, game);
    }

    @Override
    public void setState(Game game, GameContext context) {
        context.setGs(this);
        game.getData().setData_state(GameData.gameStates.PLAY);
    }

}
