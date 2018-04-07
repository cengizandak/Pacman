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
 */
public class GameOverRender extends RenderingState {
    @Override
    public void display(Graphics2D g2d, Game game) {
        String s = "GAME OVER";
        String esc = "Press ESC to the SELECTION Board";
        Font small = new Font("Helvetica", Font.BOLD, 30);
        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, 100, 200);
        g2d.drawString(esc, 100, 300);
    }
}
