package me.quasindro.jsnek;

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
        System.out.println(snake.getDirection());
        pressed = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (pressed) {
            System.out.println("arrow key pressed?");
            pressed = false;
        }
    }
}
