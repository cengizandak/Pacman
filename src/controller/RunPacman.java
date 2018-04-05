package controller;
import view.Render.Pacman;

import java.awt.*;
import model.GameData;

public class RunPacman {
    public static void main(String[] args) {
        Game game = new Game();
        
        EventQueue.invokeLater(() -> {
            Pacman ex = new Pacman(game);
            ex.setVisible(true);
        });
    }
}
