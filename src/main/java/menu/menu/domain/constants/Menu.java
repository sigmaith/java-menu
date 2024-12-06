package menu.menu.domain.constants;

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
}
