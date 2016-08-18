package me.quasindro.jsnek;

import java.awt.*;

public class SnakeSegment extends PixelComponent {

    public SnakeSegment() {
        getJPanel().setBackground(new Color(55,55,55)); // make each segment have a different color?
    }

    public SnakeSegment(Point point) {
        this();
        getJPanel().setLocation(point);
    }
}
