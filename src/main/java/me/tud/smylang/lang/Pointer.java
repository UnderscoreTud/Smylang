package me.tud.smylang.lang;

public class Pointer implements Cloneable {

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
            case UP -> y -= amount;
            case RIGHT -> x += amount;
            case DOWN -> y += amount;
            case LEFT -> x -= amount;
        }
    }

    public Pointer peek(Direction direction) {
        return peek(direction, 1);
    }

    public Pointer peek(Direction direction, int amount) {
        Pointer clone = clone();
        clone.move(direction, amount);
        return clone;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void set(Pointer other) {
        this.x = other.x;
        this.y = other.y;
    }

    @Override
    public Pointer clone() {
        try {
            return (Pointer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pointer{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }

}
