package me.tud.smylang.lang;

public class Universe {

    private final Grid grid;
    private final Pointer pointer;
    private Direction direction;
    private int memory;

    public Universe(int columnLength, int rowLength) {
        this(new Grid(columnLength, rowLength));
    }

    public Universe(Grid grid) {
        this.grid = grid;
        this.pointer = new Pointer();
        this.direction = Direction.RIGHT;
        this.memory = 0;
    }

    public void face(Direction direction) {
        this.direction = direction;
    }

    public void move() {
        pointer.move(direction);
    }

    public void move(int amount) {
        pointer.move(direction, amount);
    }

    public void printAsInt() {
        System.out.println(getCurrentCell());
    }

    public void printAsChar() {
        System.out.println((char) getCurrentCell());
    }

    public void memorize() {
        memory = getCurrentCell();
    }

    public void putMemory() {
        setCurrentCell(memory);
        memory = 0;
    }

    public int getCurrentCell() {
        return grid.getValue(pointer);
    }

    public void setCurrentCell(int value) {
        grid.setValue(pointer, value);
    }

}
