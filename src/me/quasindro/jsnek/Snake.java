package me.quasindro.jsnek;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Snake {

    private Window window;
    private Direction direction;
    private Deque<SnakeSegment> segments;
    private Map<SnakeSegment, Point> locations = new HashMap<>();

    public Snake(Window window) {
        this.window = window;
        direction = Direction.RIGHT;
        segments = new ArrayDeque<>();
        addSegment(new Point(60, 60));
    }

    public void move() {
        for (SnakeSegment segment : segments) {
            locations.put(segment, segment.getJPanel().getLocation());
        }
        Iterator it = segments.iterator();
        SnakeSegment previous = null;
        while (it.hasNext()) {
            SnakeSegment segment = (SnakeSegment) it.next();
            if (segments.getFirst().equals(segment)) {
                previous = segment;
                JPanel firstJPanel = segment.getJPanel();
                switch (direction) {
                    case UP: {
                        firstJPanel.setLocation(firstJPanel.getLocation().x, firstJPanel.getLocation().y - PixelComponent.PIXEL_SIZE);
                        break;
                    }
                    case DOWN: {
                        firstJPanel.setLocation(firstJPanel.getLocation().x, firstJPanel.getLocation().y + PixelComponent.PIXEL_SIZE);
                        break;
                    }
                    case LEFT: {
                        firstJPanel.setLocation(firstJPanel.getLocation().x - PixelComponent.PIXEL_SIZE, firstJPanel.getLocation().y);
                        break;
                    }
                    case RIGHT: {
                        firstJPanel.setLocation(firstJPanel.getLocation().x + PixelComponent.PIXEL_SIZE, firstJPanel.getLocation().y);
                        break;
                    }
                    default: // do nothing
                }
                continue;
            }

            segment.getJPanel().setLocation(locations.get(previous));
            previous = segment;
        }
        locations.clear();
    }

    public void eat() {
        colorSnake();
    }

    public Direction getDirection() {
        return direction;
    }

    public Direction setDirection(Direction direction) {
        return this.direction = direction;
    }

    public Deque<SnakeSegment> getSegments() {
        return segments;
    }

    public void addSegment(Point point) {
        SnakeSegment segment = new SnakeSegment(point);
        segments.addLast(segment);
        window.getBackground().add(segment.getJPanel());
    }

    public SnakeSegment getFirstSegment() {
        return segments.getFirst();
    }

    public SnakeSegment getLastSegment() {
        return segments.getLast();
    }

    public void colorSnake() {
        int center = 128;
        int width = 127;
        double frequency = Math.PI*2/segments.size();

        Iterator it = segments.iterator();
        int i = 1;
        while (it.hasNext()) {
            SnakeSegment segment = (SnakeSegment) it.next();
            int red   = (int) Math.round(Math.sin(frequency*i+2) * width + center);
            int green = (int) Math.round(Math.sin(frequency*i+0) * width + center);
            int blue  = (int) Math.round(Math.sin(frequency*i+4) * width + center);
            segment.getJPanel().setBackground(new Color(red, green, blue));
            i++;
        }
    }
}
