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
 */
public class ContextStrategy {
     private StrategyMovement strategy;

   public ContextStrategy(StrategyMovement strategy){
      this.strategy = strategy;
   }

   public void executeStrategy(Ghost ghost, Pacman pacman, Board board){
      strategy.MoveGhost(ghost,pacman,board);
   }
}
