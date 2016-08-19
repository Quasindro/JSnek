package me.quasindro.jsnek;

import me.quasindro.jsnek.menu.Menu;

import javax.swing.*;
import java.awt.*;

public class Window {

    private int x;
    private int y;
    private JPanel background;
    private Snake snake;
    private Apple apple;
    private GameRunnable gameRunnable;
    private GameState state;
    private Menu menu;

    public Window() {

        JFrame frame = new JFrame();
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

        state = GameState.MENU;
        menu = new Menu(background);

        frame.addKeyListener(new InputListener(this));
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
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

    public JPanel getBackground() {
        return background;
    }

    public GameRunnable getGameRunnable() {
        return gameRunnable;
    }

    public void startGame(int difficulty) {
        menu.getJPanel().removeAll();
        background.remove(menu.getJPanel());
        background.revalidate();
        background.repaint();

        snake = new Snake(this);
        apple = new Apple(this);

        int defaultTick = 1000;
        switch (difficulty) {
            case 1: defaultTick = 500; break;
            case 2: defaultTick = 200; break;
        }
        gameRunnable = new GameRunnable(this, defaultTick);
        new Thread(gameRunnable).start();
    }
}