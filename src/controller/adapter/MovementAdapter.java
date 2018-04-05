package controller.adapter;

import controller.Game;

public class MovementAdapter implements KeyMovement {
    ArrowMovement arrowMovement;

    public MovementAdapter(int input) {
        if (input == 37 || input == 38 || input == 39 || input == 40) {
            arrowMovement = new Arrow();
        }
    }


    @Override
    public void move(int input, Game game) {
        if (input == 37 || input == 38 || input == 39 || input == 40) {
            arrowMovement.moveByArrow(input, game);
        }
    }
}
