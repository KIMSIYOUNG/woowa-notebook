package io;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import domain.user.Dealer;
import domain.user.Player;

public class PrintHandler {
    private static final String INPUT_USER_NAMES = "게임에 참여할 사람의 이름을 입력해주세요. (쉼표로 구분)";
    private static final String ERROR_INPUT_NAMES = "입력값이 잘못되었습니다. 2~8명 사이의 사람을 공백없이 입력해주세요.(동일 이름은 안돼요)";
    private static final String INPUT_BETTING_MONEY = "님 배팅하고자 하는 금액을 입력해주세요 !";
    private static final String ERROR_INPUT_BETTING_MONEY = "금액 입력이 잘 못 되었습니다. 다시 입력해주세요. (0원이나, 빈칸은 안돼요)";
    private static final String ERROR_ZERO_EXCEPTION = "0원 혹은 음수는 배팅 할 수 없습니다. 다시 입력해주세요.";
    private static final String INPUT_ONE_MORE_CARD = "님 한장의 카드를 더 가지시겠습니까?(받는다 : Y 받지 않는다 : N)";
    private static final String ERROR_INPUT_YES_OR_NO = "Y또는 N으로 대답해주세요 !";
    private static final String GIVE_ONE_MORE_CARD_TO_DEALER = "딜러의 카드 합이 16이하여서 딜러는 한장의 카드를 더 받았습니다.";
    private static final String PRINT_SYSTEM_ERROR = "프로그램에 오류가 있는 것 같습니다. 수리 후 시도해주세요.";
    private static final String NEXT_LINE = "\n";

    public static void inputUserNames() {
        System.out.println(INPUT_USER_NAMES);
    }

    public static void errorInputNames() {
        System.out.println(ERROR_INPUT_NAMES);
    }

    public static void inputBettingMoney(String userName) {
        System.out.println(userName + INPUT_BETTING_MONEY);
    }

    public static void errorInputBettingMoney() {
        System.out.println(ERROR_INPUT_BETTING_MONEY);
    }

    public static void errorZeroException() {
        System.out.println(ERROR_ZERO_EXCEPTION);
    }

    public static void inputOneMoreCard(String player) {
        System.out.println(NEXT_LINE + player + INPUT_ONE_MORE_CARD);
    }

    public static void errorInputYesOrNo() {
        System.out.println(ERROR_INPUT_YES_OR_NO);
    }

    public static void giveOneMoreCardToDealer() {
        System.out.println("\n" + GIVE_ONE_MORE_CARD_TO_DEALER);
    }

    public static void printCards(Player player) {
        System.out.println(player.toString());
    }

    public static void printDealerCard(Dealer dealer) {
        System.out.println("딜러카드 : " + dealer.getCards().get(0));
    }

    public static void printAllCards(List<Player> players, Dealer dealer) {
        System.out.println(NEXT_LINE + dealer.toString() + "결과 : " + dealer.cardSumWithAce());
        for (Player player : players)
            System.out.println(player.toString() + " 결과 : " + player.cardSumWithAce());
    }

    public static void printResult(Map<String, Double> result) {
        System.out.println(NEXT_LINE + "최종 수익 ");
        Iterator<String> nameAndProfits = result.keySet().iterator();
        while (nameAndProfits.hasNext()) {
            String key = nameAndProfits.next();
            Double value = result.get(key);
            System.out.println(key + "님의 수익 : " + value);
        }

    }

    public static void printSystemError() {
        System.out.println(PRINT_SYSTEM_ERROR);
    }
}
