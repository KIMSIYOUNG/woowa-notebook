package controller;

import java.io.IOException;
import java.util.List;

import io.UserInput;
import model.GameModel;

public class GameController {
    public static void start() throws IOException {
        UserInput userInput = new UserInput();
        List<String> userNames = userInput.inputNames();
        List<Double> userBettingMoneys = userInput.inputBettingMoney(userNames);
        GameModel gameModel = new GameModel(userNames, userBettingMoneys);
        gameModel.play();
    }
}
