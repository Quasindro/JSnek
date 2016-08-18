package me.quasindro.jsnek;

import javax.swing.*;

public class GameRunnable implements Runnable {

    private Window window;
    private int[] bounds;
    private int tick;
    private Direction lastMovement;

    public GameRunnable(Window window) {
        this.window = window;
        bounds = new int[]{0, 0, 300, 300};
        tick = 300;
        lastMovement = window.getSnake().getDirection();
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(tick);
                moveSnake();
            } catch (InterruptedException e) {
                // most definitely shouldnt happen
                e.printStackTrace();
            }
        }
    }

    public Direction getLastMovement() {
        return lastMovement;
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
}
