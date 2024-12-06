package menu.domain;

import java.util.Objects;
import menu.domain.constants.Category;

public class Menu {
    private final Category category;
    private final String name;

    public static Menu from(Category category, String name) {
        return new Menu(category, name);
    }

    private Menu(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Menu))
            return false;
        Menu menu = (Menu)o;
        return category == menu.category &&
                Objects.equals(name, menu.name);
    }

    // hashcode 재정의
    @Override
    public int hashCode() {
        return Objects.hash(category, name);
    }
}
