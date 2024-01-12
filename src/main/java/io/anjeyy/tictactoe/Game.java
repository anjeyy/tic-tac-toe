package io.anjeyy.tictactoe;

public class Game {

    private final String[] firstRow = new String[3];
    private final String[] secondRow = new String[3];
    private final String[] thirdRow = new String[3];

    private Game() {
    }

    public static Game start() {
        return new Game();
    }

    public String[][] showBoard() {
        return new String[][] { firstRow, secondRow, thirdRow };
    }

    public boolean isGameOver() {
        return false;
    }
}
