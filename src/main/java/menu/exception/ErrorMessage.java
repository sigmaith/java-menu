package menu.exception;

public enum ErrorMessage {
    COACH_NAME("코치의 이름은 최소 2자, 최대 4자여야 합니다."),
    NUMBER_OF_COACHES("코치는 최소 2명, 최대 5명이어야 합니다."),
    NON_EXISTENT_MENU("존재하지 않는 메뉴입니다."),
    PROHIBITED_MENUS_RANGE("코치는 최대 2개의 못먹는 음식을 가집니다."),
    NON_EXISTENT_ORDINAL("없는 숫자입니다.");
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

