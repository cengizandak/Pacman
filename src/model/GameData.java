/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//import controller.GameStateHandler;

/**
 * @author shan
 */
public class GameData {
    // fields
    private levels data_level;
    private int data_point;
    private gameStates data_state;

    public enum levels {
        LEVEL1, LEVEL2, LEVEL3
    }

    public enum gameStates {
        SELECTION, PLAY, PAUSE, GAMEOVER, SUCCESS
    }

    // getter and setter
    public levels getData_level() {
        return data_level;
    }

    public void setData_level(levels data_level) {
        this.data_level = data_level;
    }

    public int getData_point() {
        return data_point;
    }

    public void setData_point(int data_point) {
        this.data_point = data_point;
    }

    public gameStates getData_state() {
        return data_state;
    }

    public void setData_state(gameStates data_state) {
        this.data_state = data_state;
    }

}
