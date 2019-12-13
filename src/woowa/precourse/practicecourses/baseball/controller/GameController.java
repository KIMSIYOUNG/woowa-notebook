package woowa.precourse.practicecourses.baseball.controller;

import java.io.IOException;

import woowa.precourse.practicecourses.baseball.io.UserInput;
import woowa.precourse.practicecourses.baseball.model.GameModel;

public class GameController {
    public static void play() throws IOException {
        do {
            GameModel gameModel = new GameModel();
            gameModel.playGame();
        } while (!UserInput.wantToEnd());
    }
}
