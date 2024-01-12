package io.anjeyy.tictactoe.player;

class FirstPlayer extends AbstractPlayer {

    private static final String ICON = "X";

    private FirstPlayer() {
        super();
    }

    static FirstPlayer create() {
        return new FirstPlayer();
    }

    @Override
    public String icon() {
        return ICON;
    }

}
