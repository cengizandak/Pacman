package controller;

import controller.state.GameContext;
import controller.state.PlayState;

public class TestState {
    public static void main(String[] args) {
        GameContext context = new GameContext();
        PlayState playstate = new PlayState();
        context.setGs(playstate);
        System.out.println(context.getGs());
    }
}
