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
public class SuccessRender extends RenderingState {

    @Override
    public void display(Graphics2D g2d, Game game) {
        String s = "Well Done. You Pass The Game";
        String s1 = "Click esc to quit";
        Font small = new Font("Helvetica", Font.BOLD, 25);
        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(s, 60, 200);
        g2d.drawString(s1, 60, 300);
    }

}
