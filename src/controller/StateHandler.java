/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics2D;

/**
 * @author christos
 */
public class StateHandler {

    public GameState changeState(Game game, String state) {
        GameContext context = new GameContext();
        switch (state) {
            case "SELECTION":
                SelectionState selectionState = new SelectionState();
                selectionState.setState(game, context);
                return selectionState;
            case "GAMEOVER":
                GameOverState gameoverState = new GameOverState();
                gameoverState.setState(game, context);
                return gameoverState;
            case "PAUSE":
                PauseState pauseState = new PauseState();
                pauseState.setState(game, context);
                return pauseState;
            case "SUCCESS":
                SuccessState successState = new SuccessState();
                successState.setState(game, context);
                return successState;
            case "PLAY":
                PlayState playState = new PlayState();
                playState.setState(game, context);
                return playState;
            default:
                SelectionState sState = new SelectionState();
                sState.setState(game, context);
                return sState;
        }
    }

    public void DisplayState(GameState gameState, Graphics2D g, Game game) {
        gameState.showDisplay(g, game);
    }
}
