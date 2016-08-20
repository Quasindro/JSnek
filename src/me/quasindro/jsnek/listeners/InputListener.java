package me.quasindro.jsnek.listeners;

import me.quasindro.jsnek.Direction;
import me.quasindro.jsnek.GameState;
import me.quasindro.jsnek.Window;
import me.quasindro.jsnek.objects.Snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputListener extends KeyAdapter {

    private Window window;
    private int presses;
    private boolean pressed;

    public InputListener(Window window) {
        this.window = window;
        presses = 0;
        pressed = false;
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
        presses++;
        Snake snake = window.getSnake();
        Direction lastMovement = window.getGameRunnable().getLastMovement();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP: {
                if (lastMovement != Direction.DOWN && snake.getDirection() != Direction.UP) {
                    snake.setDirection(Direction.UP);
                }
                break;
            }
            case KeyEvent.VK_DOWN: {
                if (lastMovement != Direction.UP && snake.getDirection() != Direction.DOWN) {
                    snake.setDirection(Direction.DOWN);
                }
                break;
            }
            case KeyEvent.VK_LEFT: {
                if (lastMovement != Direction.RIGHT && snake.getDirection() != Direction.LEFT) {
                    snake.setDirection(Direction.LEFT);
                }
                break;
            }
            case KeyEvent.VK_RIGHT: {
                if (lastMovement != Direction.LEFT && snake.getDirection() != Direction.RIGHT) {
                    snake.setDirection(Direction.RIGHT);
                }
                break;
            }
            default: // do nothing
        }
        Thread gameThread = window.getGameRunnable().getThread();
        if (!gameThread.isInterrupted() && !window.getGameRunnable().isSpedUp()) {
            if (presses < 3) {
                return;
            }
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
        presses = 0;
        if (pressed) {
            window.getGameRunnable().slowDown();
            pressed = false;
        }
    }
}
