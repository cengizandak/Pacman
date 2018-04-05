package controller.adapter;


import controller.Game;
import model.Pacman;

public class Key implements KeyMovement {
    MovementAdapter movementAdapter;

    @Override
    public void move(int input, Game game) {
        int speed = game.getPacman().getSpeed();
        char[][] map = game.getBoard().getStructure();
        System.out.println(game.getPacman().getCoordinateX());
        System.out.println(game.getPacman().getCoordinateY());
        switch (input) {
            // key handle
            case 87:
                System.out.println("w pressed");
                if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() - 1] == '1') {
                    break;
                } else {
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = '0';
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() - 1] = 'p';
                    game.setPacman(new Pacman(speed, game.getPacman().getCoordinateX(), game.getPacman().getCoordinateY() - 1, Pacman.State.NORMAL, 3));
                }
                break;
            case 65:
                System.out.println("a pressed");
                if (map[game.getPacman().getCoordinateX() - 1][game.getPacman().getCoordinateY()] == '1') {
                    break;
                } else {
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = '0';
                    map[game.getPacman().getCoordinateX() - 1][game.getPacman().getCoordinateY()] = 'p';
                    game.setPacman(new Pacman(speed, game.getPacman().getCoordinateX() - 1, game.getPacman().getCoordinateY(), Pacman.State.NORMAL, 3));
                }
                break;
            case 68:
                System.out.println("d pressed");
                if (map[game.getPacman().getCoordinateX() + 1][game.getPacman().getCoordinateY()] == '1') {
                    break;
                } else {
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = '0';
                    map[game.getPacman().getCoordinateX() + 1][game.getPacman().getCoordinateY()] = 'p';
                    game.setPacman(new Pacman(speed, game.getPacman().getCoordinateX() + 1, game.getPacman().getCoordinateY(), Pacman.State.NORMAL, 3));
                }
                break;
            case 83:
                System.out.println("s pressed");
                if (map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() + 1] == '1') {
                    break;
                } else {
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = '0';
                    map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY() + 1] = 'p';
                    game.setPacman(new Pacman(speed, game.getPacman().getCoordinateX(), game.getPacman().getCoordinateY() + 1, Pacman.State.NORMAL, 3));
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
