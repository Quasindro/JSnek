package me.quasindro.jsnek;

import java.awt.*;

public class GameRunnable implements Runnable {

    private int defaultTick;

    private Window window;
    private int[] bounds;
    private int tick;
    private Direction lastMovement;
    private Thread thread;
    private boolean isSpedUp;
    private Point nextSegment;

    public GameRunnable(Window window, int defaultTick) {
        this.window = window;
        this.defaultTick = defaultTick;
        bounds = new int[]{0, 0, 300, 300};
        tick = defaultTick;
        lastMovement = window.getSnake().getDirection();
    }

    @Override
    public void run() {

        while (true) {
            if (thread == null) {
                thread = Thread.currentThread();
            }

            moveSnake();
            if (nextSegment != null) {
                window.getSnake().addSegment(nextSegment);
                nextSegment = null;
            }
            checkCollision();
            try {
                Thread.sleep(tick);
            } catch (InterruptedException ignored) {}
        }
    }

    public Direction getLastMovement() {
        return lastMovement;
    }

    public Thread getThread() {
        return thread;
    }

    public void speedUp() {
        tick = defaultTick/2;
        isSpedUp = true;
    }

    public void slowDown() {
        tick = defaultTick;
        isSpedUp = false;
    }

    public boolean isSpedUp() {
        return isSpedUp;
    }

    private void moveSnake() {
        Snake snake = window.getSnake();
        snake.move();
        lastMovement = snake.getDirection();
    }

    private void checkCollision() {
        Snake snake = window.getSnake();
        Apple apple = window.getApple();

        Point snakeLoc = snake.getFirstSegment().getJPanel().getLocation();

        //eat an apple
        if (snakeLoc.equals(apple.getJPanel().getLocation())) {
            apple.setRandomLocation();
            nextSegment = snake.getLastSegment().getJPanel().getLocation();
            return;
        }

        //eat self
        for (SnakeSegment segment : snake.getSegments()) {
            if (snakeLoc.equals(segment.getJPanel().getLocation()) && !segment.getJPanel().equals(snake.getFirstSegment().getJPanel())) {
                System.exit(0);
            }
        }

        //hit wall
        if (snakeLoc.getX() < bounds[0] ||
                snakeLoc.getY() < bounds[1] ||
                snakeLoc.getX() >= bounds[2] ||
                snakeLoc.getY() >= bounds[3]) {
            System.exit(0);
        }

        // todo game over when own segment gets bitten, add a segment when eating an apple
        // when the apple gets eaten the location of the last segment gets saved and that segment in that point will get added on next tick
        // checkmate
    }
}
