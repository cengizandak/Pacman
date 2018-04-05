package controller;

import view.Render.Pacman;
import javax.swing.*;

public class RunPacman {
    public static void main(String[] args) {
        Game game = new Game();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Pacman ex = new Pacman(game);
                ex.setVisible(true);
            }
        });
    }
}
