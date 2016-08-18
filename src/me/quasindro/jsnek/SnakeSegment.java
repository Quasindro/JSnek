package me.quasindro.jsnek;

import java.awt.*;

public class SnakeSegment extends PixelComponent {

    public SnakeSegment(Point point) {
        getJPanel().setLocation(point);
        getJPanel().setBackground(new Color(55,55,55));
    }
}
