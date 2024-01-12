package io.anjeyy.tictactoe;

public class SecondPlayer implements Player {

    private final String icon;

    private SecondPlayer(String icon) {
        this.icon = icon;
    }

    public static SecondPlayer create() {
        return new SecondPlayer("O");
    }

    @Override
    public String icon() {
        return icon;
    }
}
