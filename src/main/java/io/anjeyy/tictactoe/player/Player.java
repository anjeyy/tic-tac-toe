package io.anjeyy.tictactoe.player;

import io.anjeyy.tictactoe.Coordinate;

import java.util.Optional;

public interface Player {

    String icon();

    void decideNextDrawing(int row, int column);

    Optional<Coordinate> drawingDecision();
}
