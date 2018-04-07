package controller.adapter;

import controller.Game;

public interface KeyMovement {
    public void move(int input, Game game) throws InterruptedException;
}
