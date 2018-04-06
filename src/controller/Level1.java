/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;

/**
 * @author christos
 * <p>
 * Level 1: Ghosts move randomly
 */
public class Level1 implements StrategyMovement {
    @Override
    public void MoveGhost(Ghost ghost, Pacman pacman, Board board) {
        char[][] map = board.getStructure();
        int posX = ghost.getCoordinateX();
        int posY = ghost.getCoordinateY();
        int newX = posX, newY = posY;
        double num = Math.random();
        if (num <= 0.25 && (map[posX - 1][posY] == '0' || map[posX - 1][posY] == 'p' || map[posX - 1][posY] == ' ')) {
            newX = posX - 1;
        } else if (num <= 0.5 && (map[posX + 1][posY] == '0' || map[posX + 1][posY] == 'p' || map[posX + 1][posY] == ' ')) {
            newX = posX + 1;
        } else if (num <= 0.75 && (map[posX][posY - 1] == '0' || map[posX][posY - 1] == 'p' || map[posX][posY - 1] == ' ')) {
            newY = posY - 1;
        } else if (map[posX][posY + 1] == '0' || map[posX][posY + 1] == 'p' || map[posX][posY + 1] == ' ') {
            newY = posY + 1;
        }

        ghost.setCoordinateX(newX);
        ghost.setCoordinateY(newY);
    }
}
