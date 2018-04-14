/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author shan
 */
public class Pacman {

    /**
     * State of the Pacman which will effect the functionalities
     */
    public enum State {
        NORMAL, FAST, IMMORTAL;
    }
    private BufferedImage img;
    private int lives;

    private int speed;

    private int coordinateX;

    private int coordinateY;

    private State pacmanState;

    public int getSpeed() {
        return speed;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public State getPacmanState() {
        return pacmanState;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setPacmanState(State pacmanState) {
        this.pacmanState = pacmanState;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Pacman(int speed, int coordinateX, int coordinateY, State pacmanState, int lives) {
        this.speed = speed;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.pacmanState = pacmanState;
        // bug fixed
        this.lives = lives;
        try {
            img = ImageIO.read(new File("pacman_1.png"));

        } catch (IOException e) {
            System.out.println("where is the image?");
        }

    }

    public BufferedImage getImage() {
        return img;
    }

}
