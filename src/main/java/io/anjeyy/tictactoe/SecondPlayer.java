package io.anjeyy.tictactoe;

public class SecondPlayer implements Player {

    private final String icon = "O";

    private SecondPlayer() {
    }

    public static SecondPlayer create() {
        return new SecondPlayer();
    }

    @Override
    public String icon() {
        return icon;
    }
}
