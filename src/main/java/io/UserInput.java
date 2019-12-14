package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class UserInput {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String COMMA = ",";
    private static final int ZERO = 0;
    private static final int MAX_OF_USER = 8;
    private static final int MIN_OF_USER = 2;

    public static boolean inputHaveMore(String name) throws IOException {
        PrintHandler.inputOneMoreCard(name);
        String userInput = BR.readLine().trim().toUpperCase();
        return isItYes(name, userInput);
    }

    private static boolean isItYes(String name, String userInput) throws IOException {
        if(userInput.equals("Y"))
            return true;
        if(!userInput.equals("N")){
            PrintHandler.errorInputYesOrNo();
            return inputHaveMore(name);
        }
        return false;
    }

    public List<String> inputNames() throws IOException {
        PrintHandler.inputUserNames();
        String[] userNamesArray = BR.readLine().trim().split(COMMA);
        if (userNameOk(userNamesArray) && rangeOfUsers(userNamesArray) && notDuplication(userNamesArray))
            return Arrays.asList(userNamesArray);
        PrintHandler.errorInputNames();
        return inputNames();
    }

    private boolean notDuplication(String[] userNamesArray) {
        return userNamesArray.length ==
                Arrays.stream(userNamesArray).collect(Collectors.toSet()).size();
    }

    private boolean rangeOfUsers(String[] userNamesArray) {
        int length = userNamesArray.length;
        return length >= MIN_OF_USER && length <= MAX_OF_USER;
    }

    private boolean userNameOk(String[] userNamesArray) {
        return !(Arrays.stream(userNamesArray)
                .map(s -> s.length() == ZERO)
                .collect(Collectors.toList())
                .contains(true));
    }

    public List<Double> inputBettingMoney(List<String> userNames) throws IOException {
        List<Double> bettingMoney = new ArrayList<>();
        for(String userName : userNames){
            PrintHandler.inputBettingMoney(userName);
            bettingMoney.add(bettingMoneyValidator());
        }
        return bettingMoney;
    }

    private Double bettingMoneyValidator() throws IOException {
        try {
            return notZeroAndMinus(Double.parseDouble(BR.readLine().trim()));
        } catch (NumberFormatException e){
            PrintHandler.errorInputBettingMoney();
            return bettingMoneyValidator();
        }
    }

    private Double notZeroAndMinus(Double parseDouble) throws IOException {
        if(parseDouble == ZERO || parseDouble < ZERO){
            PrintHandler.errorZeroException();
            return bettingMoneyValidator();
        }
        return parseDouble;
    }
}
