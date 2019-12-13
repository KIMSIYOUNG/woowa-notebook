package onemoreblackjack.io;

import java.util.List;

import onemoreblackjack.user.Dealer;
import onemoreblackjack.user.Player;

public class PrintHandler {
    private static final String INPUT_USER_NAMES = "게임에 참여할 사람의 이름을 입력하세요. (쉼표 기준으로 분리)";
    private static final String ERROR_INPUT_NAMES = "이름 입력이 잘못되었습니다.";
    private static final String INPUT_BETTING_MONEY = " 님의 배팅 금액은?";
    private static final String ERROR_OF_ZERO = "배팅금액은 0원이 될 수 없습니다.";
    private static final String ERROR_INPUT_BETTING_MONEY = "배팅금액의 입력이 잘못되었습니다.";
    private static final String WANT_TO_ONE_MORE_CARD = " 님 한장의 카드를 더 받겠습니까? (받는다 : Y 받지않는다 : N)";
    private static final String ERROR_YES_OR_NO = "Y 또는 N으로 입력해주세요(대소문자 관계없습니다)";
    private static final String DEALER_ONE_MORE_CARD = "딜러의 카드의 합이 16이하라 한장의 카드를 더 받았습니다.";
    private static final String RESULT =" 결과 : ";
    private static final String NEXT_LINE ="\n";
    private static final String DEALER ="딜러 : ";
    private static final String SPACE_COLON =" : ";

    public static void inputUserNames() {
        System.out.println(INPUT_USER_NAMES);
    }

    public static void errorInputNames() {
        System.out.println(ERROR_INPUT_NAMES);
    }

    public static void howMuchBettingMoney(String name) {
        System.out.println(name+ INPUT_BETTING_MONEY);
    }

    public static void errorOfZero() {
        System.out.println(ERROR_OF_ZERO);
    }

    public static void errorInputBettingMoney() {
        System.out.println(ERROR_INPUT_BETTING_MONEY);
    }

    public static void printDealerAndPlayerCards(Dealer dealer, List<Player> players) {
        System.out.println(DEALER + dealer.getCards().toString());
        for(int i=0;i<players.size(); i++){
            System.out.println(players.get(i).getName()+SPACE_COLON+players.get(i).getCards().toString());
        }
    }

    public static void askWantToHaveMore(Player player) {
        System.out.println(player.getName()+WANT_TO_ONE_MORE_CARD);
    }

    public static void errorYesOrNo() {
        System.out.println(ERROR_YES_OR_NO);
    }

    public static void printPlayerCards(Player player) {
        System.out.println(player.toString());
    }

    public static void givenOneMoreCardToDealer() {
        System.out.println(NEXT_LINE+DEALER_ONE_MORE_CARD);
    }

    public static void showNamesAndCardsAndSum(Dealer dealer, List<Player> players) {
        System.out.print(NEXT_LINE);
        System.out.println(dealer.toString());
        for(int i=0;i<players.size(); i++){
            System.out.println(players.get(i).toString());
        }
        System.out.println(NEXT_LINE + "최종 결과는 아래에 표기됩니다."+NEXT_LINE);
    }

    public static void printPlayerProfit(Player player) {
        System.out.println(player.getName() + "님의 수익 : " + (player.getBettingMoney() * -1) );
    }

    public static void printResultOfDelaer(int sumOfBettingMoney) {
        System.out.println("딜러의 수익 : " + sumOfBettingMoney);
    }

    public static void winner(Player player) {
        System.out.println(player.getName() + "님의 수익" + player.getBettingMoney());
    }

    public static void draw(Player player) {
        System.out.println(player.getName() + "님의 수익 " + 0);
    }
}
