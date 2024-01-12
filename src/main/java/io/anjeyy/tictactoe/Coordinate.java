package io.anjeyy.tictactoe;

public class Coordinate {

    private final int row;
    private final int column;

    private Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static Coordinate from(int row, int column) {
        return new Coordinate(row, column);
    }

    public int row() {
        return row;
    }

    public int column() {
        return column;
    }
}
