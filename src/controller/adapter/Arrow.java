package controller.adapter;

import controller.Game;
import model.Pacman;

public class Arrow implements ArrowMovement {
    @Override
    public void moveByArrow(int input, Game game){
        int speed = game.getPacman().getSpeed();
        char[][] map = game.getBoard().getStructure();
        switch (input) {
            // key handle
            case 38:
//                System.out.println("up pressed");
                if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() - 1] == '1') {
                    break;
                } else {
                    if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() - 1] == '0') {
                        // point++
                        game.getData().setData_point(game.getData().getData_point() + 1);
                    }
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = 'b';
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() - 1] = 'p';
                    game.getPacman().setCoordinateX(game.getPacman().getCoordinateX());
                    game.getPacman().setCoordinateY(game.getPacman().getCoordinateY() - 1);
                    game.detectGhostTool(game);
                    game.detectFruitTool(game);
                }
                break;
            case 37:
//                System.out.println("left pressed");
                if (map[game.getPacman().getCoordinateX() - 1][game.getPacman().getCoordinateY()] == '1') {
                    break;
                } else {
                    if (map[game.getPacman().getCoordinateX() - 1][game.getPacman().getCoordinateY()] == '0') {
                        // point++
                        game.getData().setData_point(game.getData().getData_point() + 1);
                    }
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = 'b';
                    map[game.getPacman().getCoordinateX() - 1][game.getPacman().getCoordinateY()] = 'p';
                    game.getPacman().setCoordinateX(game.getPacman().getCoordinateX() - 1);
                    game.getPacman().setCoordinateY(game.getPacman().getCoordinateY());
                    game.detectGhostTool(game);
                    game.detectFruitTool(game);
                }
                break;
            case 39:
//                System.out.println("right pressed");
                if (map[game.getPacman().getCoordinateX() + 1][game.getPacman().getCoordinateY()] == '1') {
                    break;
                } else {
                    if (map[game.getPacman().getCoordinateX() + 1][game.getPacman().getCoordinateY()] == '0') {
                        // point++
                        game.getData().setData_point(game.getData().getData_point() + 1);
                    }
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = 'b';
                    map[game.getPacman().getCoordinateX() + 1][game.getPacman().getCoordinateY()] = 'p';
                    game.getPacman().setCoordinateX(game.getPacman().getCoordinateX() + 1);
                    game.getPacman().setCoordinateY(game.getPacman().getCoordinateY());
                    game.detectGhostTool(game);
                    game.detectFruitTool(game);
                }
                break;
            case 40:
//                System.out.println("down pressed");
                if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() + 1] == '1') {
                    break;
                } else {
                    if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() + 1] == '0') {
                        // point++
                        game.getData().setData_point(game.getData().getData_point() + 1);
                    }
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = 'b';
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() + 1] = 'p';
                    game.getPacman().setCoordinateX(game.getPacman().getCoordinateX());
                    game.getPacman().setCoordinateY(game.getPacman().getCoordinateY() + 1);
                    game.detectGhostTool(game);
                    game.detectFruitTool(game);
                }

                break;
        }
    }
}