package onemoreblackjack.controller;

import java.io.IOException;
import java.util.List;

import onemoreblackjack.io.UserInput;
import onemoreblackjack.model.GameModel;

/**
 * @since 2019-12-12
 * @author KIMSIYOUNG
 * @apiNote 게임 진행을 위한 Controller입니다.
 */
public class GameController {

    public static void play() throws IOException {
        UserInput userInput = new UserInput();
        List<String> userNames = userInput.makeUserNames();
        List<Double> bettingMoney = userInput.makeBettingMoneys(userNames);
        GameModel gameModel = new GameModel();
        gameModel.makePlayersAndDealer(userNames,bettingMoney);
        gameModel.playGame();
    }
}
