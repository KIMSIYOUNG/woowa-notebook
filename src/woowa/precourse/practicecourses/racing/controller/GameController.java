package woowa.precourse.practicecourses.racing.controller;

import java.io.IOException;
import java.util.List;

import woowa.precourse.practicecourses.racing.io.UserInput;
import woowa.precourse.practicecourses.racing.model.GameModel;

public class GameController {
    public void play() throws IOException {
        UserInput userInput = new UserInput();
        List<String> userNames = userInput.inputUsers();
        int howManyTimes = userInput.inputHowMany();
        GameModel gameModel = new GameModel(userNames, howManyTimes);
        gameModel.gamePlay();
        gameModel.getResult();
    }
}
