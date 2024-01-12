package io.anjeyy.tictactoe.player;

import io.anjeyy.tictactoe.Coordinate;

import java.util.Optional;

abstract class AbstractPlayer implements Player {

    protected Coordinate nextDrawing = null;

    AbstractPlayer() {
    }

    @Override
    public void decideNextDrawing(int row, int column) {
        this.nextDrawing = Coordinate.from(row, column);
    }

    @Override
    public final Optional<Coordinate> drawingDecision() {
        return Optional.ofNullable(this.nextDrawing);
    }
}
