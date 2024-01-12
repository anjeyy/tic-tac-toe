package io.anjeyy.tictactoe.player;

import io.anjeyy.tictactoe.Coordinate;

public interface Player {

    String icon();

    void decideNextDrawing(int row, int column);

    Coordinate drawingDecision();
}
