/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.GameData.*;
import model.*;

/**
 *
 * @author shan
 */
public class TestPattern {

    public static void main(String[] args) {
        LetterMovementAdapter letter = new LetterMovementAdapter(new LetterMovement());
        letter.down();
        letter.up();
        letter.left();
        letter.right();
        ArrowMovementAdapter arrow = new ArrowMovementAdapter(new ArrowMovement());
        arrow.down();
        arrow.up();
        arrow.left();
        arrow.right();
        GameStates gameState = GameStates.Selection;
        GameData gameData = new GameData(gameState, Levels.Level1, 22);
        GameContext gameContext = new GameContext();
        String gs = gameData.getGstate().toString();
        switch(gs) {
            case "Selection":
                SelectionState selectionState = new SelectionState();
                gameContext.setGs(selectionState);
                break;
            //...  Add other states 
        }
        gameContext.getGs().display();
        
        Pacman pacman = new Pacman(1,1,1,Pacman.State.NORMAL, 3);
        SmallBoard board = new SmallBoard();
        board.setParameters();
        ContextStrategy contextStrategy = new ContextStrategy(new Level1());
        Ghost g[] = new Ghost[board.getNumberOfGhosts()];
        g[0]  = new Ghost(1,22,Ghost.State.ALIVE);
        g[1] =new Ghost(2,22,Ghost.State.ALIVE);
        g[2] =new Ghost(3,22,Ghost.State.ALIVE);
        g[3] =new Ghost(4,22,Ghost.State.ALIVE);
        GhostRepository ghosts = new GhostRepository(g);
        
        for(Iterator iter = ghosts.getIterator(); iter.hasNext();){
            Ghost ghost = (Ghost)iter.next();
            System.out.println(ghost.getCoordinateX()+" "+ghost.getCoordinateY());
            contextStrategy.executeStrategy(ghost, pacman, board);
            System.out.println(ghost.getCoordinateX()+" "+ghost.getCoordinateY());
         
      } 
    }
    
   
}
