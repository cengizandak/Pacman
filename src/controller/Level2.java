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
 * Ghosts move using eucledian distance metric
 */
public class Level2 implements StrategyMovement {

    @Override
    public void MoveGhost(Ghost ghost, Pacman pacman, Board board) {
        char[][] map = board.getStructure();
        int pacX = pacman.getCoordinateX();
        int pacY = pacman.getCoordinateY();
        int posX = ghost.getCoordinateX();
        int posY = ghost.getCoordinateY();
        int newX = posX, newY = posY;
System.out.println(posX+" "+posY);
        double minDist = Integer.MAX_VALUE;
        char minPos = 'n';
        double distance = 0;
        double num = Math.random();
        if (num <= 0.85) {
            if ((map[posX - 1][posY] == '0' || map[posX - 1][posY] == 'p' || map[posX - 1][posY] == 'b')) {
                distance = Math.sqrt(Math.pow(pacX - posX + 1, 2) + Math.pow(pacY - posY, 2));
                System.out.println(distance);
                if (distance <= minDist) {
                    minDist = distance;
                    minPos = 'u';
                }
            }
            if ((map[posX + 1][posY] == '0' || map[posX + 1][posY] == 'p' || map[posX + 1][posY] == 'b')) {
                distance = Math.sqrt(Math.pow(pacX - posX - 1, 2) + Math.pow(pacY - posY, 2));
                System.out.println(distance);
                if (distance <= minDist) {
                    minDist = distance;
                    minPos = 'd';
                }
            }
            if ((map[posX][posY - 1] == '0' || map[posX][posY - 1] == 'p' || map[posX][posY - 1] == 'b')) {
                distance = Math.sqrt(Math.pow(pacX - posX, 2) + Math.pow(pacY - posY + 1, 2));
                System.out.println(distance);
                if (distance <= minDist) {
                    minDist = distance;
                    minPos = 'l';
                }
            }
            if (map[posX][posY + 1] == '0' || map[posX][posY + 1] == 'p' || map[posX][posY + 1] == 'b') {
                distance = Math.sqrt(Math.pow(pacX - posX, 2) + Math.pow(pacY - posY - 1, 2));
                System.out.println(distance);
                if (distance <= minDist) {
                    minDist = distance;
                    minPos = 'r';
                }
            }
        }
        else{
            num = Math.random();
            if ( num <= 0.25 && (map[posX-1][posY]=='0' || map[posX-1][posY]=='p' || map[posX-1][posY]=='b' ) ){
                minPos='u';
            }else if ( num <= 0.5 && (map[posX+1][posY]=='0' || map[posX+1][posY]=='p' || map[posX+1][posY]=='b')){
                minPos='d';
            }else if ( num <= 0.75 && (map[posX][posY-1]=='0'  || map[posX][posY-1]=='p' || map[posX][posY-1]=='b')){
                minPos='l';
            }else if ( map[posX][posY+1]=='0' || map[posX][posY+1]=='p' || map[posX][posY+1]=='b'){
                minPos='r';
            }
        }
        System.out.println(minPos);
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
