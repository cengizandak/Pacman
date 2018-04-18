/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Pacman;

/**
 *
 * @author rizaoguzongun
 */
public class SpeedFunctionality extends FruitFunctionality {

    public void functionality(Game game) {
        if (game.pacman.getPacmanState().equals(Pacman.State.NORMAL)) {
            game.pacman.setPacmanState(Pacman.State.FAST);
        } else {
            game.pacman.setPacmanState(Pacman.State.FASTANDIMMORTAL);
        }
    }

}
