package woowa.precourse.practicecourses.baseball.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class UserInput {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String BLANK = "";
    private static final int END_GAME = 2;
    private static final int DIGIT_NUMBER = 3;


    public static boolean wantToEnd() throws IOException {
        PrintHandler.inputGameReStartOrEnd();
        try {
            return checkEndNumber(Integer.parseInt(BR.readLine().trim()));
        } catch (NumberFormatException e) {
            PrintHandler.errorInputEndOrStart();
            return wantToEnd();
        }
    }

    private static boolean checkEndNumber(int parseInt) throws IOException {
        if (parseInt == END_GAME)
            return true;
        if (parseInt != 1) {
            PrintHandler.errorInputEndOrStart();
            return wantToEnd();
        }
        return false;
    }

    public int makeNumber() throws IOException {
        PrintHandler.inputUserNumber();
        try {
            return checkDuplication(Integer.parseInt(BR.readLine().trim()));
        } catch (NumberFormatException e) {
            PrintHandler.errorUserInput();
            return makeNumber();
        }
    }

    private int checkDuplication(int parseInt) throws IOException {
        Set<String> setForValidating =
                Arrays.stream(String.valueOf(parseInt).split(BLANK)).collect(Collectors.toSet());
        if (setForValidating.size() == DIGIT_NUMBER)
            return parseInt;
        PrintHandler.errorInputDuplication();
        return makeNumber();
    }
}
