package me.quasindro.jsnek.objects;

import me.quasindro.jsnek.PixelComponent;

import java.awt.*;

public class SnakeSegment extends PixelComponent {

    public SnakeSegment() {
        getJPanel().setBackground(new Color(55,55,55));
    }

    public SnakeSegment(Point point) {
        this();
        getJPanel().setLocation(point);
    }
}
