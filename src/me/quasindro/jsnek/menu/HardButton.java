package me.quasindro.jsnek.menu;

import me.quasindro.jsnek.PixelComponent;

import java.awt.*;

public class HardButton extends MenuButton {

    public HardButton(Menu menu, Point location) {
        super(menu, location);
    }

    @Override
    public void createLetter() {

        createLetterPanel(
                new Point(PixelComponent.PIXEL_SIZE, PixelComponent.PIXEL_SIZE),
                PixelComponent.PIXEL_SIZE / 2,
                PixelComponent.PIXEL_SIZE * 6
        );

        createLetterPanel(
                new Point((PixelComponent.PIXEL_SIZE / 4) * 15, PixelComponent.PIXEL_SIZE),
                PixelComponent.PIXEL_SIZE / 2,
                PixelComponent.PIXEL_SIZE * 6
        );

        createLetterPanel(
                new Point(PixelComponent.PIXEL_SIZE / 2 * 3, PixelComponent.PIXEL_SIZE * 4),
                PixelComponent.PIXEL_SIZE / 2 * 5,
                PixelComponent.PIXEL_SIZE / 2
        );
    }
}
