package io.anjeyy.tictactoe.player;

public class PlayerFactory {

    private PlayerFactory() {
        throw new UnsupportedOperationException("No instance allowed.");
    }

    public static Player createFirstPlayer() {
        return FirstPlayer.create();
    }
}
