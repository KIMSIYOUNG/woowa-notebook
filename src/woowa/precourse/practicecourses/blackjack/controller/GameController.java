package woowa.precourse.practicecourses.blackjack.controller;

import java.io.IOException;
import java.util.List;

import woowa.precourse.practicecourses.blackjack.io.UserInput;
import woowa.precourse.practicecourses.blackjack.model.GameModel;

public class GameController {
    public static void main(String[] args) {

    }
    public static void gameStart() throws IOException {
        UserInput input = new UserInput();
        GameModel gameModel = new GameModel();
        List<String> names = input.makeUserNames();
        List<Double> bettingMoney = input.makeBettingMoney(names);
        gameModel.addPlayer(names, bettingMoney);
        gameModel.giveCards();
        gameModel.getResult();
    }
}
