package me.quasindro.jsnek.objects;

import me.quasindro.jsnek.Window;

import java.awt.*;

public class BadApple extends Apple {
    public BadApple(Window window) {
        super(window);
        getJPanel().setBackground(Color.BLUE);
    }
}
