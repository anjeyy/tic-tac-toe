package io.anjeyy.tictactoe;

import io.anjeyy.tictactoe.player.Player;

public class Game {

    private final String[][] board = new String[3][3];

    private Game() {
    }
 
    public static Game start() {
        return new Game();
    }

    public String[][] showBoard() {
        return board;
    }

    public boolean isGameOver() {
        String[] firstRow = board[0];
        String firstRowCell = firstRow[0];
        if (firstRowCell == null) {
            return false;
        }
        for (String cell : firstRow) {
            if (!cell.equals(firstRowCell)) {
                return false;
            }
        }
        return true;
    }

    public void draw(Player player) {
        Coordinate coordinate = player.drawingDecision().orElseThrow(() -> new IllegalStateException("Player needs to make a decision where to draw."));
        int row = coordinate.row();
        int column = coordinate.column();

        board[row - 1][column - 1] = player.icon();
    }
}
