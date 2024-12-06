package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import menu.domain.constants.Category;
import org.junit.jupiter.api.Test;

class MenuTest {
    @Test
    void 동일성_기능테스트() {
        Menu sushi1 = Menu.from(Category.japan, "초밥");
        Menu sushi2 = Menu.from(Category.japan, "초밥");
        assertThat(sushi1).isEqualTo(sushi2);
    }
}