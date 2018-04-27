/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.state;

import controller.Game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * @author shan
 */
public class PlayRender extends RenderingState {

    @Override
    public void display(Graphics2D g2d, Game game) {
        BufferedImage img = game.getPacman().getImage();
        BufferedImage cherry = null;
        BufferedImage star = null;
        BufferedImage combo = null;
        BufferedImage score = null;
        BufferedImage strawberry = null;
        try {
            cherry = ImageIO.read(new File("cherry.png"));
            star = ImageIO.read(new File("banana.png"));
            combo = ImageIO.read(new File("combo.png"));
            score = ImageIO.read(new File("score.png"));
            strawberry = ImageIO.read(new File("strawberry.png"));
        } catch (IOException e) {
            // System.out.println("where is the image?");
        }
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
                        g2d.setColor(new Color(255, 255, 255));
                        factori += 7;
                        factorj += 7;
                        g2d.fillOval(factori, factorj, 3, 3);
                        break;
                    }
                    case 'g': {
                        g2d.setColor(new Color(255, 49, 0));
                        g2d.drawImage(game.getGhosts()[0].getImage(game.getData()), factori, factorj, 15, 15, null);
                        //g2d.fillOval(factori, factorj, 15, 15);
                        break;
                    }
                    case 'p': {
                        if (game.checkIfPacmanStateIsImmortal()) {
                            g2d.setColor(Color.WHITE);
                        } else {
                            g2d.setColor(new Color(255, 251, 0));
                        }

                        //g2d.drawImage(img, factori, factorj, 15, 15, null);
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
                        g2d.drawImage(strawberry, factori, factorj, 15, 15, null);
                        //g2d.fillOval(factori, factorj, 15, 15);
                        break;
                    }
                    case 'i': {
                        g2d.setColor(Color.GREEN);
                        g2d.drawImage(star, factori, factorj, 15, 15, null);
                        //g2d.fillOval(factori, factorj, 15, 15);
                        break;
                    }
                    // combo
                    case 'c': {
                        g2d.setColor(Color.PINK);
                        // g2d.fillOval(factori, factorj, 15, 15);
                        g2d.drawImage(combo, factori, factorj, 15, 15, null);
                        break;
                    }
                    // score
                    case 'o': {
                        g2d.setColor(Color.BLUE);
                        // g2d.fillOval(factori, factorj, 15, 15);
                        g2d.drawImage(score, factori, factorj, 15, 15, null);
                        break;
                    }
                }
            }
        }
    }

}
