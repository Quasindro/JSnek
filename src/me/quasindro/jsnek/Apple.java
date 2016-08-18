package me.quasindro.jsnek;

import java.awt.*;
import java.util.Random;

public class Apple extends PixelComponent {

    public Apple() {
        getJPanel().setSize(PIXEL_SIZE, PIXEL_SIZE);
        getJPanel().setBackground(new Color(155, 33, 66));
        setRandomLocation();
    }

    public void setRandomLocation() {
        Random random = new Random();
        int randomX = random.nextInt(281/20)*20;
        int randomY = random.nextInt(281/20)*20;
        getJPanel().setLocation(randomX, randomY);
    }
}
