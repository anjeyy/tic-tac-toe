package io.anjeyy.tictactoe.player;

public interface Player {

    String icon();

    void decideNextDrawing(int row, int column);
}
