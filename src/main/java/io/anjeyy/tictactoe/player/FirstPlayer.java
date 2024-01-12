package io.anjeyy.tictactoe.player;

class FirstPlayer implements Player {

    private static final String ICON = "X";

    private FirstPlayer() {
    }

    static FirstPlayer create() {
        return new FirstPlayer();
    }

    @Override
    public String icon() {
        return ICON;
    }
}
