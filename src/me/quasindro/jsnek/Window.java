package me.quasindro.jsnek;

import javax.swing.*;
import java.awt.*;

public class Window {

    private int x;
    private int y;
    private Snake snake;

    public Window() {


        JFrame frame = new JFrame();
        frame.setLayout(null);

        x = 306;
        y = 329; // window itself + the fucking title bar, took me ages to realize

        // setup the window
        frame.setTitle("JSnek");
        frame.setVisible(true);
        frame.setSize(x, y);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // background
        JPanel background = new JPanel(null);
        background.setBackground(new Color(33, 155, 77));
        background.setSize(x, y);
        frame.add(background);


        snake = new Snake();
        for (SnakeSegment segment : snake.getSegments()) {
            background.add(segment.getJPanel());
        }
        //snake.setLocation((x/2)-(snake.getCenter().x), ((y-25)/2)-(snake.getCenter().y));
        //background.add(snake);

        Apple apple = new Apple();
        apple.getJPanel().setLocation(0, 0);
        background.add(apple.getJPanel());

        new Thread(new GameRunnable(this)).start();

        frame.addKeyListener(new InputListener(this));
    }

    public Snake getSnake() {
        return snake;
    }
}