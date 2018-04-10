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
    boards data_boardSize;
    SpeedFunctionality speedFruits;
    ImmortalityFunctionality immortalityFruits;

    public enum boards {
        SMALL, MEDIUM, LARGE
    }

    public Game() {
        data = new GameData();
        data.setData_state(GameData.gameStates.SELECTION);
        data.setData_point(0);
        data.setData_level(GameData.levels.LEVEL1);
        pacman = new Pacman(1, 1, 1, Pacman.State.NORMAL, 3);
        speedFruits = new SpeedFunctionality();
        immortalityFruits = new ImmortalityFunctionality();
    }

    public Game(GameData gd) {
        this.data = gd;
        this.data.setData_state(GameData.gameStates.PLAY);
        data.setData_point(0);
        data.setData_level(gd.getData_level());
        pacman = new Pacman(1, 1, 1, Pacman.State.NORMAL, 3);
        speedFruits = new SpeedFunctionality();
        immortalityFruits = new ImmortalityFunctionality();
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

    public void initializeFruits(int numberOfFruits) {
        fruits = new Fruit[numberOfFruits];
    }

    public void addFruit(int index, int coordinateX, int coordinateY) {
        //First fruit is speed, second is immortality and so on
        if (index % 2 == 0) {
            fruits[index] = new Fruit(coordinateX, coordinateY, Fruit.Functionality.SPEED);
            speedFruits.addFruit(fruits[index]);
        } else {
            fruits[index] = new Fruit(coordinateX, coordinateY, Fruit.Functionality.IMMORTALITY);
            immortalityFruits.addFruit(fruits[index]);
        }
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

    public void initializeGhosts(int numberOfGhosts) {
        ghosts = new Ghost[numberOfGhosts];
    }

    public void addGhost(int index, int coordinateX, int coordinateY) {
        ghosts[index] = new Ghost(coordinateX, coordinateY, Ghost.State.ALIVE);
    }

    public Pacman getPacman() {
        return pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public boolean checkIfPacmanStateIsFast() {
        return pacman.getPacmanState().equals(Pacman.State.FAST);
    }

    public boolean checkIfPacmanStateIsImmortal() {
        return pacman.getPacmanState().equals(Pacman.State.IMMORTAL);
    }

    public void setPacmanStateToNormal() {
        pacman.setPacmanState(Pacman.State.NORMAL);
    }

    public boards getData_boardSize() {
        return data_boardSize;
    }

    public void setData_boardSize(boards data_boardSize) {
        this.data_boardSize = data_boardSize;
    }


    public boolean detectGhostTool(Game game) {

        for (Ghost ghost : game.getGhosts()) {

            if (ghost.getState().equals(Ghost.State.ALIVE) && game.getPacman().getCoordinateX() == ghost.getCoordinateX() && game.getPacman().getCoordinateY() == ghost.getCoordinateY()) {
                if (game.getPacman().getPacmanState().equals(Pacman.State.IMMORTAL)) {
                    ghost.setState(Ghost.State.DEAD);
                } else {
                    game.getPacman().setCoordinateX(1);
                    game.getPacman().setCoordinateY(1);
                    game.getPacman().setLives(game.getPacman().getLives() - 1);
                    char[][] currentMap = game.getBoard().getStructure();
                    currentMap[1][1] = 'p';
                }
                return true;
            }
        }
        return false;
    }

    public boolean detectSpeedFruitTool(Game game) {
        char[][] map = game.getBoard().getStructure();
        for (Fruit fruit : game.speedFruits.getFruitList()) {
            if (game.getPacman().getCoordinateX() == fruit.getCoordinateX() && game.getPacman().getCoordinateY() == fruit.getCoordinateY() && fruit.getState().equals(Fruit.State.NOTEATEN)) {
                fruit.setState(Fruit.State.EATEN);
                System.out.println("SPEED");
                map[fruit.getCoordinateX()][fruit.getCoordinateY()] = 'p';
                game.speedFruits.functionality(game);
                return true;
            }
        }
        return false;
    }

    public boolean detectImmortalityFruitTool(Game game) {
        char[][] map = game.getBoard().getStructure();
        for (Fruit fruit : game.immortalityFruits.getFruitList()) {
            if (game.getPacman().getCoordinateX() == fruit.getCoordinateX() && game.getPacman().getCoordinateY() == fruit.getCoordinateY() && fruit.getState().equals(Fruit.State.NOTEATEN)) {
                System.out.println("iMMMMMMMM");
                fruit.setState(Fruit.State.EATEN);
                map[fruit.getCoordinateX()][fruit.getCoordinateY()] = 'p';
                game.immortalityFruits.functionality(game);
                return true;
            }
        }
        return false;
    }

}
