package io.anjeyy.tictactoe;

import io.anjeyy.tictactoe.player.Player;
import io.anjeyy.tictactoe.player.PlayerFactory;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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
    void testMissingDrawing() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();

        ThrowableAssert.ThrowingCallable expectedThrow = () -> game.draw(firstPlayer);

        Assertions.assertThatThrownBy(expectedThrow)
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("Player needs to make a decision where to draw.");
    }

    @Test
    void testRowGameOver() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        firstPlayer.decideNextDrawing(1, 1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(2, 1);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(1, 2);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(2, 2);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(1, 3);
        game.draw(firstPlayer);

        String[][] actual = game.showBoard();
        Assertions.assertThat(actual)
            .contains(new String[] { "X", "X", "X" }, Index.atIndex(0))
            .contains(new String[] { "O", "O", null }, Index.atIndex(1))
            .contains(new String[3], Index.atIndex(2));
        boolean isGameOver = game.isGameOver();
        Assertions.assertThat(isGameOver).isTrue();
        Optional<Player> winner = game.winner();
        Assertions.assertThat(winner)
            .isNotEmpty()
            .get()
            .asString()
            .isEqualTo("Player 1: X");
    }

    @Test
    void testSecondRowGameOver() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        firstPlayer.decideNextDrawing(2, 1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(3, 1);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(2, 2);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(3, 2);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(2, 3);
        game.draw(firstPlayer);

        String[][] actual = game.showBoard();
        Assertions.assertThat(actual)
            .contains(new String[] { null, null, null }, Index.atIndex(0))
            .contains(new String[] { "X", "X", "X" }, Index.atIndex(1))
            .contains(new String[] { "O", "O", null }, Index.atIndex(2));
        boolean isGameOver = game.isGameOver();
        Assertions.assertThat(isGameOver).isTrue();
        Optional<Player> winner = game.winner();
        Assertions.assertThat(winner)
            .isNotEmpty()
            .get()
            .asString()
            .isEqualTo("Player 1: X");
    }

    @Test
    void testColumnGameOver() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        firstPlayer.decideNextDrawing(1, 1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(1, 2);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(2, 1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(2, 2);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(3, 1);
        game.draw(firstPlayer);

        String[][] actual = game.showBoard();
        Assertions.assertThat(actual)
            .contains(new String[] { "X", "O", null }, Index.atIndex(0))
            .contains(new String[] { "X", "O", null }, Index.atIndex(1))
            .contains(new String[] { "X", null, null }, Index.atIndex(2));
        boolean isGameOver = game.isGameOver();
        Assertions.assertThat(isGameOver).isTrue();
        Optional<Player> winner = game.winner();
        Assertions.assertThat(winner)
            .isNotEmpty()
            .get()
            .asString()
            .isEqualTo("Player 1: X");
    }

    @Test
    void testSecondColumnGameOver() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        firstPlayer.decideNextDrawing(1, 2);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(1, 3);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(2, 2);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(2, 3);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(3, 2);
        game.draw(firstPlayer);

        String[][] actual = game.showBoard();
        Assertions.assertThat(actual)
            .contains(new String[] { null, "X", "O" }, Index.atIndex(0))
            .contains(new String[] { null, "X", "O" }, Index.atIndex(1))
            .contains(new String[] { null, "X", null }, Index.atIndex(2));
        boolean isGameOver = game.isGameOver();
        Assertions.assertThat(isGameOver).isTrue();
        Optional<Player> winner = game.winner();
        Assertions.assertThat(winner)
            .isNotEmpty()
            .get()
            .asString()
            .isEqualTo("Player 1: X");
    }

    @Test
    void testDiagonalGameOver() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        firstPlayer.decideNextDrawing(1, 1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(1, 3);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(2, 2);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(2, 3);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(3, 3);
        game.draw(firstPlayer);

        String[][] actual = game.showBoard();
        Assertions.assertThat(actual)
            .contains(new String[] { "X", null, "O" }, Index.atIndex(0))
            .contains(new String[] { null, "X", "O" }, Index.atIndex(1))
            .contains(new String[] { null, null, "X" }, Index.atIndex(2));
        boolean isGameOver = game.isGameOver();
        Assertions.assertThat(isGameOver).isTrue();
        Optional<Player> winner = game.winner();
        Assertions.assertThat(winner)
            .isNotEmpty()
            .get()
            .asString()
            .isEqualTo("Player 1: X");
    }

    @Test
    void testWinnerWithoutGameOver() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        firstPlayer.decideNextDrawing(1, 1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(1, 3);
        game.draw(secondPlayer);

        boolean isGameOver = game.isGameOver();
        Assertions.assertThat(isGameOver).isFalse();
        Optional<Player> winner = game.winner();
        Assertions.assertThat(winner).isEmpty();
    }

    @Test
    void testDrawingSameCell() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        firstPlayer.decideNextDrawing(1, 1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(1, 1);

        ThrowableAssert.ThrowingCallable expectedThrow = () -> game.draw(secondPlayer);
        Assertions.assertThatThrownBy(expectedThrow)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Cell is already marked by a player.");
    }

    //memo test drawing after game is over
    //memo drawing outside of range - ENUM?

}
