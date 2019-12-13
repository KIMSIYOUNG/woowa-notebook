package woowa.precourse.practicecourses.blackjack.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import woowa.precourse.practicecourses.blackjack.user.Player;

public class UserInput {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String COMMA = ",";
    private static final int ZERO = 0;

    private static Map<String, Double> userMap = new HashMap<>();

    private static InputValidator validator = new InputValidator();

    public List<String> makeUserNames() throws IOException {
        PrintHandler.inputUserNameRule();
        String[] userNames = BR.readLine().trim().split(COMMA);
        if (validator.checkUserNames(userNames)) {
            return Arrays.asList(userNames);
        }
        PrintHandler.errorUserName();
        return makeUserNames();
    }

    public List<Double> makeBettingMoney(List<String> names) throws IOException {
        List<Double> bettingMoneyList = new ArrayList<>();
        for (String name : names) {
            PrintHandler.inputBettingMoney(name);
            double bettingMoney = inputBettingMoney();
            bettingMoneyList.add(bettingMoney);
        }
        return bettingMoneyList;
    }

    private double inputBettingMoney() throws IOException {
        double bettingMoney = ZERO;
        try {
            bettingMoney = Double.parseDouble(BR.readLine().trim());
        } catch (NumberFormatException e) {
            PrintHandler.ErrorBettingMoney();
            return inputBettingMoney();
        }
        if (validator.checkBettingMoney(bettingMoney)) {
            return bettingMoney;
        }
        return inputBettingMoney();
    }

    public boolean chooseAdditionalCard(Player player) throws IOException {
        PrintHandler.chooseAdditionalCard(player.getName());
        String yesOrNo = BR.readLine().trim().toUpperCase();
        if (player.sumOfCardToAdd() < 21 && yesOrNo.equals("Y") ) {
            return true;
        }
        if ( player.sumOfCardToAdd() >= 21 || yesOrNo.equals("N")) {
            return false;
        }
        return chooseAdditionalCard(player);
    }
}
