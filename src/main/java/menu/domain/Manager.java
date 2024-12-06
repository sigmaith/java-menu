package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.constants.Category;

public class Manager {
    private final Coaches coaches;
    private List<Category> categories;

    public Manager(Coaches coaches) {
        this.coaches = coaches;
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
}
