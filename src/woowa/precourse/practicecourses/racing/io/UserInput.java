package woowa.precourse.practicecourses.racing.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    private static final String COMMA = ",";
    private static final int ZERO = 0;
    private static final int MAX_USER_COUNT = 8;
    private final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public List<String> inputUsers() throws IOException {
        PrintHandler.inputUserNames();
        String[] names = BR.readLine().trim().split(COMMA);
        if (checkNameSize(names) && checkUserCount(names))
            return Arrays.asList(names);
        PrintHandler.errorUserNames();
        return inputUsers();
    }

    private boolean checkUserCount(String[] names) {
        return names.length != ZERO && names.length <= MAX_USER_COUNT;
    }

    private boolean checkNameSize(String[] names) {
        int nameLengthZeroCount = 0;
        for (int i = 0; i < names.length; i++) {
            nameLengthZeroCount = getNameLengthZeroCount(names[i], nameLengthZeroCount);
        }
        return nameLengthZeroCount == ZERO;
    }

    private int getNameLengthZeroCount(String name, int nameLengthZeroCount) {
        if (name.length() == ZERO)
            nameLengthZeroCount++;
        return nameLengthZeroCount;
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
