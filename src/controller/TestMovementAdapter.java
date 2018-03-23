/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;
/**
 *
 * @author shan
 */
public class TestMovementAdapter {

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
        SmallBoard sb = new SmallBoard();
        sb.setParameters();
        char[][] teststructure=sb.getStructure();
        for(int i = 0 ; i< teststructure.length;i++){
            for(int j=0;j<teststructure[0].length;j++){
                System.out.print(teststructure[i][j]);
            }
            System.out.println();
        }
    }
}
