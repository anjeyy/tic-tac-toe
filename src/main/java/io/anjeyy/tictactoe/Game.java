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
        return false;
    }

    public void draw(Player player, Coordinate coordinate) {
        int row = coordinate.row();
        int column = coordinate.column();

        board[row - 1][column - 1] = player.icon();
    }
}
