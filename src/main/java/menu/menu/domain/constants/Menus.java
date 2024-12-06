package menu.menu.domain.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.controller.dto.MenusByType;

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
