package menu;

import menu.controller.LunchController;
import menu.view.InputView;
import menu.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LunchController lunchController = new LunchController(new InputView(), new OutputView());
        lunchController.recommendLunchMenus();
    }
}
