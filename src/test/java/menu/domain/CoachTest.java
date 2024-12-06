package menu.domain;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

class CoachTest {

    @Test
    void 코치_이름_예외() {
        assertThatThrownBy(() -> new Coach("1")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                ErrorMessage.COACH_NAME.getMessage());
    }
}