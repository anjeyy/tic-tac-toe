package io.anjeyy.tictactoe;

import io.anjeyy.tictactoe.player.Player;

import java.util.Optional;

public class Game {

    private final String[][] board = new String[3][3];
    private Player currentPlayersTurn = null;

    private Game() {
    }

    public static Game start() {
        return new Game();
    }

    public String[][] showBoard() {
        return board;
    }

    public boolean isGameOver() {
        return isRowGameOver() || isColumnGameOver() || isDiagonalGameOver() || isBoardFull();
    }

    private boolean isRowGameOver() {
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
        return false;
    }

    private boolean isColumnGameOver() {
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

    private boolean isDiagonalGameOver() {
        String firstLeftDiagonalCell = board[0][0];
        String firstRightDiagonalCell = board[0][2];
        if (firstLeftDiagonalCell != null) {
            String secondLeftDiagonalCell = board[1][1];
            String thirdLeftDiagonalCell = board[2][2];
            if (firstLeftDiagonalCell.equals(secondLeftDiagonalCell) && firstLeftDiagonalCell.equals(thirdLeftDiagonalCell)) {
                return true;
            }
        }
        if (firstRightDiagonalCell != null) {
            String secondRightDiagonalCell = board[1][1];
            String thirdRightDiagonalCell = board[2][0];
            return firstRightDiagonalCell.equals(secondRightDiagonalCell) && firstRightDiagonalCell.equals(thirdRightDiagonalCell);
        }
        return false;
    }

    private boolean isBoardFull() {
        for (String[] rows : board) {
            for (String currentCell : rows) {
                if (currentCell == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void draw(Player player) {
        if (isGameOver()) {
            throw new IllegalCallerException("Game is over. Create a new game.");
        }

        Coordinate coordinate = player.drawingDecision().orElseThrow(() -> new IllegalStateException("Player needs to make a decision where to draw."));
        int row = coordinate.row().index();
        int column = coordinate.column().index();

        if (board[row][column] != null) {
            throw new IllegalArgumentException("Cell is already marked by a player.");
        }
        board[row][column] = player.icon();
        currentPlayersTurn = player;
    }

    public Optional<Player> winner() {
        if (isGameOver() && !isBoardFull()) {
            return Optional.of(currentPlayersTurn);
        }
        return Optional.empty();
    }
}
