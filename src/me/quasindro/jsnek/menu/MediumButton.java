package me.quasindro.jsnek.menu;

import javax.swing.*;
import java.awt.*;

public class MediumButton extends MenuButton {

    public MediumButton(JPanel parent, Point point) {
        super(parent, point);
    }

    @Override
    public void choose() {

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

        JPanel pix1 = new JPanel(null);
        pix1.setLocation(30, 30);
        pix1.setSize(10, 10);
        pix1.setBackground(Color.WHITE);
        getPanel().add(pix1);

        JPanel pix2 = new JPanel(null);
        pix2.setLocation(60, 30);
        pix2.setSize(10, 10);
        pix2.setBackground(Color.WHITE);
        getPanel().add(pix2);

        JPanel pix3 = new JPanel(null);
        pix3.setLocation(40, 40);
        pix3.setSize(20, 10);
        pix3.setBackground(Color.WHITE);
        getPanel().add(pix3);
    }
}
