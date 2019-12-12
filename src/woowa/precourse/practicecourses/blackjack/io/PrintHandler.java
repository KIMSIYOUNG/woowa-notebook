package woowa.precourse.practicecourses.blackjack.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import woowa.precourse.practicecourses.blackjack.user.Dealer;
import woowa.precourse.practicecourses.blackjack.user.Player;
import woowa.precourse.practicecourses.blackjack.user.User;

public class PrintHandler {
    private static final String title = "님";
    private static final String INPUT_USER_NAME_RULE = "게임에 참여 할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String ERROR_USER_NAME = "이름 입력이 잘못되었습니다.";
    private static final String INPUT_BETTING_MONEY = "배팅 금액은? ";
    private static final String ERROR_BETTING_MONEY = "배팅금액 입력이 잘못되었습니다. 다시 입력해주세요.";
    private static final String DEALER_AND = "딜러와 ";
    private static final String DEALER = "딜러";
    private static final String COLON = " : ";
    private static final String GIVE_TWO_CARDS = " 에게 2장의 카드를 나누었습니다.";
    private static final String COMMA = ",";
    private static final String ADDITIONAL_ONE_CARD = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final String ONE_MORE_CARD_TO_DEALER = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String NEXT_LINE = "\n";



    public static void inputUserNameRule() {
        System.out.println(INPUT_USER_NAME_RULE);
    }

    public static void errorUserName() {
        System.out.println(ERROR_USER_NAME);
    }

    public static void inputBettingMoney(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(title).append(INPUT_BETTING_MONEY);
        System.out.println(sb.toString());
    }

    public static void ErrorBettingMoney() {
        System.out.println(ERROR_BETTING_MONEY);
    }

    public static void printUserAndCards(Dealer dealer, List<Player> players) {
        List<String> names = new ArrayList<>();
        String result = DEALER_AND;
        for (int i = 0; i < players.size(); i++) {
            names.add(players.get(i).getName());
        }
        result += result.join(COMMA,names) + GIVE_TWO_CARDS;
        System.out.println(result);
        printBasicCards(dealer,players);
    }
    //TODO
    private static void printBasicCards(Dealer dealer, List<Player> players) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEALER).append(COLON).append(dealer.getCards().get(0)).append("\n");
        for(int i=0;i<players.size(); i++){
            Player player = players.get(i);
            sb.append(player.getName()).append(COLON).append(player.getCards().toString()).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void chooseAdditionalCard(String name) {
        System.out.println(name + ADDITIONAL_ONE_CARD);
    }

    public static void printUserNameAndCards(Player player){
        System.out.println(player.getCards().toString());
    }

    public static void printOneMoreCardToDealer() {
        System.out.println(ONE_MORE_CARD_TO_DEALER);
    }

    public static void printCardAndSum(List<Player> players, Dealer dealer) {
        System.out.print(NEXT_LINE);
        System.out.println("딜러 : " + dealer.getCards().toString() + " 결과 : " + dealer.sumOfCard());
        for(int i=0; i<players.size(); i++){
            System.out.println(players.get(i).getName() + " : " +players.get(i).getCards().toString()+ " 결과 : "+players.get(i).sumOfCard());
        }
    }

    public static void printProfits(List<Player> players, Dealer dealer) {

    }

    public static void printOverNumberPlayer(List<Player> players) {
        for(int i =0;i<players.size(); i++){
            if(players.get(i).sumOfCard() > 21)
                System.out.println(players.get(i).getBettingMoney()*-1);
        }
    }
}
