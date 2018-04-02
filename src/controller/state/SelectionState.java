/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.state;

import controller.BoardInit;
import model.GameData;

import java.awt.*;

/**
 * @author shan
 * According to the flag, we called the display function of a state.In display function the parameter must be a Graphics2d in order to draw the pictures.
 * TAdapter is handling the key presses.
 */
public class SelectionState extends GameState {
    @Override
    public void display() {

    }

    @Override
    public void display(Graphics2D g2d) {
        System.out.println("SELECTION");
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

    @Override
    public void display(Graphics2D g2d, GameData gameDate) {

    }
}




