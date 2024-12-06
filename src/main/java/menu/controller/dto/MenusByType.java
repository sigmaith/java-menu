package menu.controller.dto;

import java.util.List;
import menu.menu.domain.constants.Category;

public class MenusByType {
    private Category category;
    private List<String> menuNames;

    public MenusByType(Category category, List<String> menuNames) {
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

