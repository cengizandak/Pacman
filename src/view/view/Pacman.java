package view.view;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controller.BoardInit;

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
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EventQueue.invokeLater(() -> {
            Pacman ex = new Pacman();
            ex.setVisible(true);
        });
    }

}
