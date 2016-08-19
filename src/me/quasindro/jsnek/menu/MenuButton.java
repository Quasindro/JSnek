package me.quasindro.jsnek.menu;

import javax.swing.*;
import java.awt.*;

public abstract class MenuButton {

    private JPanel panel;

    public MenuButton(JPanel parent, Point location) {
        this(parent);
        panel.setLocation(location);
        createLetter();
    }

    public MenuButton(JPanel parent) {
        this();
        parent.add(panel);
    }

    public MenuButton() {
        panel = new JPanel(null);
        panel.setSize(100, 300);
        lowlight();
    }

    public void highlight() {
        panel.setBackground(new Color(10, 80, 20));
    }

    public void lowlight() {
        panel.setBackground(new Color(27, 125, 62));
    }

    public JPanel getPanel() {
        return panel;
    }

    public abstract void choose();

    protected abstract void createLetter();
}
