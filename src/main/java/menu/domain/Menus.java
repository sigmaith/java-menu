package menu.domain;

import java.util.ArrayList;
import java.util.List;
import menu.controller.dto.MenusByType;
import menu.domain.constants.Category;

public class Menus {
    private List<Menu> menus = new ArrayList<>();

    public static Menus from(List<MenusByType> menusByTypes) {
        List<Menu> menus = new ArrayList<>();
        for (MenusByType menusByType: menusByTypes) {
            Category category = menusByType.getCategory();
            List<String> menuNames = menusByType.getMenuNames();
            menuNames.stream().map(name -> Menu.from(category, name)).forEach(menu -> menus.add(menu));
        }
        return new Menus(menus);
    }

    private Menus(List<Menu> menus) {
        this.menus = menus;
    }
}
