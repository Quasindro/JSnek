package me.quasindro.jsnek.menu;

import javax.swing.*;
import java.awt.*;

public class Menu {

    private int choice;
    private JPanel holder;
    private MenuButton[] buttons;

    public Menu(JPanel parent) {
        holder = new JPanel(null);
        holder.setBackground(new Color(0,0,0,0));
        holder.setLocation(0, 80);
        holder.setSize(300, 140);
        parent.add(holder);
        buttons = new MenuButton[] {
            new LowButton(holder, new Point(0, 0)),
                new MediumButton(holder, new Point(100, 0)),
                new HardButton(holder, new Point(200, 0))
        };
        choice = 1;
        buttons[choice].highlight();
    }

    public JPanel getJPanel() {
        return holder;
    }

    public int getChoice() {
        return choice;
    }

    public void previousChoice() {
        lowlight();
        choice = choice != 0 ? --choice : 2;
        highlight();
    }

    public void nextChoice() {
        lowlight();
        choice = choice != 2 ? ++choice : 0;
        highlight();
    }

    private void highlight() {
        buttons[choice].highlight();
    }

    private void lowlight() {
        buttons[choice].lowlight();
    }
}
