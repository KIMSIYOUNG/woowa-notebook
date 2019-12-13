package woowa.precourse.practicecourses.baseball.model;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import woowa.precourse.practicecourses.baseball.io.PrintHandler;
import woowa.precourse.practicecourses.baseball.io.UserInput;

public class GameModel {
    private static final int RANGE = 9;
    private static final int START_POINT = 1;
    private static final int DIGIT_NUMBER = 3;
    private static final String BLANK = "";

    private static int strikeCount = 0;
    private static int ballCount = 0;
    private static int randomNumber = 0;
    private static int userNumber = 0;

    private static UserInput userInput;

    public GameModel() {
        userInput = new UserInput();
    }

    public void playGame() throws IOException {
        randomNumber = generateRandomNumber();
        do {
            userNumber = userInput.makeNumber();
            compareBoth();
            PrintHandler.printCompareResult(strikeCount,ballCount);
        }while (randomNumber != userNumber);
    }

    private void compareBoth() {
        strikeCount = 0;
        ballCount = 0;
        countStrikeAndBall(intToList(randomNumber),intToList(userNumber));
    }

    private void countStrikeAndBall(List<String> intToList, List<String> intToList1) {

    }

    private List<String> intToList(int number) {
        return Arrays.asList(String.valueOf(number).split(BLANK));
    }

    private int generateRandomNumber() {
        Set<Integer> setForRandomNumber = new HashSet<>();
        while (setForRandomNumber.size() != DIGIT_NUMBER) {
            setForRandomNumber.add((int) (Math.random() + RANGE + START_POINT));
        }
        return setToNumber(setForRandomNumber);
    }

    private int setToNumber(Set<Integer> setForRandomNumber) {
        String result = BLANK;
        for(Integer i : setForRandomNumber)
            result += String.valueOf(i);
        return Integer.parseInt(result);
    }

}