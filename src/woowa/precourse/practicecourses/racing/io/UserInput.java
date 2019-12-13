package woowa.precourse.practicecourses.racing.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {
    private static final String COMMA = ",";
    private static final int ZERO = 0;
    private static final int MAX_USER_COUNT = 8;
    private final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public List<String> inputUsers() throws IOException {
        PrintHandler.inputUserNames();
        String[] names = BR.readLine().trim().split(COMMA);
        if (!checkNameSizeOk(names) && checkUserCount(names))
            return Arrays.asList(names);
        PrintHandler.errorUserNames();
        return inputUsers();
    }

    private boolean checkUserCount(String[] names) {
        return names.length != ZERO && names.length <= MAX_USER_COUNT;
    }

    private boolean checkNameSizeOk(String[] names) {
        return Arrays.stream(names)
                .map(s -> s.length() == ZERO)
                .collect(Collectors.toList())
                .contains(true);
    }

    public int inputHowMany() throws IOException {
        PrintHandler.inputHowMany();
        try {
            return checkNotZero(Integer.parseInt(BR.readLine().trim()));
        } catch (NumberFormatException e) {
            PrintHandler.errorInputHowMany();
            return inputHowMany();
        }
    }

    private int checkNotZero(int parseInt) throws IOException {
        if (parseInt == ZERO) {
            PrintHandler.errorInputZero();
            return inputHowMany();
        }
        return parseInt;
    }
}
