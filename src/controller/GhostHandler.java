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
public class GhostHandler {
    //Using this functions for fruit placement as well
    public int[] placeRandom(Game game) {
        char map[][] = game.getBoard().getStructure();
        int row = 0;
        int column = 0;
        while (map[row][column] == '1' || map[row][column] == 'p' || map[row][column] == 'g' || map[row][column] == 'i' || map[row][column] == 's') {
            row = ((int) (Math.random() * 1000)) % map.length;
            column = ((int) (Math.random() * 1000)) % map[0].length;
        }
        int position[] = new int[2];
        position[0] = row;
        position[1] = column;
        return position;
    }

    public void ConstantMoving(Game game) {

        char map[][] = game.getBoard().getStructure();
        StrategyMovement level = null;
        if (game.getData().getData_level().toString().equals("LEVEL1")) {
            level = new Level1();
        }
        if (game.getData().getData_level().toString().equals("LEVEL2")) {
            System.out.println("Changed");
            level = new Level2();
        }
        if (game.getData().getData_level().toString().equals("LEVEL3")) {
            level = new Level3();
        }
        GhostRepository ghosts = new GhostRepository(game.getGhosts());
        Ghost g[] = new Ghost[game.getGhosts().length];
        int count = 0;
        ContextStrategy contextStrategy = new ContextStrategy(level);
        for (Iterator iter = ghosts.getIterator(); iter.hasNext(); ) {
            Ghost ghost = (Ghost) iter.next();
            if (ghost.getState().equals(Ghost.State.ALIVE)) {
                //Assiging the value of previous place
                if (ghost.getPassedOver().equals(Ghost.PassedOver.BLANK)) {
                    map[ghost.getCoordinateX()][ghost.getCoordinateY()] = 'b';
                } else {
                    map[ghost.getCoordinateX()][ghost.getCoordinateY()] = '0';
                }
                contextStrategy.executeStrategy(ghost, game.getPacman(), game.getBoard());
                //Keeping the value of the passed place's value
                //If we make ghosts able to pass fruits, we need to add that as well
                char prevPos = map[ghost.getCoordinateX()][ghost.getCoordinateY()];
                if (prevPos == 'b') {
                    ghost.setPassedOver(Ghost.PassedOver.BLANK);
                } else {
                    ghost.setPassedOver(Ghost.PassedOver.DOT);
                }
                map[ghost.getCoordinateX()][ghost.getCoordinateY()] = 'g';
            }
            g[count] = ghost;
            count++;
        }
        game.setGhosts(g);
    }
}
