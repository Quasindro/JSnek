package me.quasindro.jsnek;

import java.awt.*;

public class Apple extends PixelComponent {

    public Apple() {
        getJPanel().setSize(PIXEL_SIZE, PIXEL_SIZE);
        getJPanel().setBackground(new Color(155, 33, 66));
    }
}
