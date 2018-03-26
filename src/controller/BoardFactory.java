/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;

/**
 *
 * @author rizaoguzongun
 */
public class BoardFactory {

    private static BoardFactory boardFactory;

    //Making the constructor private makes the class Singleton
    private BoardFactory() {

    }

    //This will be used to get the only instance of the class
    public static BoardFactory getBoardFactory() {
        if (boardFactory == null) {
            boardFactory = new BoardFactory();
        }
        return boardFactory;
    }

    public Board createBoard(String boardSize) {

        switch (boardSize) {
            case "small":
                SmallBoard smallBoard = new SmallBoard();
                smallBoard.setParameters();
                return smallBoard;
            case "medium":
                MediumBoard mediumBoard = new MediumBoard();
                mediumBoard.setParameters();
                return mediumBoard;
            case "large":
                LargeBoard largeBoard = new LargeBoard();
                largeBoard.setParameters();
                return largeBoard;
        }
        //If invalid value is given, mediumBoard will be returned
        MediumBoard mediumBoard = new MediumBoard();
        mediumBoard.setParameters();
        return mediumBoard;

    }

}
