package view.Render;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.Game;

import javax.swing.*;
import java.awt.*;

/**
 * @author shan
 * main file for running the pacman Jframe.We can add panels to this JFrame.Nothing special here.
 */
public class Pacman extends JFrame {

    public Pacman(Game game) {
        add(new BoardInit(game));
        setTitle("Pacman Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(785, 655);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
