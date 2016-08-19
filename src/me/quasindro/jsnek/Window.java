package me.quasindro.jsnek;

import me.quasindro.jsnek.menu.Menu;
import me.quasindro.jsnek.objects.Apple;
import me.quasindro.jsnek.objects.BadApple;
import me.quasindro.jsnek.objects.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Window {

    private int x;
    private int y;
    private JFrame frame;
    private JPanel background;
    private Snake snake;
    private Apple apple;
    private GameRunnable gameRunnable;
    private GameState state;
    private Menu menu;
    private InputListener listener;
    private Set<Point> locationsTaken;
    private Set<BadApple> badApples;

    public Window() {

        frame = new JFrame();
        frame.setLayout(null);

        x = 300;
        y = 300;

        // setup the window
        frame.setTitle("JSnek");
        frame.setVisible(true);
        frame.setSize(x + 6, y + 29); // bs
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // background
        background = new JPanel(null);
        background.setBackground(new Color(33, 155, 77));
        background.setSize(x, y);
        frame.add(background);

        badApples = new HashSet<>();
        locationsTaken = new HashSet<>();

        state = GameState.MENU;
        menu = new Menu(background);

        listener = new InputListener(this);
        frame.addKeyListener(listener);
    }

    public GameState getState() {
        return state;
    }

    public Menu getMenu() {
        return menu;
    }

    public Snake getSnake() {
        return snake;
    }

    public Apple getApple() {
        return apple;
    }

    public Set<BadApple> getBadApples() {
        return badApples;
    }

    public JPanel getBackground() {
        return background;
    }

    public GameRunnable getGameRunnable() {
        return gameRunnable;
    }

    public void addTakenLocation(Point location) {
        locationsTaken.add(location);
    }

    public void releaseTakenLocation(Point location) {
        locationsTaken.remove(location);
    }

    public boolean isLocationTaken(Point location) {
        return locationsTaken.contains(location);
    }

    public void startGame(int difficulty) {
        state = GameState.STOP;
        background.removeAll();
        menu = null;
        background.revalidate();
        background.repaint();

        snake = new Snake(this);
        apple = new Apple(this);

        int defaultTick = 1000;
        switch (difficulty) {
            case 1: {
                defaultTick = 500;
                badApples.add(new BadApple(this));
                break;
            }
            case 2: {
                defaultTick = 200;
                badApples.add(new BadApple(this));
                badApples.add(new BadApple(this));
                badApples.add(new BadApple(this));
                break;
            }
        }
        gameRunnable = new GameRunnable(this, defaultTick);
        new Thread(gameRunnable).start();
        state = GameState.PLAYING;
    }

    public void endGame() {
        state = GameState.STOP;
        background.removeAll();
        background.revalidate();
        background.repaint();
        badApples.clear();
        state = GameState.MENU;
        menu = new Menu(background);
        background.repaint();
    }
}