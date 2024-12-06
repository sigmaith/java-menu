package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.constants.Category;
import menu.exception.CustomException;
import menu.exception.ErrorMessage;

public class Coach {
    private final String name;
    private List<Menu> prohibit;
    private List<Menu> lunchMenus;

    public Coach(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw CustomException.from(ErrorMessage.COACH_NAME);
        }
        this.name = name;
        this.lunchMenus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setProhibit(List<Menu> prohibit) {
        this.prohibit = prohibit;
    }

    public void getRecommendIn(List<Menu> menusInCategory) { //  코치가 이미 먹은 음식이 아닌지, 코치가 못먹는 음식이 아닌지
        while (true) {
            List<String> menus = menusInCategory.stream().map(Menu::getName).collect(Collectors.toList()); // 메뉴 이름
            Menu today = menusInCategory.stream().filter(menu -> menu.getName().equals(Randoms.shuffle(menus).get(0)))
                    .findFirst() // 랜덤으로 고른 메뉴이름이랑 일치하는 메뉴
                    .orElse(Menu.from(Category.western, "문제있음")); // 문제있음...
            if (!isProhibit(today) && !isDuplicated(today)) {
                lunchMenus.add(today);
                break;
            }
        }
    }

    public List<String> getLunchMenuNames() {
        return lunchMenus.stream().map(Menu::getName).collect(Collectors.toList());
    }

    private boolean isProhibit(Menu menu) {
        return prohibit.contains(menu);
    }

    private boolean isDuplicated(Menu menu) {
        return lunchMenus.contains(menu);
    }
}
