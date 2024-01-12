package io.anjeyy.tictactoe;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    /*
     * TDD list
     * - player interface
     */

    @Test
    void testPlayerIcons() {
        Player firstPlayer = FirstPlayer.create();

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
