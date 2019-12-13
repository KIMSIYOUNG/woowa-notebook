package woowa.precourse.practicecourses.baseball.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class UserInput {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String BLANK = "";

    public static boolean wantToEnd() {
        return false;
    }

    public int makeNumber() throws IOException {
        PrintHandler.inputUserNumber();
        try {
            return checkDuplication(Integer.parseInt(BR.readLine().trim()));
        }catch (NumberFormatException e){
            PrintHandler.errorUserInput();
            return makeNumber();
        }
    }

    private int checkDuplication(int parseInt) throws IOException {
        String[] userInputArray = String.valueOf(parseInt).split(BLANK);
        Set<String> setForValidating = new HashSet<>();
        for(String s : userInputArray)
            setForValidating.add(s);
        if(setForValidating.size() == userInputArray.length)
            return parseInt;
        PrintHandler.errorInputDuplication();
        return makeNumber();
    }
}
