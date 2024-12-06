package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

class CoachesTest {

    @Test
    void 코치_인원_예외() {
        assertThatThrownBy(() -> Coaches.from("수미")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                ErrorMessage.NUMBER_OF_COACHES.getMessage());
    }

    @Test
    void 코치_중복_예외() {
        assertThatThrownBy(() -> Coaches.from("수미,수미")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.COACH_NAME_DUPLICATION.getMessage());
    }
}