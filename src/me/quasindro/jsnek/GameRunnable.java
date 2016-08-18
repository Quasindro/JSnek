package me.quasindro.jsnek;

import javax.swing.*;
import java.awt.*;

public class GameRunnable implements Runnable {

    public static final int DEFAULT_TICK = 500;

    private Window window;
    private int[] bounds;
    private int tick;
    private Direction lastMovement;
    private Thread thread;
    private boolean isSpedUp;

    public GameRunnable(Window window) {
        this.window = window;
        bounds = new int[]{0, 0, 300, 300};
        tick = DEFAULT_TICK;
        lastMovement = window.getSnake().getDirection();
    }

    @Override
    public void run() {

        while (true) {
            if (thread == null) {
                thread = Thread.currentThread();
            }
            try {
                Thread.sleep(tick);
                moveSnake();
                checkCollision();
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
        tick = DEFAULT_TICK/2;
        isSpedUp = true;
    }

    public void slowDown() {
        tick = DEFAULT_TICK;
        isSpedUp = false;
    }

    public boolean isSpedUp() {
        return isSpedUp;
    }

    private void moveSnake() {
        Snake snake = window.getSnake();
        JPanel firstJPanel = snake.getFirstSegment().getJPanel();
        switch (snake.getDirection()) {
            case UP: {
                firstJPanel.setLocation(firstJPanel.getLocation().x, firstJPanel.getLocation().y - PixelComponent.PIXEL_SIZE);
                break;
            }
            case DOWN: {
                firstJPanel.setLocation(firstJPanel.getLocation().x, firstJPanel.getLocation().y + PixelComponent.PIXEL_SIZE);
                break;
            }
            case LEFT: {
                firstJPanel.setLocation(firstJPanel.getLocation().x - PixelComponent.PIXEL_SIZE, firstJPanel.getLocation().y);
                break;
            }
            case RIGHT: {
                firstJPanel.setLocation(firstJPanel.getLocation().x + PixelComponent.PIXEL_SIZE, firstJPanel.getLocation().y);
                break;
            }
            default: // do nothing
        }
        lastMovement = snake.getDirection();
    }

    private void checkCollision() {
        Snake snake = window.getSnake();
        Apple apple = window.getApple();

        Point snakeLoc = snake.getFirstSegment().getJPanel().getLocation();
        if (snakeLoc.equals(apple.getJPanel().getLocation())) {
            System.out.println("collision");
            apple.setRandomLocation();
            return;
        }

        if (snakeLoc.getX() < bounds[0] ||
                snakeLoc.getY() < bounds[1] ||
                snakeLoc.getX() >= bounds[2] ||
                snakeLoc.getY() >= bounds[3]) {
            System.exit(0);
        }

        // todo game over when own segment gets bitten, add a segment when eating an apple
    }
}
