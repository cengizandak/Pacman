package view.Render;

import controller.*;
import controller.adapter.*;


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
            removeMouseListener(playMouseAdapter);
            removeMouseWheelListener(playWheelListener);
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
                addMouseListener(playMouseAdapter);
                addMouseWheelListener(playWheelListener);
                playAdapterFlag = false;
            }
            drawCountSCore(g2d, game);
            if (levelflag == CalcScore(game)) {
                if (levelflag == 4) {
                    removeKeyListener(SelectionAdapter);
                    removeKeyListener(PlayAdapter);
                    removeMouseListener(playMouseAdapter);
                    removeMouseWheelListener(playWheelListener);
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
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!");
                creater(game);
                levelflag++;
                // gc.ConstantMoving(game);
            }
            game.detectGhostTool(game);
            game.detectFruitTool(game);
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
            game.detectFruitTool(game);
            if (game.getPacman().getLives() <= 0) {
                state = stateHandler.changeState(game, "GAMEOVER");
            }
        } else if (game.getData().getData_state().toString().equals("GAMEOVER")) {
            // ===== GAMEOVER=====
            removeKeyListener(SelectionAdapter);
            removeKeyListener(PlayAdapter);
            removeMouseListener(playMouseAdapter);
            removeMouseWheelListener(playWheelListener);
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

    //this is wrong. we have to find a way to use this without gamedata (importing the model) and also this
//this is supposed to be a strategy pattern which is not implemented correctly.
    public int CalcScore(Game game) {
        if (game.getData().getData_point() > 30 && game.getBoard().getNumberOfGhosts() == 2) {
            if (game.getData().getData_level().toString().equals("LEVEL1")) {
                game.getData().setData_level(game.getData().getData_level().LEVEL2);
                  //game.setBoard(factory.createBoard(Game.boards.SMALL));
                game.getData().setData_point(0);
                return 2;
            } else if (game.getData().getData_level().toString().equals("LEVEL2")) {
                game.getData().setData_level(game.getData().getData_level().LEVEL3);
                //game.setBoard(factory.createBoard(Game.boards.SMALL));
                return 3;
            } else if (game.getData().getData_level().toString().equals("LEVEL3")) {
                return 4;
            }
        } else if (game.getData().getData_point() > 50 && game.getBoard().getNumberOfGhosts() == 6) {
            if (game.getData().getData_level().toString().equals("LEVEL1")) {
                game.getData().setData_level(game.getData().getData_level().LEVEL2);
                //game.setBoard(factory.createBoard(Game.boards.MEDIUM));
                game.getData().setData_point(0);
                return 2;
            } else if (game.getData().getData_level().toString().equals("LEVEL2")) {
                game.getData().setData_level(game.getData().getData_level().LEVEL3);
                //game.setBoard(factory.createBoard(Game.boards.MEDIUM));
                game.getData().setData_point(0);
                return 3;
            } else if (game.getData().getData_level().toString().equals("LEVEL3")) {
                return 4;
            }
        } else if (game.getData().getData_point() > 80 && game.getBoard().getNumberOfGhosts() == 10) {
            if (game.getData().getData_level().toString().equals("LEVEL1")) {
                game.getData().setData_level(game.getData().getData_level().LEVEL2);
                //game.setBoard(factory.createBoard(Game.boards.LARGE));
                game.getData().setData_point(0);
                return 2;
            } else if (game.getData().getData_level().toString().equals("LEVEL2")) {
                game.getData().setData_level(game.getData().getData_level().LEVEL3);
                //game.setBoard(factory.createBoard(Game.boards.LARGE));
                game.getData().setData_point(0);
                return 3;
            } else if (game.getData().getData_level().toString().equals("LEVEL3")) {
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
                levelflag=2;
            } catch (Exception ex) {
                System.out.println("Invalid Input Detected");
            }
        }
    };
    int keyCode;
    KeyAdapter PlayAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            keyCode = e.getKeyCode();
            key.move(keyCode, game);
        }
    };

    MouseAdapter playMouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            keyCode = e.getButton();
            key.move(keyCode, game);
        }
    };

    MouseWheelListener playWheelListener = new MouseWheelListener() {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if (e.getWheelRotation() < 0) {
                System.out.println("Up... " + e.getWheelRotation());
                key.move(-1000, game);
            } else {
                System.out.println("Down... " + e.getWheelRotation());
                key.move(1000, game);
            }
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
        System.out.println("crrrrrrrr");
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
            //First fruit is combo, second is score, third is speed, fourth is immortality and so on
            if (i % 4 == 0) {
                map[game.getFruitFunctionalities()[i].getFruit().getCoordinateX()][game.getFruitFunctionalities()[i].getFruit().getCoordinateY()] = 'c';

            } else if (i % 4 == 1) {
                map[game.getFruitFunctionalities()[i].getFruit().getCoordinateX()][game.getFruitFunctionalities()[i].getFruit().getCoordinateY()] = 'o';

            } else if (i % 4 == 2) {
                map[game.getFruitFunctionalities()[i].getFruit().getCoordinateX()][game.getFruitFunctionalities()[i].getFruit().getCoordinateY()] = 's';

            } else{
                map[game.getFruitFunctionalities()[i].getFruit().getCoordinateX()][game.getFruitFunctionalities()[i].getFruit().getCoordinateY()] = 'i';
            }
        }
    }

    // This method is automatically generated when implementing Actionlistener
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}


