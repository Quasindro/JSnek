package me.quasindro.jsnek.menu;

import me.quasindro.jsnek.PixelComponent;

import java.awt.*;

public class MediumButton extends MenuButton {

    public MediumButton(Menu menu, Point point) {
        super(menu, point);
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
                new Point((PixelComponent.PIXEL_SIZE / 2) * 3, (PixelComponent.PIXEL_SIZE / 2) * 3),
                PixelComponent.PIXEL_SIZE / 2,
                PixelComponent.PIXEL_SIZE / 2
        );

        createLetterPanel(
                new Point(PixelComponent.PIXEL_SIZE / 4 * 13, (PixelComponent.PIXEL_SIZE / 2) * 3),
                PixelComponent.PIXEL_SIZE / 2,
                PixelComponent.PIXEL_SIZE / 2
        );

        createLetterPanel(
                new Point(PixelComponent.PIXEL_SIZE * 2, PixelComponent.PIXEL_SIZE * 2),
                PixelComponent.PIXEL_SIZE / 4 * 5,
                PixelComponent.PIXEL_SIZE / 2
        );
    }
}
