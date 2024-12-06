package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Manager;

public class OutputView {

    public void printStart() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printLunchMenus(Manager manager, Coaches coaches) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        List<String> categories = manager.getCategoryNames();
        System.out.printf("[ 카테고리 | %s | %s | %s | %s | %s ]", categories.get(0), categories.get(1), categories.get(2),
                categories.get(3), categories.get(4));
        for (Coach coach : coaches.getCoaches()) {
            List<String> lunchMenuNames = coach.getLunchMenuNames();
            System.out.printf("[ %s | %s | %s | %s | %s | %s ]", coach.getName(), lunchMenuNames.get(0),
                    lunchMenuNames.get(1), lunchMenuNames.get(2), lunchMenuNames.get(3), lunchMenuNames.get(4));
        }
    }
}
