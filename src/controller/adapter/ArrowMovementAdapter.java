/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.adapter;

/**
 *
 * @author shan
 */
public class ArrowMovementAdapter implements Movement {

    private ArrowMovement arrowmovement;

    public ArrowMovementAdapter(ArrowMovement arrowmovement) {
        this.arrowmovement = arrowmovement;
    }

    @Override
    public void up() {
        arrowmovement.arrowUp();
    }

    @Override
    public void down() {
        arrowmovement.arrowDown();
    }

    @Override
    public void left() {
        arrowmovement.arrowLeft();
    }

    @Override
    public void right() {
        arrowmovement.arrowRight();
    }

}
