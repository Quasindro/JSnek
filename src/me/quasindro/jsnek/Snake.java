package me.quasindro.jsnek;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {

    private Direction direction;
    private Deque<SnakeSegment> segments;

    public Snake() {
        direction = Direction.RIGHT;
        segments = new ArrayDeque<>();
        segments.add(new SnakeSegment(new Point(60, 60)));
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
        segments.addLast(new SnakeSegment(point));
    }

    public SnakeSegment getFirstSegment() {
        return segments.getFirst();
    }
}
