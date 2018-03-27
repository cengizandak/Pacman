/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author christos
 */
public class GameContext {
    private GameStateHandler gs ;

    public GameContext() {
        this.gs = null;
    }

    public GameStateHandler getGs() {
        return gs;
    }

    public void setGs(GameStateHandler gs) {
        this.gs = gs;
    }
   
    
}
