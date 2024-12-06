package menu.domain.constants;

import java.util.Arrays;
import menu.exception.CustomException;
import menu.exception.ErrorMessage;

public enum Category {
    japan, korean, chinese, asian, western;

    public static Category from(int ordinal) {
        return Arrays.stream(values()).filter(c -> c.ordinal() == ordinal).findFirst().orElseThrow(() -> CustomException.from(
                ErrorMessage.NON_EXISTENT_ORDINAL));
    }
}
