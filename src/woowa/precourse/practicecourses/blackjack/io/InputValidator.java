package woowa.precourse.practicecourses.blackjack.io;

public class InputValidator {
    private static final int ZERO = 0;
    private static int count = ZERO;

    public boolean checkUserNames(String[] userNames) {
        count = ZERO;
        for (int i = 0; i < userNames.length; i++) {
            checkUserNameSize(userNames[i]);
        }
        return userNames.length == count && userNames.length != ZERO;
    }

    private void checkUserNameSize(String userName) {
        if (userName.length() != ZERO) {
            count++;
        }
    }

    public boolean checkBettingMoney(double bettingMoney) {
        if (bettingMoney == ZERO)
            return false;
        return true;
    }

    public boolean checkAdditionCard(String yesOrNo) {
        if(yesOrNo.equals("Y"))
            return true;
        return false;
    }
}
