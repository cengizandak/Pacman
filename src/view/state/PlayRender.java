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
    @Override
    public void display(Graphics2D g2d, Game game) {
        for (int i = 0; i < game.getBoard().getStructure().length; i++) {
            for (int j = 0; j < game.getBoard().getStructure()[0].length; j++) {
                int factori = (i + 1) * 20;
                int factorj = (j + 1) * 20;
                switch (game.getBoard().getStructure()[i][j]) {
                    case '1': {
                        g2d.setColor(new Color(14, 38, 179));
                        g2d.fillRect(factori, factorj, 15, 15);
                    }
                    break;
                    case '0': {
                        g2d.setColor(new Color(202, 135, 131));
                        factori += 5;
                        factorj += 5;
                        g2d.fillOval(factori, factorj, 5, 5);
                        break;
                    }
                    case 'g': {
                        g2d.setColor(new Color(255, 49, 0));
                        g2d.fillOval(factori, factorj, 15, 15);
                        break;
                    }
                    case 'p': {
                        if(game.checkIfPacmanStateIsImmortal()) {
                            g2d.setColor(Color.WHITE);
                        } else {
                            g2d.setColor(new Color(255, 251, 0));
                        }
                        g2d.fillOval(factori, factorj, 15, 15);
                        break;
                    }
                    // if the pacman eats dot, color changes to blank
                    case 'b': {
                        g2d.setColor(new Color(1, 1, 1));
                        g2d.fillOval(factori, factorj, 15, 15);
                        break;
                    }
                    case 's': {
                        g2d.setColor(Color.CYAN);
                        g2d.fillOval(factori, factorj, 15, 15);
                        break;
                    }
                    case 'i': {
                        g2d.setColor(Color.GREEN);
                        g2d.fillOval(factori, factorj, 15, 15);
                        break;
                    }
                }
            }
        }
    }


}
