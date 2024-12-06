package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.constants.Category;

public class Manager {
    private final Coaches coaches;
    private List<Category> categories;
    private Menus menus;

    public Manager(Coaches coaches, Menus menus) {
        this.coaches = coaches;
        this.menus = menus;
        categories = new ArrayList<>();
        int[] record = new int[]{0, 0, 0, 0, 0};
        int idx = Randoms.pickNumberInRange(0, 4);
        record[idx] = 1;
        categories.add(Category.from(idx)); // 월요일 카테고리
        while (categories.size() < 5) {
            idx = Randoms.pickNumberInRange(0, 4);
            if (record[idx] >= 2) {
                continue;
            }
            record[idx]++;
            categories.add(Category.from(idx));
        }
    }

    public void recommend() {
        // 코치에게 음식 추천할 때 고려할 것 : 그날의 음식 카테고리, 코치가 이미 먹은 음식이 아닌지, 코치가 못먹는 음식이 아닌지
        // Randoms.shuffle(List<String>(음식 이름들)) -> 그날의 음식 카테고리.
        for (Category category : categories) { // 그날의 음식 카테고리
            for (Coach coach : coaches.getCoaches()) {
                coach.getRecommendIn(menus.getMenusBy(category));
            }
        }
    }

    public List<String> getCategoryNames() {
        return categories.stream().map(Category::getName).collect(Collectors.toList());
    }
}
