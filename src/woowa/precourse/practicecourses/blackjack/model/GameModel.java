package woowa.precourse.practicecourses.blackjack.model;

import java.io.IOException;
import java.util.*;

import woowa.precourse.practicecourses.blackjack.domain.Card;
import woowa.precourse.practicecourses.blackjack.domain.CardFactory;
import woowa.precourse.practicecourses.blackjack.io.PrintHandler;
import woowa.precourse.practicecourses.blackjack.io.UserInput;
import woowa.precourse.practicecourses.blackjack.user.Dealer;
import woowa.precourse.practicecourses.blackjack.user.Player;
import woowa.precourse.practicecourses.blackjack.user.User;

public class GameModel<T extends User> {
    private static Set<Integer> setForDuplication = new HashSet<>();
    private static int CARD_RANGE = 51;
    private static final int BASIC_CARD_AMOUNT = 2;
    private static List<Player> players = new ArrayList<>();
    private static Dealer dealer;
    private static List<Card> cards;
    private static UserInput userInput = new UserInput();

    public GameModel() {
        this.dealer = new Dealer();
        cards = CardFactory.create();
        for (Card c : cards) {
            System.out.println(c.toString());
        }
    }

    public void addPlayer(List<String> names, List<Double> moneys) {
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), moneys.get(i)));
        }
    }

    private int checkDuplicationAndGiveCard(User user, int index) {
        if (setForDuplication.contains(index)) {
            index = chooseRandomCard();
            return checkDuplicationAndGiveCard(user, index);
        }
        user.addCard(cards.get(index));
        return index;
    }


    public void giveCards() throws IOException {
        for (Player player : players) {
            giveTwoCards(player);
        }
        giveTwoCards(dealer);
        PrintHandler.printUserAndCards(dealer, players);

        for (Player player : players) {
            chooseAdditionalCard(player);
        }
        dealerAdditionalCard();
    }

    private void giveTwoCards(User user) {
        for (int i = 0; i < BASIC_CARD_AMOUNT; i++) {
            int index = chooseRandomCard();
            int indexForSet = checkDuplicationAndGiveCard(user, index);
            setForDuplication.add(indexForSet);
        }
    }


    private static int chooseRandomCard() {
        return (int) (Math.random() * CARD_RANGE);
    }

    public boolean chooseAdditionalCard(Player user) throws IOException {

        if (userInput.chooseAdditionalCard(user)) {
            giveAdditionalCard(user, true);
            PrintHandler.printUserNameAndCards(user);
            return chooseAdditionalCard(user);
        }
        return false;
    }

    private boolean dealerAdditionalCard() {
        int dealerSum = dealer.sumOfCardToAdd();
        if (dealerSum <= 16) {
            PrintHandler.printOneMoreCardToDealer();
            giveAdditionalCard(dealer, true);
            return dealerAdditionalCard();
        }
        return false;
    }

    private void giveAdditionalCard(User user, boolean addCard) {
        if (addCard) {
            int index = chooseRandomCard();
            int indexForSet = checkDuplicationAndGiveCard(user, index);
            setForDuplication.add(indexForSet);
        }
    }

    public void getResult() {
        PrintHandler.printCardAndSum(players, dealer);
        PrintHandler.printOverNumberPlayer(players);
        List<Integer> playersCardSum = new ArrayList<>();
        for (Player player : players) {
            playersCardSum.add(player.sumOfCard());
        }
        Integer playerMax = Collections.max(playersCardSum);
    }
}
