package io.anjeyy.tictactoe.player;

import io.anjeyy.tictactoe.Coordinate;

import java.util.Optional;

public interface Player {

    String icon();

    void decideNextDrawing(Coordinate.Row row, Coordinate.Column column);

    Optional<Coordinate> drawingDecision();
}
