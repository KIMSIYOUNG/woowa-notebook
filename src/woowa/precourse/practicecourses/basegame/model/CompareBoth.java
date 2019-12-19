package woowa.precourse.practicecourses.basegame.model;

import java.util.Arrays;
import java.util.List;

import woowa.precourse.practicecourses.basegame.domain.Count;

public class CompareBoth {

    private static final String BLANK = "";

    public static void compare(int randomNumber, int userNumber) {
        List<String> randomList = Arrays.asList(String.valueOf(randomNumber).split(BLANK));
        String[] userArray = String.valueOf(userNumber).split(BLANK);
        Count.initialize();
        for (int i = 0; i < randomList.size(); i++) {
            countBallAndStrike(randomList, userArray[i], i);
        }
    }

    private static void countBallAndStrike(List<String> randomList, String userDigitNumber, int i) {
        if (randomList.contains(userDigitNumber) && !randomList.get(i).equals(userDigitNumber))
            Count.BALL.addBall();
        if (randomList.get(i).equals(userDigitNumber))
            Count.BALL.addStrike();
    }

    public static boolean totallySame(int randomNumber, int userNumber) {
        return randomNumber == userNumber;
    }
}
