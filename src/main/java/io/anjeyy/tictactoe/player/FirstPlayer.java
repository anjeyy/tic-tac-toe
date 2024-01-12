package io.anjeyy.tictactoe.player;

class FirstPlayer implements Player {

    private final String icon = "X";

    private FirstPlayer() {
    }

    static FirstPlayer create() {
        return new FirstPlayer();
    }

    @Override
    public String icon() {
        return icon;
    }
}
