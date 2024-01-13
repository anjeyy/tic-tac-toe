package io.anjeyy.tictactoe;

public class Coordinate {

    private final Row row;
    private final Column column;

    private Coordinate(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    public static Coordinate from(Row row, Column column) {
        return new Coordinate(row, column);
    }

    public Row row() {
        return row;
    }

    public Column column() {
        return column;
    }

    public enum Row {
        _1(0),
        _2(1),
        _3(2);

        private final int index;

        Row(int index) {
            this.index = index;
        }

        public int index() {
            return index;
        }
    }

    public enum Column {
        _1(0),
        _2(1),
        _3(2);

        private final int index;

        Column(int index) {
            this.index = index;
        }

        public int index() {
            return index;
        }
    }
}
