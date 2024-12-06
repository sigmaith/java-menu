package menu.domain;

import menu.exception.CustomException;
import menu.exception.ErrorMessage;

public class Coach {
    private final String name;
    private final Menus prohibit = null;
    private Menus lunchMenus = null;

    public Coach(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw CustomException.from(ErrorMessage.COACH_NAME_EXCEPTION);
        }
        this.name = name;
    }
}
