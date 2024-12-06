package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import menu.domain.Coach;
import menu.domain.Coaches;

public class InputView {

    public Coaches getCoaches() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Coaches.from(readLine());
    }
}
