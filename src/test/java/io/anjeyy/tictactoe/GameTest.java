package io.anjeyy.tictactoe;

import org.assertj.core.api.Assertions;
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

}
