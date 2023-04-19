package me.tud.smylang.lang;

public class Pointer {

    private int x, y;

    public Pointer() {
        this(0, 0);
    }

    public Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(Direction direction) {
        move(direction, 1);
    }

    public void move(Direction direction, int amount) {
        switch (direction) {
            case UP -> y += amount;
            case RIGHT -> x += amount;
            case DOWN -> y -= amount;
            case LEFT -> x -= amount;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
