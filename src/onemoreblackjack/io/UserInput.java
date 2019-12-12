package onemoreblackjack.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final double ZERO = 0;
    private static final String COMMA = ",";

    public List<String> makeUserNames() throws IOException {
        PrintHandler.inputUserNames();
        String[] userNames = BR.readLine().trim().split(COMMA);
        if(checkNames(userNames))
            return Arrays.asList(userNames);
        PrintHandler.errorInputNames();
        return makeUserNames();
    }

    private boolean checkNames(String[] userNames) {
        int count = 0;
        for(int i=0; i<userNames.length; i++){
            count += checkNameSize(userNames[i]);
        }
        return count == userNames.length;
    }

    private int checkNameSize(String name) {
        int count = 0;
        if(name.length()!=ZERO)
            count++;
        return count;
    }

    public List<Double> makeBettingMoneys(List<String> userNames) throws IOException {
        List<Double> bettingMoneys = new ArrayList<>();
        for(int i=0; i<userNames.size(); i++){
            bettingMoneys.add(inputBettingMoney(userNames.get(i)));
        }
        return bettingMoneys;
    }

    private double inputBettingMoney(String name) throws IOException {
        try{
            PrintHandler.howMuchBettingMoney(name);
            return checkBettingMoney(Double.parseDouble(BR.readLine().trim()),name);
        }catch (NumberFormatException e){
            PrintHandler.errorInputBettingMoney();
            return inputBettingMoney(name);
        }
    }

    private double checkBettingMoney(double parseDouble,String name) throws IOException {
        if(parseDouble != ZERO)
            return parseDouble;
        PrintHandler.errorOfZero();
        return inputBettingMoney(name);
    }

    public boolean wantToMore() throws IOException {
        String userInput = BR.readLine().trim().toUpperCase();
        if(userInput.equals("Y"))
            return true;
        if(userInput.equals("N"))
            return false;
        PrintHandler.errorYesOrNo();
        return wantToMore();
    }
}
