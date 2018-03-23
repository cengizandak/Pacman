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
public class Level3 implements StrategyMovement{
      @Override
    public void MoveGhost(Ghost ghost,Pacman pacman, Board board){
        char[][] map = board.getStructure();
        int pacX = pacman.getCoordinateX();
        int pacY = pacman.getCoordinateY();
        int posX = ghost.getCoordinateX();
        int posY = ghost.getCoordinateY();
        int newX=posX, newY=posY;
        
        double minDist = Integer.MAX_VALUE;
        char minPos='n'; 
        double distance = 0;
        if (map[posX-1][posY]=='0'){
            distance = Math.abs(pacX-posX-1)+Math.abs(pacY-posY);
            if (distance <=minDist){
                minDist=distance;
                minPos='u';
            }
        }
        if (map[posX+1][posY]=='0'){
            distance = Math.abs(pacX-posX+1)+Math.abs(pacY-posY);
            if (distance <=minDist){
                minDist=distance;
                minPos='d';
            }
        }
        if (map[posX][posY-1]=='0'){
            distance = Math.abs(pacX-posX)+Math.abs(pacY-posY-1);
            if (distance <=minDist){
                minDist=distance;
                minPos='l';
            }
        }
        if (map[posX][posY+1]=='0'){
            distance = Math.abs(pacX-posX)+Math.abs(pacY-posY+1);
            if (distance <=minDist){
                minDist=distance;
                minPos='r';
            }
        }
        
        switch (minPos){
            case 'u' : newX=posX-1; break;
            case 'd' : newX=posX+1; break;
            case 'l' : newY=posY-1; break;
            case 'r' : newY=posY+1; break;
            default : break;        
        }
        ghost.setCoordinateX(newX);
        ghost.setCoordinateY(newY);
    }
    
}
