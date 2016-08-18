package me.quasindro.jsnek;

import javax.swing.*;

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
                System.out.println("thread set: " + Thread.currentThread());
            }
            try {
                Thread.sleep(tick);
                moveSnake();
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
}
