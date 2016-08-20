package me.quasindro.jsnek.listeners;

import me.quasindro.jsnek.GameState;
import me.quasindro.jsnek.Window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FocusListener extends WindowAdapter {

    private Window window;

    public FocusListener(Window window) {
        this.window = window;
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        if (window.getState() == GameState.PLAYING) {
            window.getGameRunnable().setPaused(true);
        }
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        if (window.getState() == GameState.PLAYING) {
            window.getGameRunnable().setPaused(false);
        }
    }
}
