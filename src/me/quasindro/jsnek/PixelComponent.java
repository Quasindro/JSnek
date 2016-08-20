package me.quasindro.jsnek;

import javax.swing.*;
import java.awt.*;

public abstract class PixelComponent {

    public static final int PIXEL_SIZE = Window.resolution / 16;

    private JPanel jPanel;

    public PixelComponent() {
        jPanel = new JPanel();
        jPanel.setSize(PIXEL_SIZE, PIXEL_SIZE);
    }

    public JPanel getJPanel() {
        return jPanel;
    }

    protected Point getCenter() {
        return new Point(jPanel.getWidth()/2, jPanel.getHeight()/2);
    }

}
