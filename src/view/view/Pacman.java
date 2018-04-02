package view.view;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.*;
import java.awt.*;

/**
 * @author shan
 * main file for running the pacman Jframe.We can add panels to this JFrame.Nothing special here.
 */
public class Pacman extends JFrame {

    public Pacman() {
        add(new BoardInit());
        setTitle("Pacman Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
