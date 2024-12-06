package menu.view;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Manager;

public class OutputView {
    private final String START_GUIDE = "점심 메뉴 추천을 시작합니다.";
    private final String RESULT_GUIDE = "메뉴 추천 결과입니다.";
    private final String DAY_OF_WEEK_GUIDE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private final String CATEGORIES_OF_WEEK_GUIDE = "[ 카테고리 | %s | %s | %s | %s | %s ]\n";
    private final String COACH_PERSONAL_MENUS = "[ %s | %s | %s | %s | %s | %s ]\n";
    private final String TERMINATION_GUIDE = "추천을 완료했습니다.";

    public void printStart() {
        System.out.println(START_GUIDE);
    }

    public void printLunchMenus(Manager manager, Coaches coaches) {
        System.out.println(RESULT_GUIDE);
        System.out.println(DAY_OF_WEEK_GUIDE);
        List<String> categories = manager.getCategoryNames();
        System.out.printf(String.format(CATEGORIES_OF_WEEK_GUIDE,
                categories.get(0), categories.get(1), categories.get(2),
                categories.get(3), categories.get(4)));
        for (Coach coach : coaches.getCoaches()) {
            List<String> lunchMenuNames = coach.getLunchMenuNames();
            System.out.printf(String.format(COACH_PERSONAL_MENUS, coach.getName(), lunchMenuNames.get(0),
                    lunchMenuNames.get(1), lunchMenuNames.get(2), lunchMenuNames.get(3), lunchMenuNames.get(4)));
        }
    }

    public void printTermination() {
        System.out.println(TERMINATION_GUIDE);
    }
}
