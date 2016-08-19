package me.quasindro.jsnek;

import java.awt.*;
import java.util.Random;

public class Apple extends PixelComponent {

    private Window window;

    public Apple(Window window) {
        this.window = window;
        getJPanel().setSize(PIXEL_SIZE, PIXEL_SIZE);
        getJPanel().setBackground(new Color(155, 33, 66));
        setRandomLocation();
    }

    public void setRandomLocation() {
        Random random = new Random();
        Point point = new Point(random.nextInt(281/20)*20, random.nextInt(281/20)*20);
        for (SnakeSegment segment : window.getSnake().getSegments()) {
            if (segment.getJPanel().getLocation().equals(point)) {
                setRandomLocation();
                return;
            }
        }
        getJPanel().setLocation(point);
    }
}
