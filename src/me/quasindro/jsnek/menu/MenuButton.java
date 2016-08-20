package me.quasindro.jsnek.menu;

import javax.swing.*;
import java.awt.*;

public abstract class MenuButton {

    private JPanel panel;
    private Menu menu;

    public MenuButton(Menu menu, Point location) {
        this.menu = menu;
        panel = new JPanel(null);
        lowlight();
        menu.getJPanel().add(getPanel());
        panel.setSize(menu.getButtonWidth(), menu.getJPanel().getHeight());
        panel.setLocation(location);
        createLetter();
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

    protected abstract void createLetter();

    protected void createLetterPanel(Point location, int width, int height) {
        JPanel letterPanel = new JPanel(null);
        letterPanel.setLocation(location);
        letterPanel.setSize(width, height);
        letterPanel.setBackground(Color.WHITE);
        getPanel().add(letterPanel);
    }
}
