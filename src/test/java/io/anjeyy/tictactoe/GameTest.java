package io.anjeyy.tictactoe;

import io.anjeyy.tictactoe.player.Player;
import io.anjeyy.tictactoe.player.PlayerFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void testPlayground() {
        Game game = Game.start();

        String[][] actual = game.showBoard();

        Assertions.assertThat(actual).hasDimensions(3, 3);
    }

    @Test
    void testEmptyGameOver() {
        Game game = Game.start();

        boolean actual = game.isGameOver();

        Assertions.assertThat(actual).isFalse();
    }

    @Test
    void testFirstDrawing() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        firstPlayer.decideNextDrawing(1, 1);
        game.draw(firstPlayer);

        Player secondPlayer = PlayerFactory.createSecondPlayer();
        secondPlayer.decideNextDrawing(2, 1);
        game.draw(secondPlayer);

        String[][] actual = game.showBoard();
        Assertions.assertThat(actual)
            .contains(new String[] { "X", null, null }, Index.atIndex(0))
            .contains(new String[] { "O", null, null }, Index.atIndex(1))
            .contains(new String[3], Index.atIndex(2));
    }

    @Test
    void testMissingDrawing() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();

        ThrowableAssert.ThrowingCallable expectedThrow = () -> game.draw(firstPlayer);

        Assertions.assertThatThrownBy(expectedThrow)
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("Player needs to make a decision where to draw.");
    }

}
