package woowa.precourse.practicecourses.baseball.controller;

import woowa.precourse.practicecourses.baseball.io.UserInput;
import woowa.precourse.practicecourses.baseball.model.GameModel;

public class GameController {
    public static void play() {
        UserInput userInput = new UserInput();
        do {
            GameModel gameModel = new GameModel();
            gameModel.playGame();
        } while (UserInput.wantToEnd());
    }
}
