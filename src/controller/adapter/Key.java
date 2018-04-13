package controller.adapter;


import controller.Game;

public class Key implements KeyMovement {
    MovementAdapter movementAdapter;

    @Override
    public void move(int input, Game game) {
        int speed = game.getPacman().getSpeed();
        char[][] map = game.getBoard().getStructure();
        switch (input) {
            // key handle
            case 87:
                // System.out.println("w pressed");
                if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() - 1] == '1') {
                    break;
                } else {
                    if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() - 1] == '0') {
                        // point++
                        game.getData().setData_point(game.getData().getData_point() + 1);
                    }
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = 'b';
                    if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() - 1] != 'g') {
                        map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() - 1] = 'p';
                    }
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() - 1] = 'p';
                    game.getPacman().setCoordinateX(game.getPacman().getCoordinateX());
                    game.getPacman().setCoordinateY(game.getPacman().getCoordinateY() - 1);
                    game.detectGhostTool(game);
                    game.detectSpeedFruitTool(game);
                    game.detectImmortalityFruitTool(game);
                }
                break;
            case 65:
                //System.out.println("a pressed");
                if (map[game.getPacman().getCoordinateX() - 1][game.getPacman().getCoordinateY()] == '1') {
                    break;
                } else {
                    if (map[game.getPacman().getCoordinateX() - 1][game.getPacman().getCoordinateY()] == '0') {
                        // point++
                        game.getData().setData_point(game.getData().getData_point() + 1);
                    }
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = 'b';
                    if (map[game.getPacman().getCoordinateX() - 1][game.getPacman().getCoordinateY()] != 'g') {
                        map[game.getPacman().getCoordinateX() - 1][game.getPacman().getCoordinateY()] = 'p';
                    }
                    game.getPacman().setCoordinateX(game.getPacman().getCoordinateX() - 1);
                    game.getPacman().setCoordinateY(game.getPacman().getCoordinateY());
                    game.detectGhostTool(game);
                    game.detectSpeedFruitTool(game);
                    game.detectImmortalityFruitTool(game);
                }
                break;
            case 68:
                // System.out.println("d pressed");
                if (map[game.getPacman().getCoordinateX() + 1][game.getPacman().getCoordinateY()] == '1') {
                    break;
                } else {
                    if (map[game.getPacman().getCoordinateX() + 1][game.getPacman().getCoordinateY()] == '0') {
                        // point++
                        game.getData().setData_point(game.getData().getData_point() + 1);
                    }
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = 'b';
                    if (map[game.getPacman().getCoordinateX() + 1][game.getPacman().getCoordinateY()] != 'g') {
                        map[game.getPacman().getCoordinateX() + 1][game.getPacman().getCoordinateY()] = 'p';
                    }
                    game.getPacman().setCoordinateX(game.getPacman().getCoordinateX() + 1);
                    game.getPacman().setCoordinateY(game.getPacman().getCoordinateY());
                    game.detectGhostTool(game);
                    game.detectSpeedFruitTool(game);
                    game.detectImmortalityFruitTool(game);
                }
                break;
            case 83:
                //System.out.println("s pressed");
                if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() + 1] == '1') {
                    break;
                } else {
                    if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() + 1] == '0') {
                        // point++
                        game.getData().setData_point(game.getData().getData_point() + 1);
                    }
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = 'b';
                    if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() + 1] != 'g') {
                        map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() + 1] = 'p';
                    }
                    game.getPacman().setCoordinateX(game.getPacman().getCoordinateX());
                    game.getPacman().setCoordinateY(game.getPacman().getCoordinateY() + 1);
                    game.detectGhostTool(game);
                    game.detectSpeedFruitTool(game);
                    game.detectImmortalityFruitTool(game);
                }

                break;
            // arrow handle
            case 37:
                movementAdapter = new MovementAdapter(37);
                movementAdapter.move(37, game);
                break;
            case 38:
                movementAdapter = new MovementAdapter(38);
                movementAdapter.move(38, game);
                break;
            case 39:
                movementAdapter = new MovementAdapter(39);
                movementAdapter.move(39, game);
                break;
            case 40:
                movementAdapter = new MovementAdapter(40);
                movementAdapter.move(40, game);
                break;
        }
    }
}
