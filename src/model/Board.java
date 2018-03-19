/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author change
 */
public abstract class Board {

    private int NumberOfRows;
    private int NumberOfColumns;
    private int NumberOfFruits;
    private int NumberOfGhosts;
    private char[][] Structure;

    public abstract void setParameters();

    public int getNumberOfRows() {
        return NumberOfRows;
    }

    public void setNumberOfRows(int NumberOfRows) {
        this.NumberOfRows = NumberOfRows;
    }

    public int getNumberOfColumns() {
        return NumberOfColumns;
    }

    public void setNumberOfColumns(int NumberOfColumns) {
        this.NumberOfColumns = NumberOfColumns;
    }

    public int getNumberOfFruits() {
        return NumberOfFruits;
    }

    public void setNumberOfFruits(int NumberOfFruits) {
        this.NumberOfFruits = NumberOfFruits;
    }

    public int getNumberOfGhosts() {
        return NumberOfGhosts;
    }

    public void setNumberOfGhosts(int NumberOfGhosts) {
        this.NumberOfGhosts = NumberOfGhosts;
    }

    public char[][] getStructure() {
        return Structure;
    }

    public void setStructure(char[][] Structure) {
        this.Structure = Structure;
    }

}
