package me.quasindro.jsnek.menu;

import javax.swing.*;
import java.awt.*;

public class LowButton extends MenuButton {

    public LowButton(JPanel parent, Point point) {
        super(parent, point);
    }

    @Override
    public void choose() {

    }

    @Override
    public void createLetter() {
        JPanel vert = new JPanel(null);
        vert.setLocation(20, 20);
        vert.setSize(10, 100);
        vert.setBackground(Color.WHITE);
        getPanel().add(vert);

        JPanel hor = new JPanel(null);
        hor.setLocation(20, 110);
        hor.setSize(60, 10);
        hor.setBackground(Color.WHITE);
        getPanel().add(hor);
    }
}
