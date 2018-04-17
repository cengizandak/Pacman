package controller.adapter;

import controller.Game;

public class MovementAdapter implements KeyMovement {
    ArrowMovement arrowMovement;
    MouseMovement mouseMovement;


    public MovementAdapter(int input) {
        if (input == 37 || input == 38 || input == 39 || input == 40) {
            arrowMovement = new Arrow();
        } else{
            mouseMovement = new Mouse();
        }
    }


    @Override
    public void move(int input, Game game){
        if (input == 37 || input == 38 || input == 39 || input == 40) {
            arrowMovement.moveByArrow(input, game);
        }

        else {
            mouseMovement.moveByMouse(input, game);
        }
    }
}
