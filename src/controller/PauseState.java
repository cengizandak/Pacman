/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics2D;
import model.GameData;
import view.state.PauseRender;

/**
 *
 * @author christos
 */
public class PauseState implements GameState {
    @Override
    public void showDisplay(Graphics2D g, Game game){
        new PauseRender().display(g, game);
    }
    @Override
    public void setState(Game game, GameContext context){
        context.setGs(this);
        game.getData().setData_state(GameData.gameStates.PAUSE);
    }
}
