/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author shan
 */
public class GameState {
    public enum Levels { Level1, Level2, Level3 };
    public enum State { SELECTION, PLAY, PAUSE, GAMEOVER, SUCCESS }
    private State state; 
    private Levels level;
    private int points;

    public GameState(State state, Levels level, int points) {
        this.state = state;
        this.level = level;
        this.points = points;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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
    
    
}
