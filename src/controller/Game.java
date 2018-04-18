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
    //Fruit fruits[];
    FruitFunctionality fruitFunctionalities[];
    //Use only functionalty class and each element should have a fruit
    GameData data;
    Ghost ghosts[];
    Pacman pacman;
    boards data_boardSize;

    public enum boards {
        SMALL, MEDIUM, LARGE
    }

    public Game() {
        data = new GameData();
        data.setData_state(GameData.gameStates.SELECTION);
        data.setData_point(0);
        data.setData_level(GameData.levels.LEVEL1);
        pacman = new Pacman(1, 1, 1, Pacman.State.NORMAL, 3);
    }

    public Game(GameData gd) {
        this.data = gd;
        this.data.setData_state(GameData.gameStates.PLAY);
        data.setData_point(0);
        data.setData_level(gd.getData_level());
        pacman = new Pacman(1, 1, 1, Pacman.State.NORMAL, 3);
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public FruitFunctionality[] getFruitFunctionalities() {
        return fruitFunctionalities;
    }

    public void setFruitFunctionalities(FruitFunctionality[] fruitFunctionalities) {
        this.fruitFunctionalities = fruitFunctionalities;
    }

    public void initializeFruits(int numberOfFruits) {
        fruitFunctionalities = new FruitFunctionality[numberOfFruits];
    }

    public void addFruit(int index, int coordinateX, int coordinateY) {
        if (index % 4 == 0) {
            ComboFunctionality comboFruit = new ComboFunctionality();
            comboFruit.setFruit(new Fruit(coordinateX, coordinateY, Fruit.Functionality.COMBO));
            if(index == 0) {
                comboFruit.addFruit(new ImmortalityFunctionality());
                comboFruit.addFruit(new SpeedFunctionality());
            } else if (index == 4) {
                comboFruit.addFruit(new ImmortalityFunctionality());
                comboFruit.addFruit(new ScoreFunctionality());
            } else {
                comboFruit.addFruit(new SpeedFunctionality());
                comboFruit.addFruit(new ScoreFunctionality());
            }
            fruitFunctionalities[index] = comboFruit;
        } else if (index % 4 == 1) {
            ScoreFunctionality scoreFruit = new ScoreFunctionality();
            scoreFruit.setFruit(new Fruit(coordinateX, coordinateY, Fruit.Functionality.SCORE));
            fruitFunctionalities[index] = scoreFruit;
        } else if (index % 4 == 2) {
            SpeedFunctionality speedFruit = new SpeedFunctionality();
            speedFruit.setFruit(new Fruit(coordinateX, coordinateY, Fruit.Functionality.SPEED));
            fruitFunctionalities[index] = speedFruit;
        } else {
            ImmortalityFunctionality immortalityFruit = new ImmortalityFunctionality();
            immortalityFruit.setFruit(new Fruit(coordinateX, coordinateY, Fruit.Functionality.IMMORTALITY));
            fruitFunctionalities[index] = immortalityFruit;
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
        return (pacman.getPacmanState().equals(Pacman.State.FAST) || pacman.getPacmanState().equals(Pacman.State.FASTANDIMMORTAL));
    }

    public boolean checkIfPacmanStateIsImmortal() {
        return (pacman.getPacmanState().equals(Pacman.State.IMMORTAL) || pacman.getPacmanState().equals(Pacman.State.FASTANDIMMORTAL));
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
                if (game.getPacman().getPacmanState().equals(Pacman.State.IMMORTAL) || game.getPacman().getPacmanState().equals(Pacman.State.FASTANDIMMORTAL)) {
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

    public boolean detectFruitTool(Game game) {
        char[][] map = game.getBoard().getStructure();
        for (FruitFunctionality fruitFunctionality : game.getFruitFunctionalities()) {
            if (game.getPacman().getCoordinateX() == fruitFunctionality.getFruit().getCoordinateX() && game.getPacman().getCoordinateY() == fruitFunctionality.getFruit().getCoordinateY() && fruitFunctionality.getFruit().getState().equals(Fruit.State.NOTEATEN)) {
                fruitFunctionality.getFruit().setState(Fruit.State.EATEN);
                System.out.println("FUNCTIONALITY");
                map[fruitFunctionality.getFruit().getCoordinateX()][fruitFunctionality.getFruit().getCoordinateY()] = 'p';
                fruitFunctionality.functionality(game);
                return true;
            }
        }
        return false;
    }

}
