/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author shan
 */
public class Ghost {

    private int coordinateX;

    private int coordinateY;

    private int prevCoordinateX;

    private char prevValue;

    private State state;

    private PassedOver passedOver;

    public enum State {
        ALIVE, DEAD;
    }

    public enum PassedOver {
        DOT, BLANK, SPEED, IMMORTAL;
    }

    public int getPrevCoordinateX() {
        return prevCoordinateX;
    }

    public void setPrevCoordinateX(int prevCoordinateX) {
        this.prevCoordinateX = prevCoordinateX;
    }

    public int getPrevCoordinateY() {

        return prevCoordinateY;
    }

    public void setPrevCoordinateY(int prevCoordinateY) {
        this.prevCoordinateY = prevCoordinateY;
    }

    private int prevCoordinateY;

    public char getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(char prevValue) {
        this.prevValue = prevValue;
    }

    public Ghost(int coordinateX, int coordinateY, State state) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.state = state;
        passedOver = PassedOver.BLANK;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public PassedOver getPassedOver() {
        return passedOver;
    }

    public void setPassedOver(PassedOver passedOver) {
        this.passedOver = passedOver;
    }

}
