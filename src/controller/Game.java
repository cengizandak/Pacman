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
    
    public boolean checkIfPacmanStateIsSpeed() {
        return pacman.getPacmanState().equals(Pacman.State.FAST);
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
            if (game.getPacman().getCoordinateX() == ghost.getCoordinateX() && game.getPacman().getCoordinateY() == ghost.getCoordinateY()) {
                game.getPacman().setCoordinateX(1);
                game.getPacman().setCoordinateY(1);
                game.getPacman().setLives(game.getPacman().getLives() - 1);
                char[][] currentMap = game.getBoard().getStructure();
                currentMap[1][1] = 'p';
                return true;
            }
        }
        return false;
    }
    
    public boolean detectFruitTool(Game game) {
        int pacmanX = game.getPacman().getCoordinateX();
        int pacmanY = game.getPacman().getCoordinateY();
        for (Fruit fruit : game.speedFruits.getFruitList()) {
            if (pacmanX == fruit.getCoordinateX() && pacmanY == fruit.getCoordinateY() && fruit.getState().equals(Fruit.State.NOTEATEN)) {
                fruit.setState(Fruit.State.EATEN);
                //char[][] currentMap = game.getBoard().getStructure();
                //currentMap[pacmanX][pacmanY] = 'b';
                //game.getPacman().setCoordinateX(1);
                //game.getPacman().setCoordinateY(1);
                //game.getPacman().setPacmanState(Pacman.State.FAST); //should call the fruitFunctionality Implementations
                game.speedFruits.functionality(game);
                //currentMap[1][1] = 'p';
                return true;
            }
        }
        return false;
    }

}
