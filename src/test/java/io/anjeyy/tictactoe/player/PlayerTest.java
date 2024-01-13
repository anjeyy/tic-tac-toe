package io.anjeyy.tictactoe.player;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void testPlayerIcons() {
        Player firstPlayer = PlayerFactory.createFirstPlayer();

        String actual = firstPlayer.icon();

        Assertions.assertThat(actual).isEqualTo("X");
    }

    @Test
    void testAlternativePlayerIcon() {
        Player secondPlayer = PlayerFactory.createSecondPlayer();

        String actual = secondPlayer.icon();

        Assertions.assertThat(actual).isEqualTo("O");
    }
}
