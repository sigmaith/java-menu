package menu.controller.dto;

import java.util.List;
import menu.domain.constants.Category;

public class MenuInfo {
    private Category category;
    private List<String> menuNames;

    public MenuInfo(Category category, List<String> menuNames) {
        this.category = category;
        this.menuNames = menuNames;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getMenuNames(){
        return menuNames;
    }
}

