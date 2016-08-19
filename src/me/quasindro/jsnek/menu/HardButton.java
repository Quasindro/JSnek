package me.quasindro.jsnek.menu;

import javax.swing.*;
import java.awt.*;

public class HardButton extends MenuButton {

    public HardButton(JPanel parent, Point point) {
        super(parent, point);
    }

    @Override
    public void createLetter() {

        JPanel vert1 = new JPanel(null);
        vert1.setLocation(20, 20);
        vert1.setSize(10, 100);
        vert1.setBackground(Color.WHITE);
        getPanel().add(vert1);

        JPanel vert2 = new JPanel(null);
        vert2.setLocation(70, 20);
        vert2.setSize(10, 100);
        vert2.setBackground(Color.WHITE);
        getPanel().add(vert2);

        JPanel hor = new JPanel(null);
        hor.setLocation(30, 70);
        hor.setSize(40, 10);
        hor.setBackground(Color.WHITE);
        getPanel().add(hor);
    }
}
