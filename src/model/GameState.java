/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.GameStateHandler;

/**
 *
 * @author shan
 */
public class GameState {

    public enum Levels {
        Level1, Level2, Level3
    };

    private Levels level;
    private int points;
    private GameStateHandler gstate = null;
    public GameState(GameStateHandler gstate, Levels level, int points) {
        this.gstate = gstate;
        this.level = level;
        this.points = points;
    }

    public Levels getLevel() {
        return level;
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public void display()
    {
       gstate.display();
    
    
    }

}
