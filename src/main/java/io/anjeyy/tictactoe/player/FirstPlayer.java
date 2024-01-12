package io.anjeyy.tictactoe.player;

import io.anjeyy.tictactoe.Coordinate;

class FirstPlayer implements Player {

    private static final String ICON = "X";
    private Coordinate nextDrawing = null;

    private FirstPlayer() {
    }

    static FirstPlayer create() {
        return new FirstPlayer();
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
    public Coordinate drawingDecision() {
        return nextDrawing;
    }

}
