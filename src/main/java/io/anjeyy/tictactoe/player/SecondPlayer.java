package io.anjeyy.tictactoe.player;

class SecondPlayer extends AbstractPlayer {

    private static final String ICON = "O";

    private SecondPlayer() {
    }

    static SecondPlayer create() {
        return new SecondPlayer();
    }

    @Override
    public String icon() {
        return ICON;
    }
}
