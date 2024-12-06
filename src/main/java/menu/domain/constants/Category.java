package menu.domain.constants;

import java.util.Arrays;
import menu.exception.CustomException;
import menu.exception.ErrorMessage;

public enum Category {
    japan("일식"),
    korean("한식"),
    chinese("중식"),
    asian("아시안"),
    western("양식");

    private String name;

    Category(String name) {
        this.name = name;
    }

    public static Category from(int ordinal) {
        return Arrays.stream(values()).filter(c -> c.ordinal() == ordinal).findFirst()
                .orElseThrow(() -> CustomException.from(
                        ErrorMessage.NON_EXISTENT_ORDINAL));
    }

    public String getName() {
        return name;
    }
}
