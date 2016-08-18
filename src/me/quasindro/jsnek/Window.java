package me.quasindro.jsnek;

import javax.swing.*;
import java.awt.*;

public class Window {

    private int x;
    private int y;
    private JPanel background;
    private Snake snake;
    private Apple apple;
    private GameRunnable gameRunnable;

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

        snake = new Snake(this);

        //snake.setLocation((x/2)-(snake.getCenter().x), ((y-25)/2)-(snake.getCenter().y));
        //background.add(snake);

        apple = new Apple();
        background.add(apple.getJPanel());

        gameRunnable = new GameRunnable(this);
        new Thread(gameRunnable).start();

        frame.addKeyListener(new InputListener(this));
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
}