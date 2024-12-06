package menu.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import menu.exception.CustomException;
import menu.exception.ErrorMessage;

public class Coaches {
    private final List<Coach> coaches;

    public static Coaches from(String coachNames) {
        List<String> names = Arrays.stream(coachNames.split(",", -1)).collect(Collectors.toList());
        validateLengthOf(names);
        validateNoDuplicates(names);
        List<Coach> coaches = names.stream().map(name -> new Coach(name)).collect(Collectors.toList());
        return new Coaches(coaches);
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    private Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    private static void validateLengthOf(List<String> names) {
        if (names.size() < 2 || names.size() > 5) {
            throw CustomException.from(ErrorMessage.NUMBER_OF_COACHES);
        }
    }

    private static void validateNoDuplicates(List<String> names) {
        Set<String> set = new HashSet<>(names);
        if (set.size() != names.size()) {
            throw CustomException.from(ErrorMessage.COACH_NAME_DUPLICATION);
        }
    }
}
