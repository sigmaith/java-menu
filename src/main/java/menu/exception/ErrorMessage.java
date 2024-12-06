package menu.exception;

public enum ErrorMessage {
    COACH_NAME_EXCEPTION("코치의 이름은 최소 2자, 최대 4자여야 합니다."),
    NUMBER_OF_COACHES_EXCEPTION("코치는 최소 2명, 최대 5명이어야 합니다.");
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

