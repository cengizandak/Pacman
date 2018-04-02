/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.state;


import controller.BoardFactory;
import model.Board;
import model.GameData;

import javax.swing.*;
import java.awt.*;

/**
 * @author shan
 */
public class PlayState extends GameState {

    Image wall = new ImageIcon("/Users/shan/_IDEProject/IdeaProjects/Pacman/src/view/images/wall.png").getImage();

    @Override
    public void display() {

    }

    @Override
    public void display(Graphics2D g2d) {
    }

    @Override
    public void display(Graphics2D g2d, GameData gameDate) {
        Board board = getBoard(gameDate);
        char[][] boardStructure = board.getStructure();
        g2d.setColor(new Color(5, 100, 5));
        g2d.setStroke(new BasicStroke(2));
        int a = 0; // x
        int b = 0; // y
        for (int i = 0; i < boardStructure[0].length; i++) {
            for (int j = 0; j < boardStructure.length; j++) {
                int factori = (i + 1) * 10;
                int factorj = (j + 1) * 10;
                switch (boardStructure[i][j]) {
                    case '1': {
                        g2d.setColor(Color.red);
                        g2d.fillRect(factori, factorj, 5, 5);
                    }
                    break;
                    case '0': {
                        g2d.setColor(Color.yellow);
                        g2d.fillRect(factori, factorj, 5, 5);
                    }
                }
            }
        }
    }

    // Get The Board Size
    private Board getBoard(GameData gameDate) {
        // implementation of Singleton
        BoardFactory boardFactory = BoardFactory.getBoardFactory();
        GameData.boards boardSize = gameDate.getData_boardSize();
        if (boardSize == GameData.boards.SMALL) {
            return boardFactory.createBoard(GameData.boards.SMALL);
        } else if (boardSize == GameData.boards.MEDIUM) {
            return boardFactory.createBoard(GameData.boards.MEDIUM);
        } else if (boardSize == GameData.boards.LARGE) {
            return boardFactory.createBoard(GameData.boards.LARGE);
        }
        return null;
    }
}
