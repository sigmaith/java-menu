package menu.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import menu.controller.dto.MenuInfo;
import menu.domain.constants.Category;
import menu.exception.ErrorMessage;
import org.junit.jupiter.api.Test;

class MenusTest {

    @Test
    void 없는_메뉴이름_예외() {
        List<MenuInfo> menuInfos = new ArrayList<>();
        menuInfos.add(new MenuInfo(Category.chinese, List.of("짜장면", "짬뽕")));
        Menus menus = Menus.from(menuInfos);
        assertThatThrownBy(() -> menus.getMenuBy("젤리")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.NON_EXISTENT_MENU.getMessage());
    }
}