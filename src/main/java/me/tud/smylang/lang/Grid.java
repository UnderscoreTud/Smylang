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

    public void visualize() {
        int maxDigits = getMaxDigits();

        String format = " %" + maxDigits + "d";

        for (int j = 0; j < rowLength; j++) {
            printHorizontalLine(maxDigits, columnLength);

            for (int[] ints : grid) {
                System.out.printf(format, ints[j]);
                System.out.print(" \u2502");
            }
            System.out.println();
        }

        printHorizontalLine(maxDigits, columnLength);
    }

    private int getMaxDigits() {
        int maxDigits = 0;
        for (int[] column : grid) {
            for (int num : column) {
                int digits = String.valueOf(num).length();
                if (digits > maxDigits)
                    maxDigits = digits;
            }
        }
        return maxDigits;
    }

    private static void printHorizontalLine(int cellWidth, int columns) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < columns; i++)
            line.append("\u2500".repeat(cellWidth + 1)).append("\u2500\u2502");
        System.out.println(line);
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
