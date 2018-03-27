/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.GameData;
import model.GameData.*;

/**
 *
 * @author shan
 */
public class TestPattern {

    public static void main(String[] args) {
        LetterMovementAdapter letter = new LetterMovementAdapter(new LetterMovement());
        letter.down();
        letter.up();
        letter.left();
        letter.right();
        ArrowMovementAdapter arrow = new ArrowMovementAdapter(new ArrowMovement());
        arrow.down();
        arrow.up();
        arrow.left();
        arrow.right();
        GameStates gameState = GameStates.Selection;
        GameData gameData = new GameData(gameState, Levels.Level1, 22);
        GameContext gameContext = new GameContext();
        String gs = gameData.getGstate().toString();
        switch(gs) {
            case "Selection":
                SelectionState selectionState = new SelectionState();
                gameContext.setGs(selectionState);
                break;
            //...  Add other states 
        }
        gameContext.getGs().display();
    }
}
