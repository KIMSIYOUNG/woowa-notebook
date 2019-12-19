package woowa.precourse.practicecourses.basegame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String INPUT_USER_NUMBER = "세 자리 수를 입력하세요.";
    private static final String ERROR_FORMAT = "입력형식이 잘못되었습니다.";
    private static final int ZERO = 0;
    private static final String STRING_ZERO = "0";
    private static final String ERROR_MIN = "0이하의 값은 입력할 수 없습니다.";
    private static final String BLANK = "";
    private static final String ERROR_NUMBER = "세자리 서로 다른 수를 입력해주세요.(0은 입력되지 않습니다. 서로다른 0아상의 세자리수를 입력해주세요.)";
    private static final int DIGIT_NUMBER = 3;
    private static final String INPUT_MORE_OR_STOP = "게임을 다시하려면 1번을, 그만하려면 2번을 눌러주세요";
    private static final String ERROR_INPUT = "1또는 2로만 입력할 수 있습니다.";
    private static final int MORE_GAME = 1;
    private static final int END_GAME = 2;

    public static int createUserNumber() throws IOException {
        System.out.println(INPUT_USER_NUMBER);
        try {
            return checkUserNumber(Integer.parseInt(BR.readLine().trim()));
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return createUserNumber();
        }
    }

    private static int checkUserNumber(int userInput) throws IOException {
        if (userInput < ZERO) {
            System.out.println(ERROR_MIN);
            return createUserNumber();
        }
        if (checkEachNumber(userInput)) {
            return userInput;
        }
        System.out.println(ERROR_NUMBER);
        return createUserNumber();
    }

    private static boolean checkEachNumber(int userInput) {
        Set<String> userInputSet
                = Arrays.stream(String.valueOf(userInput).split(BLANK)).collect(Collectors.toSet());
        if (userInputSet.size() == DIGIT_NUMBER && !(userInputSet.contains(STRING_ZERO)))
            return true;
        return false;
    }

    public static boolean inputOneMoreGame() throws IOException {
        System.out.println(INPUT_MORE_OR_STOP);
        try {
            return wantMore(Integer.parseInt(BR.readLine().trim()));
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputOneMoreGame();
        }

    }

    private static boolean wantMore(int userInput) throws IOException {
        if (userInput == MORE_GAME)
            return true;
        if (userInput != MORE_GAME && userInput != END_GAME) {
            System.out.println(ERROR_INPUT);
            return inputOneMoreGame();
        }
        return false;
    }
}
