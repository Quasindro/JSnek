package me.quasindro.jsnek;

import java.awt.*;

public class SnakeSegment extends PixelComponent {

    public SnakeSegment(Point point) { // initial segment I guess
        this();
        getJPanel().setLocation(point);
    }

    public SnakeSegment(Snake snake) {
        this();
    }

    public SnakeSegment() {
        getJPanel().setBackground(new Color(55,55,55)); // make each segment have a different color?
    }
}
