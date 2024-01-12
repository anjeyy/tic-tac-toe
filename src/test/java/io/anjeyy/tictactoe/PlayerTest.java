package io.anjeyy.tictactoe;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    //memo create interface and two implementations of it!

    @Test
    void testPlayerIcon() {
        FirstPlayer firstPlayer = FirstPlayer.create();

        String actual = firstPlayer.icon();

        Assertions.assertThat(actual).isEqualTo("X");
    }

    @Test
    void testAlternativePlayerIcon() {
        SecondPlayer playerFactory = SecondPlayer.create();

        String actual = playerFactory.icon();

        Assertions.assertThat(actual).isEqualTo("O");
    }
}
