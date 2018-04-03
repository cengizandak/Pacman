/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;
/**
 *
 * @author christos
 */
public  class Game {
    Board board;
    Fruit fruits[];
    GameData data;
    Ghost ghosts[];
    Pacman pacman;

    public Game() {
        data =new GameData();
        data.setData_state(GameData.gameStates.SELECTION);
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
    
    
}
