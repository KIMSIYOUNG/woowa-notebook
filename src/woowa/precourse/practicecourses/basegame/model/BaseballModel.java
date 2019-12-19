package woowa.precourse.practicecourses.basegame.model;

import java.io.IOException;

import woowa.precourse.practicecourses.basegame.domain.RandomNumber;
import woowa.precourse.practicecourses.basegame.view.InputView;
import woowa.precourse.practicecourses.basegame.view.OutputView;

public class BaseballModel {
    private static int randomNumber = 0;
    private static int userNumber = 0;

    public boolean playGame() throws IOException {
        randomNumber = RandomNumber.create();
        do {
            userNumber = InputView.createUserNumber();
            CompareBoth.compare(randomNumber, userNumber);
            OutputView.printCompareResult();
        } while (!CompareBoth.totallySame(randomNumber, userNumber));
        OutputView.printCongratulation();
        checkOneMoreGameOrStop();
        return false;
    }

    private boolean checkOneMoreGameOrStop() throws IOException {
        if (InputView.inputOneMoreGame()) {
            return playGame();
        }
        return false;
    }
}
