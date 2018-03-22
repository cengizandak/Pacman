/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author shan
 */
public class LetterMovementAdapter implements Movement {

    private LetterMovement lettermovement;

    public LetterMovementAdapter(LetterMovement lettermovement) {
        this.lettermovement = lettermovement;
    }

    @Override
    public void up() {
        lettermovement.letterUp();
    }

    @Override
    public void down() {
        lettermovement.letterDown();
    }

    @Override
    public void left() {
        lettermovement.letterLeft();
    }

    @Override
    public void right() {
        lettermovement.letterRight();
    }

}
