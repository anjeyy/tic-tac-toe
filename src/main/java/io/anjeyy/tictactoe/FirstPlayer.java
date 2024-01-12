package io.anjeyy.tictactoe;

public class FirstPlayer implements Player {

    private final String icon;

    private FirstPlayer(String icon) {
        this.icon = icon;
    }

    public static FirstPlayer create() {
        return new FirstPlayer("X");
    }

    @Override
    public String icon() {
        return icon;
    }
}
