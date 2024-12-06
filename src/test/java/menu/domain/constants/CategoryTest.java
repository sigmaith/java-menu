package menu.domain.constants;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import menu.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

class CategoryTest {
    @Test
    void 없는_ordinal_예외테스트() {
        assertThatThrownBy(() -> Category.from(100)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(
                ErrorMessage.NON_EXISTENT_ORDINAL.getMessage());
    }
}