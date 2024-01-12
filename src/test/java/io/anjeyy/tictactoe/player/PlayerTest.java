package io.anjeyy.tictactoe.player;

import io.anjeyy.tictactoe.player.FirstPlayer;
import io.anjeyy.tictactoe.player.Player;
import io.anjeyy.tictactoe.player.SecondPlayer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    /*
     * TDD list
     * - player factory
     */

    @Test
    void testPlayerIcons() {
        Player firstPlayer = PlayerFactory.createFirstPlayer();

        String actual = firstPlayer.icon();

        Assertions.assertThat(actual).isEqualTo("X");
    }

    @Test
    void testAlternativePlayerIcon() {
        Player secondPlayer = SecondPlayer.create();

        String actual = secondPlayer.icon();

        Assertions.assertThat(actual).isEqualTo("O");
    }
}
