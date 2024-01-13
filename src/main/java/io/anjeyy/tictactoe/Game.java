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
        for (int row = 0; row < board.length; row++) {
            String firstRowCell = board[row][0];
            if (firstRowCell == null) {
                continue;
            }
            for (int column = 0; column < board[row].length; column++) {
                String currentCell = board[row][column];
                if (!firstRowCell.equals(currentCell)) {
                    break;
                } else if (column == 2) {
                    return true;
                }
            }
        }

        for (int column = 0; column < board[0].length; column++) {
            String firstColumnCell = board[0][column];
            if (firstColumnCell == null) {
                continue;
            }
            for (int row = 0; row < board.length; row++) {
                String currentCell = board[row][column];
                if (!firstColumnCell.equals(currentCell)) {
                    break;
                } else if (row == 2) {
                    return true;
                }
            }
        }

        return false;
    }

    public void draw(Player player) {
        Coordinate coordinate = player.drawingDecision().orElseThrow(() -> new IllegalStateException("Player needs to make a decision where to draw."));
        int row = coordinate.row();
        int column = coordinate.column();

        board[row - 1][column - 1] = player.icon();
    }
}
