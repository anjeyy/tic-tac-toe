package io.anjeyy.tictactoe;

public class FirstPlayer {

    private final String icon;

    private FirstPlayer(String icon) {
        this.icon = icon;
    }

    public static FirstPlayer createFirst() {
        return new FirstPlayer("X");
    }

    public static FirstPlayer createSecond() {
        return new FirstPlayer("O");
    }

    public String icon() {
        return icon;
    }
}
