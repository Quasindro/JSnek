package me.quasindro.jsnek.menu;

import me.quasindro.jsnek.PixelComponent;

import java.awt.*;

public class LowButton extends MenuButton {

    public LowButton(Menu menu, Point point) {
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
                new Point(PixelComponent.PIXEL_SIZE, PixelComponent.PIXEL_SIZE * 6 + (PixelComponent.PIXEL_SIZE/2)),
                PixelComponent.PIXEL_SIZE * 3,
                PixelComponent.PIXEL_SIZE / 2
        );
    }
}
