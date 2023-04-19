package me.tud.smylang.lang;

public class Grid {

    private final int[][] grid;
    private final int columnLength, rowLength;

    public Grid(int columnLength, int rowLength) {
        this.grid = new int[columnLength][rowLength];
        this.columnLength = columnLength;
        this.rowLength = rowLength;
    }

    public int getValue(Pointer pointer) {
        return getValue(pointer.getX(), pointer.getY());
    }

    public int getValue(int column, int row) {
        column = wrapAround(columnLength, column);
        row = wrapAround(rowLength, row);
        System.out.println(column);
        System.out.println(row);
        return grid[column][row];
    }

    public void setValue(Pointer pointer, int value) {
        setValue(pointer.getX(), pointer.getY(), value);
    }

    public void setValue(int column, int row, int value) {
        column = wrapAround(columnLength, column);
        row = wrapAround(rowLength, row);
        grid[column][row] = value;
    }

    public int getColumnLength() {
        return columnLength;
    }

    public int getRowLength() {
        return rowLength;
    }

    private static int wrapAround(int around, int n) {
        return n >= 0 ? n % around : around + n;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Grid{");
        sb.append("columnLength=").append(columnLength);
        sb.append(", rowLength=").append(rowLength);
        sb.append('}');
        return sb.toString();
    }

}
