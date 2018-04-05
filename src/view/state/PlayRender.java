/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.state;


import controller.Game;

import java.awt.*;


import javax.swing.*;
import java.awt.event.*;

/**
 * @author shan
 */
public class PlayRender extends RenderingState {

    Image wall = new ImageIcon("/Users/shan/_IDEProject/IdeaProjects/Pacman/src/view/images/wall.png").getImage();

    @Override
    public void display() {

    }

    @Override
    public void display(Graphics2D g2d) {
    }

    @Override
    public void display(Graphics2D g2d, Game game) {
        g2d.setColor(new Color(5, 100, 5));
        g2d.setStroke(new BasicStroke(2));
        for (int i = 0; i < game.getBoard().getStructure().length; i++) {
            for (int j = 0; j < game.getBoard().getStructure()[0].length; j++) {
                int factori = (i + 1) * 10;
                int factorj = (j + 1) * 10;

                switch (game.getBoard().getStructure()[i][j]) {
                    case '1': {
                        g2d.setColor(Color.red);
                        g2d.fillRect(factori, factorj, 5, 5);
                    }
                    break;
                    case '0': {
                        g2d.setColor(Color.DARK_GRAY);
                        g2d.fillRect(factori, factorj, 5, 5);
                        break;
                    }
                    case 'g': {
                        g2d.setColor(Color.white);
                        g2d.fillRect(factori, factorj, 5, 5);
                        break;
                    }
                    case 'p': {
                        g2d.setColor(Color.magenta);
                        g2d.fillRect(factori, factorj, 5, 5);
                        break;
                    }
                }
            }
        }
    }





}