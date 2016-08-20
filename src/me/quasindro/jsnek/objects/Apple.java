package me.quasindro.jsnek.objects;

import me.quasindro.jsnek.PixelComponent;
import me.quasindro.jsnek.Window;

import java.util.Random;

import java.awt.*;

public class Apple extends PixelComponent {

    private Window window;
    private int bound;

    public Apple(Window window) {
        this.window = window;
        getJPanel().setSize(PIXEL_SIZE, PIXEL_SIZE);
        getJPanel().setBackground(new Color(155, 33, 66));
        window.getBackground().add(getJPanel());
        bound = Window.resolution-PIXEL_SIZE+1;
        setRandomLocation();
    }

    //random.nextInt(281/20)*20);

    public void setRandomLocation() {
        Random random = new Random();
        Point point = new Point(random.nextInt(bound/PIXEL_SIZE)*PIXEL_SIZE, random.nextInt(bound/PIXEL_SIZE)*PIXEL_SIZE);
        if (!window.isLocationTaken(point)) {
            getJPanel().setLocation(point);
            window.addTakenLocation(point);
        } else {
            setRandomLocation();
        }
    }
}
