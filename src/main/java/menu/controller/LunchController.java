package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import menu.controller.dto.MenuInfo;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Manager;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.domain.constants.Category;
import menu.view.InputView;
import menu.view.OutputView;

public class LunchController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Menus menus;

    public LunchController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menus = setMenus();
    }

    public void recommendLunchMenus() {
        Coaches coaches = getCoaches();
        getEachProhibitedMenus(coaches);
        Manager manager = new Manager(coaches, menus);
        manager.recommend();
    }

    private Menus setMenus() {
        List<MenuInfo> menuInfos = new ArrayList<>();
        menuInfos.add(
                new MenuInfo(Category.japan, convertStringToList("규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼")));
        menuInfos.add(
                new MenuInfo(Category.korean, convertStringToList("김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음")));
        menuInfos.add(new MenuInfo(Category.chinese,
                convertStringToList("깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채")));
        menuInfos.add(
                new MenuInfo(Category.asian, convertStringToList("팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜")));
        menuInfos.add(
                new MenuInfo(Category.western, convertStringToList("라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니")));
        return Menus.from(menuInfos);
    }

    private Coaches getCoaches() {
        outputView.printStart();
        return retry(inputView::getCoaches);
    }

    private void getEachProhibitedMenus(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            List<Menu> prohibits = retry(() -> inputView.getProhibitedMenusOf(coach, menus));
            coach.setProhibit(prohibits);
        }
    }

    private List<String> convertStringToList(String input) {
        return Arrays.stream(input.split(", ", -1)).collect(Collectors.toList());
    }


    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
