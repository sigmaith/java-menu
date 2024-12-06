package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.controller.dto.MenuInfo;
import menu.domain.constants.Category;
import menu.exception.CustomException;
import menu.exception.ErrorMessage;

public class Menus {
    private List<Menu> menus;
    private Map<String, Menu> menuMapByName = new HashMap<>();

    public static Menus from(List<MenuInfo> menuInfos) {
        List<Menu> menus = new ArrayList<>();
        for (MenuInfo menuInfo : menuInfos) {
            Category category = menuInfo.getCategory();
            List<String> menuNames = menuInfo.getMenuNames();
            menuNames.stream().map(name -> Menu.from(category, name)).forEach(menus::add);
        }
        return new Menus(menus);
    }

    private Menus(List<Menu> menus) {
        this.menus = menus;
        this.menuMapByName = menus.stream().collect(Collectors.toMap(Menu::getName, menu -> menu));
    }

    public Menu getMenuBy(String menuName) {
        Menu menu = menuMapByName.get(menuName);
        if (menu == null) {
            throw CustomException.from(ErrorMessage.NON_EXISTENT_MENU);
        }
        return menu;
    }

    public List<Menu> getMenusBy(Category category) {
        return menus.stream()
                .filter(menu -> menu.getCategory().equals(category))
                .collect(Collectors.toList());
    }
}
