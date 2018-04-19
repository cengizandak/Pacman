/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Board;
import model.Ghost;
import model.Pacman;

/**
 *
 * @author christos
 *
 * Level 3: ghosts move using the manhattan distance metric
 */
public class Level3 implements StrategyMovement {

    @Override
    public void MoveGhost(Ghost ghost, Pacman pacman, Board board) {
        char[][] map = board.getStructure();
        int pacX = pacman.getCoordinateX();
        int pacY = pacman.getCoordinateY();
        int posX = ghost.getCoordinateX();
        int posY = ghost.getCoordinateY();
        int newX = posX, newY = posY;

        double minDist = Integer.MAX_VALUE;
        char minPos = 'n';
        double distance = 0;
        double num = Math.random();
        if (num <= 0.6) {
            if ((map[posX - 1][posY] == '0' || map[posX - 1][posY] == 'p' || map[posX - 1][posY] == ' ')) {
                distance = Math.abs(pacX - posX + 1) + Math.abs(pacY - posY);
                if (distance <= minDist) {
                    minDist = distance;
                    minPos = 'u';
                }
            }
            if ((map[posX + 1][posY] == '0' || map[posX + 1][posY] == 'p' || map[posX + 1][posY] == ' ')) {
                distance = Math.abs(pacX - posX - 1) + Math.abs(pacY - posY);
                if (distance <= minDist) {
                    minDist = distance;
                    minPos = 'd';
                }
            }
            if ((map[posX][posY - 1] == '0' || map[posX][posY - 1] == 'p' || map[posX][posY - 1] == ' ')) {
                distance = Math.abs(pacX - posX) + Math.abs(pacY - posY + 1);
                if (distance <= minDist) {
                    minDist = distance;
                    minPos = 'l';
                }
            }
            if (map[posX][posY + 1] == '0' || map[posX][posY + 1] == 'p' || map[posX][posY + 1] == ' ') {
                distance = Math.abs(pacX - posX) + Math.abs(pacY - posY - 1);
                if (distance <= minDist) {
                    minDist = distance;
                    minPos = 'r';
                }
            }
        } else {
            num = Math.random();
            if (num <= 0.25 && (map[posX - 1][posY] == '0' || map[posX - 1][posY] == 'p' || map[posX - 1][posY] == ' ')) {
                minPos = 'u';
            } else if (num <= 0.5 && (map[posX + 1][posY] == '0' || map[posX + 1][posY] == 'p' || map[posX + 1][posY] == ' ')) {
                minPos = 'd';
            } else if (num <= 0.75 && (map[posX][posY - 1] == '0' || map[posX][posY - 1] == 'p' || map[posX][posY - 1] == ' ')) {
                minPos = 'l';
            } else if (map[posX][posY + 1] == '0' || map[posX][posY + 1] == 'p' || map[posX][posY + 1] == ' ') {
                minPos = 'r';
            }
        }

        switch (minPos) {
            case 'u':
                newX = posX - 1;
                break;
            case 'd':
                newX = posX + 1;
                break;
            case 'l':
                newY = posY - 1;
                break;
            case 'r':
                newY = posY + 1;
                break;
            default:
                break;
        }
        ghost.setCoordinateX(newX);
        ghost.setCoordinateY(newY);
    }

}
