/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.GameState;
import model.GameState.*;

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
        GameState gs = new GameState(new SelectionState(), Levels.Level1, 22);
        gs.display();
    }
}
