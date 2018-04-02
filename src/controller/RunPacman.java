package controller;
import view.view.Pacman;

import java.awt.*;

public class RunPacman {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Pacman ex = new Pacman();
            ex.setVisible(true);
        });
    }
}
