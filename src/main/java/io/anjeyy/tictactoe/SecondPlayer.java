package io.anjeyy.tictactoe;

public class SecondPlayer {

    private final String icon;

    private SecondPlayer(String icon) {
        this.icon = icon;
    }

    public static SecondPlayer create() {
        return new SecondPlayer("O");
    }

    public String icon() {
        return icon;
    }
}
