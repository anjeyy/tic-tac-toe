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

        firstPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._2, Coordinate.Column._1);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._2);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._2, Coordinate.Column._2);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._3);
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
    void testSecondColumnGameOver() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        firstPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._2);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._3);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(Coordinate.Row._2, Coordinate.Column._2);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._2, Coordinate.Column._3);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(Coordinate.Row._3, Coordinate.Column._2);
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
    void testWinnerWithoutGameOver() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        firstPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._3);
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

        firstPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._1);

        ThrowableAssert.ThrowingCallable expectedThrow = () -> game.draw(secondPlayer);
        Assertions.assertThatThrownBy(expectedThrow)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Cell is already marked by a player.");
    }

    @Test
    void testDrawingAfterGameOver() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        firstPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._3);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(Coordinate.Row._2, Coordinate.Column._2);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._2, Coordinate.Column._3);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(Coordinate.Row._3, Coordinate.Column._3);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._2);

        ThrowableAssert.ThrowingCallable expectedThrow = () -> game.draw(secondPlayer);
        Assertions.assertThatThrownBy(expectedThrow)
            .isInstanceOf(IllegalCallerException.class)
            .hasMessage("Game is over. Create a new game.");
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
    void testDrawingWithoutWinner() {
        Game game = Game.start();
        Player firstPlayer = PlayerFactory.createFirstPlayer();
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        firstPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._2, Coordinate.Column._2);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._2);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._1, Coordinate.Column._3);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(Coordinate.Row._3, Coordinate.Column._1);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._2, Coordinate.Column._1);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(Coordinate.Row._2, Coordinate.Column._3);
        game.draw(firstPlayer);
        secondPlayer.decideNextDrawing(Coordinate.Row._3, Coordinate.Column._2);
        game.draw(secondPlayer);

        firstPlayer.decideNextDrawing(Coordinate.Row._3, Coordinate.Column._3);
        game.draw(firstPlayer);

        String[][] actual = game.showBoard();
        Assertions.assertThat(actual)
            .contains(new String[] { "X", "X", "O" }, Index.atIndex(0))
            .contains(new String[] { "O", "O", "X" }, Index.atIndex(1))
            .contains(new String[] { "X", "O", "X" }, Index.atIndex(2));
        boolean isGameOver = game.isGameOver();
        Assertions.assertThat(isGameOver).isTrue();
        Optional<Player> winner = game.winner();
        Assertions.assertThat(winner).isEmpty();

        secondPlayer.decideNextDrawing(Coordinate.Row._3, Coordinate.Column._2);
        ThrowableAssert.ThrowingCallable expectedThrow = () -> game.draw(secondPlayer);
        Assertions.assertThatThrownBy(expectedThrow)
            .isInstanceOf(IllegalCallerException.class)
            .hasMessage("Game is over. Create a new game.");
    }

    //memo drawing outside of range - ENUM?

}
