package me.quasindro.jsnek.menu;

import me.quasindro.jsnek.Window;

import javax.swing.*;
import java.awt.*;

public class Menu {

    private int choice;
    private JPanel holder;
    private MenuButton[] buttons;
    private int buttonWidth;
    private int spacing;

    public Menu(JPanel parent) {
        holder = new JPanel(null);
        holder.setBackground(new Color(0,0,0,0));
        holder.setLocation(0, Window.resolution/4);
        holder.setSize(Window.resolution, Window.resolution/2);
        parent.add(holder);
        calculateButtonWidthAndSpacing();
        buttons = new MenuButton[] {
            new LowButton(this, new Point(0, 0)),
                new MediumButton(this, new Point(buttonWidth + spacing, 0)),
                new HardButton(this, new Point((buttonWidth * 2) + (spacing * 2), 0))
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

    public int getButtonWidth() {
        return buttonWidth;
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

    private void calculateButtonWidthAndSpacing() {
        int pow = (int)(Math.log(Window.resolution)/Math.log(2));
        if (pow % 2 == 0) {
            buttonWidth = (Window.resolution/3)-1;
        } else {
            buttonWidth = Window.resolution/3;
        }
        spacing = (Window.resolution-(buttonWidth*3))/2;
    }

    private void highlight() {
        buttons[choice].highlight();
    }

    private void lowlight() {
        buttons[choice].lowlight();
    }
}
