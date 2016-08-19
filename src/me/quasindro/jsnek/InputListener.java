package me.quasindro.jsnek;

import me.quasindro.jsnek.objects.Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputListener extends KeyAdapter {

    private Window window;
    private boolean pressed = false;

    public InputListener(Window window) {
        this.window = window;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (window.getState() == GameState.STOP) {
            return;
        }
        if (window.getState() == GameState.MENU) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT: {
                    window.getMenu().previousChoice();
                    break;
                }
                case KeyEvent.VK_RIGHT: {
                    window.getMenu().nextChoice();
                    break;
                }
                case KeyEvent.VK_ENTER: {
                    window.startGame(window.getMenu().getChoice());
                    break;
                }
                default: // do nothing
            }
            return;
        }
        Snake snake = window.getSnake();
        Direction lastMovement = window.getGameRunnable().getLastMovement();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: {
                if (lastMovement != Direction.DOWN) {
                    snake.setDirection(Direction.UP);
                }
                break;
            }
            case KeyEvent.VK_DOWN: {
                if (lastMovement != Direction.UP) {
                    snake.setDirection(Direction.DOWN);
                }
                break;
            }
            case KeyEvent.VK_LEFT: {
                if (lastMovement != Direction.RIGHT) {
                    snake.setDirection(Direction.LEFT);
                }
                break;
            }
            case KeyEvent.VK_RIGHT: {
                if (lastMovement != Direction.LEFT) {
                    snake.setDirection(Direction.RIGHT);
                }
                break;
            }
            default: // do nothing
        }
        Thread gameThread = window.getGameRunnable().getThread();
        if (!gameThread.isInterrupted() && !window.getGameRunnable().isSpedUp()) {
            gameThread.interrupt();
            window.getGameRunnable().speedUp();
        }
        pressed = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (window.getState() == GameState.STOP || window.getState() == GameState.MENU) {
            return;
        }
        if (pressed) {
            window.getGameRunnable().slowDown();
            pressed = false;
        }
    }
}
