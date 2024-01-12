package io.anjeyy.tictactoe;

public class FirstPlayer {

    private final String icon;

    private FirstPlayer(String icon) {
        this.icon = icon;
    }

    public static FirstPlayer create() {
        return new FirstPlayer("X");
    }

    public String icon() {
        return icon;
    }
}
