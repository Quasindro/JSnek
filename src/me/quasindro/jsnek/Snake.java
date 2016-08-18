package me.quasindro.jsnek;

import java.awt.*;
import java.util.*;

public class Snake {

    private Direction direction;
    private Deque<SnakeSegment> segments;
    private Map<SnakeSegment, Point> locations = new HashMap<>();

    public Snake() {
        direction = Direction.RIGHT;
        segments = new ArrayDeque<>();
        segments.add(new SnakeSegment(new Point(60, 60)));
    }

    public void move() {

        Iterator it = segments.iterator();
        while (it.hasNext()) {
            SnakeSegment segment = (SnakeSegment) it.next();
            if (segments.getFirst().equals(segment)) {
                switch (direction) {

                }
            }
        }
        locations.clear();
    }

    public void eat() {
        // do nothing atm
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

    public void addSegment() {
        segments.addLast(new SnakeSegment(this));
    }

    public SnakeSegment getFirstSegment() {
        return segments.getFirst();
    }

    public SnakeSegment getLastSegment() {
        return segments.getLast();
    }
}
