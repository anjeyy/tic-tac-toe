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

    @Override
    public String toString() {
        return "Player 2: O";
    }
}
