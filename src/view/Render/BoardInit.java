package view.Render;

import controller.*;
import controller.adapter.*;
import model.GameData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Firstly this is the panel and we initiliaze the board here.
// dodrawing() contains different cases with respect to the flags.
// Flags are about the game states,
// timer is working every 40msec and running the paintComponent(g)
// which is a common function of the ActionListener.

public class BoardInit extends JPanel implements ActionListener {
    private Game game;
    private GameState state;
    BoardFactory factory = BoardFactory.getBoardFactory();
    private Timer timer = new Timer(120, this);
    private boolean selectionAdapterFlag = true;
    private boolean playAdapterFlag = true;
    private boolean gameOverAdapterFlag = true;
    private Key key = new Key();
    private StateHandler stateHandler = new StateHandler();
    private GhostHandler gh = new GhostHandler();
    private int fruitSpeedFunctionalityTimer = 0;
    private int fruitImmortalityFunctionalityTimer = 0;
    int levelflag = 2;

    public BoardInit() {
        initBoard();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    private void initBoard() {
        setFocusable(true);
        setBackground(Color.black);
        setDoubleBuffered(true);
        setGame(new Game());
        state = stateHandler.changeState(game, "SELECTION");
        timer.start();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);

    }

    /*
     * This method would run every 40ms(depends on timer).
     * */
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // =====SELECTION STATE=====
        if (game.getData().getData_state().toString().equals("SELECTION")) {

            removeKeyListener(PlayAdapter);
            if (selectionAdapterFlag) {
                addKeyListener(SelectionAdapter);
                selectionAdapterFlag = false;
                gameOverAdapterFlag = true;
            }
            state.showDisplay(g2d, game);
        } else if (game.getData().getData_state().toString().equals("PLAY")) {

            // =====PLAY STATE=====
            removeKeyListener(SelectionAdapter);
            removeKeyListener(GameOverAdapter);

            // addKeyListener(PlayAdapter) should be only executed once;
            if (playAdapterFlag) {
                addKeyListener(PlayAdapter);
                playAdapterFlag = false;
            }
            drawCountSCore(g2d, game);
            if (levelflag == CalcScore(game)) {
                if (levelflag == 4) {
                    removeKeyListener(SelectionAdapter);
                    removeKeyListener(PlayAdapter);
                    state = stateHandler.changeState(game, "SUCCESS");
                    state.showDisplay(g2d, game);
                    addKeyListener(SuccessAdapter);
                    timer.stop();
                }
                CalcScore(game);
                System.out.println(levelflag);
                if (game.getBoard().getNumberOfColumns() == 10) {
                    setGame(new Game(game.getData()));
                    game.setBoard(factory.createBoard(Game.boards.SMALL));
                } else if (game.getBoard().getNumberOfColumns() == 20) {
                    setGame(new Game(game.getData()));
                    game.setBoard(factory.createBoard(Game.boards.MEDIUM));
                } else if (game.getBoard().getNumberOfColumns() == 30) {
                    setGame(new Game(game.getData()));
                    game.setBoard(factory.createBoard(Game.boards.LARGE));
                }
                creater(game);
                levelflag++;
                // gc.ConstantMoving(game);
            }
            //do something here for fruits
            game.detectGhostTool(game);
            game.detectSpeedFruitTool(game);
            game.detectImmortalityFruitTool(game);
            state.showDisplay(g2d, game);
            //If speed fruit is eaten ghosts will stop
            if (!game.checkIfPacmanStateIsFast()) {
                gh.ConstantMoving(game);
            } else {
                fruitSpeedFunctionalityTimer++;
                if (fruitSpeedFunctionalityTimer == 30) {
                    game.setPacmanStateToNormal();
                    fruitSpeedFunctionalityTimer = 0;
                }
            }
            if (game.checkIfPacmanStateIsImmortal()) {
                fruitImmortalityFunctionalityTimer++;
                if (fruitImmortalityFunctionalityTimer == 30) {
                    game.setPacmanStateToNormal();
                    fruitImmortalityFunctionalityTimer = 0;
                }
            }
            game.detectGhostTool(game);
            game.detectSpeedFruitTool(game);
            game.detectImmortalityFruitTool(game);
            if (game.getPacman().getLives() <= 0) {
                state = stateHandler.changeState(game, "GAMEOVER");
            }
        } else if (game.getData().getData_state().toString().equals("GAMEOVER")) {
            // ===== STATE=====
            removeKeyListener(SelectionAdapter);
            removeKeyListener(PlayAdapter);
            if (gameOverAdapterFlag) {
                addKeyListener(GameOverAdapter);
                gameOverAdapterFlag = false;
                selectionAdapterFlag = true;
                playAdapterFlag = true;
            }
            state.showDisplay(g2d, game);
            setGame(new Game());
        }
        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();

    }

    // drawing LEVEL, SCORE and LIVES to the board
    public void drawCountSCore(Graphics2D g2d, Game game) {
        String sLevel = "" + game.getData().getData_level();
        String sPoint = "SCORE: " + Integer.toString(game.getData().getData_point());
        String sLive = "Live(s): " + game.getPacman().getLives();
        Font small = new Font("Helvetica", Font.BOLD, 20);
        g2d.setColor(Color.white);
        g2d.setFont(small);
        g2d.drawString(sLevel, 650, 70);
        g2d.drawString(sPoint, 650, 100);
        g2d.drawString(sLive, 650, 130);
    }

    public int CalcScore(Game game) {
        if (game.getData().getData_point() > 30 && game.getBoard().getNumberOfGhosts() == 2) {
            if (game.getData().getData_level() == GameData.levels.LEVEL1) {
                game.getData().setData_level(GameData.levels.LEVEL2);
                //  game.setBoard(factory.createBoard(Game.boards.SMALL));
                game.getData().setData_point(0);
                return 2;
            } else if (game.getData().getData_level() == GameData.levels.LEVEL2) {
                game.getData().setData_level(GameData.levels.LEVEL3);
                game.setBoard(factory.createBoard(Game.boards.SMALL));
                return 3;
            } else if (game.getData().getData_level() == GameData.levels.LEVEL3) {
                return 4;
            }
        } else if (game.getData().getData_point() > 50 && game.getBoard().getNumberOfGhosts() == 6) {
            if (game.getData().getData_level() == GameData.levels.LEVEL1) {
                game.getData().setData_level(GameData.levels.LEVEL2);
                game.getData().setData_point(0);
                return 2;
            } else if (game.getData().getData_level() == GameData.levels.LEVEL2) {
                game.getData().setData_level(GameData.levels.LEVEL3);
                game.getData().setData_point(0);
                return 3;
            } else if (game.getData().getData_level() == GameData.levels.LEVEL3) {
                return 4;
            }
        } else if (game.getData().getData_point() > 80 && game.getBoard().getNumberOfGhosts() == 10) {
            if (game.getData().getData_level() == GameData.levels.LEVEL1) {
                game.getData().setData_level(GameData.levels.LEVEL2);
                game.getData().setData_point(0);
                return 2;
            } else if (game.getData().getData_level() == GameData.levels.LEVEL2) {
                game.getData().setData_level(GameData.levels.LEVEL3);
                game.getData().setData_point(0);
                return 3;
            } else if (game.getData().getData_level() == GameData.levels.LEVEL3) {
                return 4;
            }
        }
        return 0;
    }

    KeyAdapter SelectionAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int keyCode = e.getKeyCode();
            try {
                if (keyCode == KeyEvent.VK_S) {
                    state = stateHandler.changeState(game, "PLAY");
                    game.setBoard(factory.createBoard(Game.boards.SMALL));
                } else if (keyCode == KeyEvent.VK_M) {
                    state = stateHandler.changeState(game, "PLAY");
                    game.setBoard(factory.createBoard(Game.boards.MEDIUM));
                } else if (keyCode == KeyEvent.VK_L) {
                    state = stateHandler.changeState(game, "PLAY");
                    game.setBoard(factory.createBoard(Game.boards.LARGE));
                }
                creater(game);
            } catch (Exception ex) {
                System.out.println("Invalid Input Detected");
            }
        }
    };

    KeyAdapter PlayAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int keyCode = e.getKeyCode();
            key.move(keyCode, game);
        }
    };

    KeyAdapter GameOverAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_ESCAPE) {
                state = stateHandler.changeState(game, "SELECTION");
            }
        }
    };

    KeyAdapter SuccessAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
        }
    };

    public void creater(Game game) {
        char[][] map = game.getBoard().getStructure();
        map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = 'p';
        game.initializeGhosts(game.getBoard().getNumberOfGhosts());
        for (int i = 0; i < game.getBoard().getNumberOfGhosts(); i++) {
            int pos[] = gh.placeRandom(game);
            game.addGhost(i, pos[0], pos[1]);
            map[game.getGhosts()[i].getCoordinateX()][game.getGhosts()[i].getCoordinateY()] = 'g';
        }
        game.initializeFruits(game.getBoard().getNumberOfFruits());
        for (int i = 0; i < game.getBoard().getNumberOfFruits(); i++) {
            int pos[] = gh.placeRandom(game);
            game.addFruit(i, pos[0], pos[1]);
            //First fruit is speed, second is immortality and so on
            if (i % 2 == 0) {
                map[game.getFruits()[i].getCoordinateX()][game.getFruits()[i].getCoordinateY()] = 's';

            } else {
                map[game.getFruits()[i].getCoordinateX()][game.getFruits()[i].getCoordinateY()] = 'i';

            }
        }
    }

    // This method is automatically generated when implementing Actionlistener
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}


