package io.anjeyy.tictactoe;

public class FirstPlayer implements Player {

    private final String icon = "X";

    private FirstPlayer() {
    }

    public static FirstPlayer create() {
        return new FirstPlayer();
    }

    @Override
    public String icon() {
        return icon;
    }
}
