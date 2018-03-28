/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import model.Board;
import model.SmallBoard;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * @author shan
 * According to the flag, we called the display function of a state.In display function the parameter must be a Graphics2d in order to draw the pictures.
 * TAdapter is handling the key presses.
 */
public class SelectionState extends GameStateHandler {
    protected static Graphics2D g2dArg;

    public TAdapter SelectionAdapter() {
        TAdapter tAdapter = new TAdapter();
        return tAdapter;
    }

    @Override
    public void display(Graphics2D g2d) {
        g2dArg = g2d;
        System.out.println("Selection");
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 500, 500);

        String s = "WELCOME TO PACMAN";
        String s1 = "Choose the Board";
        Font small = new Font("Helvetica", Font.BOLD, 25);

        String smallText = "Press 's' for small Board";
        String mediumText = "Press 'm' for medium Board";
        String largeText = "Press 'l' for large Board";


        //FontMetrics metr = this.getFontMetrics(small);
        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, 50, 100);
        g2d.drawString(s1, 60, 200);
        g2d.drawString(smallText, 100, 350);
        g2d.drawString(mediumText, 100, 400);
        g2d.drawString(largeText, 100, 450);

    }
}
// s - is for small and l is for ..... After choosing the board factory class will be created and the flags will be set to the state chosen.

class TAdapter extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 's' || key == 'S') {
            System.out.println("=====Small chosen=====");
            //
            Graphics2D g2d = SelectionState.g2dArg;
            GameContext context = new GameContext();//implementation of State pattern
            PlayState playState = new PlayState();
            context.setGs(playState);
            context.doAction(g2d);
            BoardInit.setFlag("PLAY");// flag is set

        } else if (key == 'm' || key == 'M') {
            System.out.println("=====Medium chosen=====");
            Graphics2D g2d = SelectionState.g2dArg;
            GameContext context = new GameContext();
            PlayState playState = new PlayState();
            context.setGs(playState);
            context.doAction(g2d);
            // BoardFactory
            BoardFactory boardFactory = BoardFactory.getBoardFactory();
            Board smallBoard = boardFactory.createBoard("medium");
        } else if (key == 'l' || key == 'L') {
            System.out.println("=====Large chosen=====");
            Graphics2D g2d = SelectionState.g2dArg;
            GameContext context = new GameContext();
            PlayState playState = new PlayState();
            context.setGs(playState);
            context.doAction(g2d);
            // BoardFactory
            BoardFactory boardFactory = BoardFactory.getBoardFactory();
            Board smallBoard = boardFactory.createBoard("large");
        }
    }
}

