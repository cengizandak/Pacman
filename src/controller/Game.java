/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;

/**
 * @author christos
 */
public class Game {
    Board board;
    Fruit fruits[];
    GameData data;
    Ghost ghosts[];
    Pacman pacman;

    public Game() {
        data = new GameData();
        data.setData_state(GameData.gameStates.SELECTION);
        data.setData_point(0);
        data.setData_level(GameData.levels.LEVEL1);
        pacman = new Pacman(1, 1, 1, Pacman.State.NORMAL, 3);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Fruit[] getFruits() {
        return fruits;
    }

    public void setFruits(Fruit[] fruits) {
        this.fruits = fruits;
    }

    public GameData getData() {
        return data;
    }

    public void setData(GameData data) {
        this.data = data;
    }

    public Ghost[] getGhosts() {
        return ghosts;
    }

    public void setGhosts(Ghost[] ghosts) {
        this.ghosts = ghosts;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public void detectGhostTool(Game game) {
        for (Ghost ghost : game.getGhosts()) {
            if (game.getPacman().getCoordinateX() == ghost.getCoordinateX() && game.getPacman().getCoordinateY() == ghost.getCoordinateY()) {
                game.getPacman().setCoordinateX(1);
                game.getPacman().setCoordinateY(1);
                game.getPacman().setLives(game.getPacman().getLives() - 1);
                char[][] currentMap = game.getBoard().getStructure();
                currentMap[1][1] = 'p';
            }
        }
    }

}
