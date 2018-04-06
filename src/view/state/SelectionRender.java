/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.state;

import controller.Game;

import java.awt.*;

/**
 * @author shan
 * According to the flag, we called the display function of a state.In display function the parameter must be a Graphics2d in order to draw the pictures.
 * TAdapter is handling the key presses.
 */
public class SelectionRender extends RenderingState {
    @Override
    public void display() {

    }

    @Override
    public void display(Graphics2D g2d) {

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, 500, 500);

        String s = "WELCOME TO PACMAN";
        String s1 = "Choose the Board:";
        Font small = new Font("Helvetica", Font.BOLD, 25);

        String smallText = "   Press 's' or 'S' for small Board";
        String mediumText = "   Press 'm' or 'M' for medium Board";
        String largeText = "   Press 'l' or 'L' for large Board";
        String controlText = "You can control by pressing [W, A, S, D] or [↑, ←, ↓, →]";

        //FontMetrics metr = this.getFontMetrics(small);
        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, 60, 100);
        g2d.drawString(s1, 60, 150);
        g2d.drawString(smallText, 60, 200);
        g2d.drawString(mediumText, 60, 250);
        g2d.drawString(largeText, 60, 300);
        g2d.drawString(controlText, 60, 350);
    }

    @Override
    public void display(Graphics2D g2d, Game game) {

    }
}




