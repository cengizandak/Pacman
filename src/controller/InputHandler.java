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
public class InputHandler {
    public void SelectBoard(int key, Game game){
        
        BoardFactory factory =BoardFactory.getBoardFactory(); 
        if (key == 's' || key == 'S') {
             Board small= (SmallBoard) factory.createBoard(GameData.boards.SMALL);
              game.setBoard(small);
        } else if (key == 'm' || key == 'M') {
             Board medium= (MediumBoard) factory.createBoard(GameData.boards.MEDIUM);
              game.setBoard(medium);
        } else if (key == 'l' || key == 'L') {
             Board large= (LargeBoard) factory.createBoard(GameData.boards.LARGE);
              game.setBoard(large);
        }
    }
}
