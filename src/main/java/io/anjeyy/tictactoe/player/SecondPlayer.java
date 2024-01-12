package io.anjeyy.tictactoe.player;

import io.anjeyy.tictactoe.Coordinate;

import java.util.Optional;

class SecondPlayer implements Player {

    private static final String ICON = "O";
    private Coordinate nextDrawing = null;

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
    public void decideNextDrawing(int row, int column) {
        nextDrawing = Coordinate.from(row, column);
    }

    @Override
    public Optional<Coordinate> drawingDecision() {
        return Optional.ofNullable(nextDrawing);
    }
}
