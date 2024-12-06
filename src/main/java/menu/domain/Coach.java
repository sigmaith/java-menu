package menu.domain;

import java.util.List;
import menu.exception.CustomException;
import menu.exception.ErrorMessage;

public class Coach {
    private final String name;
    private List<Menu> prohibit = null;
    private List<Menu> lunchMenus = null;

    public Coach(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw CustomException.from(ErrorMessage.COACH_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setProhibit(List<Menu> prohibit) {
        this.prohibit = prohibit;
    }
}
