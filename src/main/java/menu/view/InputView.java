package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.controller.dto.MenuInfo;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.exception.CustomException;
import menu.exception.ErrorMessage;

public class InputView {

    public Coaches getCoaches() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Coaches.from(readLine());
    }

    public List<Menu> getProhibitedMenusOf(Coach coach, Menus menus) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coach.getName());
        List<String> prohibits = Arrays.stream(readLine().split(",", -1)).collect(Collectors.toList());
        if (prohibits.size() < 0 || prohibits.size() > 2) {
            throw CustomException.from(ErrorMessage.PROHIBITED_MENUS_RANGE);
        }
        List<Menu> prohibitedMenus = prohibits.stream().map(menuName -> menus.getMenuBy(menuName))
                .collect(Collectors.toList());
        return prohibitedMenus;
    }
}
