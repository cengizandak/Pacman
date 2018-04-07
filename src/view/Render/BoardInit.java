package view.Render;


import controller.*;
import controller.adapter.*;
import model.Board;
import model.GameData;
import model.Ghost;

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
    private Timer timer = new Timer(120, this);
    private boolean selectionAdapterFlag = true;
    private boolean playAdapterFlag = true;
    private boolean gameOverAdapterFlag = true;
    private Key key = new Key();
    private StateHandler stateHandler = new StateHandler();
    private GhostHandler gh = new GhostHandler();

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
        System.out.println(game.getData().getData_state());
        Graphics2D g2d = (Graphics2D) g;
        // =====SELECTION STATE=====
        if (game.getData().getData_state().toString().equals("SELECTION")) {
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
            drawCountSCore(g2d);
            game.detectGhostTool(game);
            state.showDisplay(g2d, game);
            gh.ConstantMoving(game);
            game.detectGhostTool(game);
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
    public void drawCountSCore(Graphics2D g2d) {
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

    KeyAdapter SelectionAdapter = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int keyCode = e.getKeyCode();
            try {
//                handler.SelectBoard(key, game, state);
                BoardFactory factory = BoardFactory.getBoardFactory();
                if (keyCode == KeyEvent.VK_S) {
                    state = stateHandler.changeState(game, "PLAY");
                    Board small = factory.createBoard(GameData.boards.SMALL);
                    game.setBoard(small);
                } else if (keyCode == KeyEvent.VK_M) {
                    state = stateHandler.changeState(game, "PLAY");
                    Board medium = factory.createBoard(GameData.boards.MEDIUM);
                    game.setBoard(medium);
                } else if (keyCode == KeyEvent.VK_L) {
                    state = stateHandler.changeState(game, "PLAY");
                    Board large = factory.createBoard(GameData.boards.LARGE);
                    game.setBoard(large);
                }

                char[][] map = game.getBoard().getStructure();
                map[game.getPacman().getCoordinateX()][game.getPacman().getCoordinateY()] = 'p';
                Ghost ghosts[] = new Ghost[game.getBoard().getNumberOfGhosts()];
                for (int i = 0; i < ghosts.length; i++) {
                    GhostHandler gc = new GhostHandler();
                    int pos[] = gc.PlaceRandom(game);
                    ghosts[i] = new Ghost(pos[0], pos[1], Ghost.State.ALIVE);
                    map[ghosts[i].getCoordinateX()][ghosts[i].getCoordinateY()] = 'g';
                }
                game.setGhosts(ghosts);
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

    // This method is automatically generated when implementing Actionlistener
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}


