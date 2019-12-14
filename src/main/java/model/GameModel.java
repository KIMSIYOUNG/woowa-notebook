package model;

import java.io.IOException;
import java.util.*;

import domain.card.Card;
import domain.card.CardFactory;
import domain.user.Dealer;
import domain.user.Player;
import io.PrintHandler;
import io.UserInput;

public class GameModel {
    private static final double CARD_COUNT = 51;
    private static final int TWO_CARDS = 2;
    private static final double FIRST_BLACK_JACK = 1.5;
    private static final int MULTIPLIER_PROFIT = 2;
    private static final int MINUS_PROFIT = -1;
    private static final double ZERO_PROFIT = 0;
    private static final String DEALER = "dealer";


    private final Map<String, Double> playersAndProfits = new HashMap<>();
    private final List<Player> players = new ArrayList<>();
    private final Dealer dealer = new Dealer();
    private final Set<Integer> setForRandomIndex = new HashSet<>();
    private final List<Card> cards = CardFactory.create();
    private Double totalOfBetting = Double.valueOf(0);

    public GameModel(List<String> userNames, List<Double> userBettingMoneys) {
        for (int i = 0; i < userNames.size(); i++) {
            players.add(new Player(userNames.get(i), userBettingMoneys.get(i)));
        }
        for (Double bettingMoney : userBettingMoneys) {
            totalOfBetting += bettingMoney;
        }
    }

    public void play() throws IOException {
        giveTwoCardsToEveryOne();
        checkFirstBlackJack();
        for (Player player : players)
            giveOneMoreCardToPlayer(player);
        giveOneMoreCardToDealer();
        PrintHandler.printAllCards(players, dealer);
        PrintHandler.printResult(setResult(playersAndProfits, totalOfBetting));
    }

    private void giveOneMoreCardToDealer() {
        while (dealer.sumOfCardWithoutAce() <= 16) {
            dealer.addCard(cards.get(makeRandomIndex()));
            PrintHandler.giveOneMoreCardToDealer();
        }
    }

    private boolean giveOneMoreCardToPlayer(Player player) throws IOException {
        if (canHaveMore(player) && wantToHave(player)) {
            player.addCard(cards.get(makeRandomIndex()));
            PrintHandler.printCards(player);
            return giveOneMoreCardToPlayer(player);
        }
        return false;
    }

    private boolean wantToHave(Player player) throws IOException {
        return UserInput.inputHaveMore(player.getName());
    }

    private boolean canHaveMore(Player player) {
        return player.sumOfCardWithoutAce() < 21;
    }

    private void checkFirstBlackJack() {
        for (Player player : players) {
            checkPlayerBlackJackFirst(player);
        }
    }

    private void checkPlayerBlackJackFirst(Player player) {
        if (player.isBlackJackFirst()) {
            checkDealerBlackJackFirst(player);
            totalOfBetting -= player.getBettingMoney() * FIRST_BLACK_JACK;
            playersAndProfits.put(player.getName(), (player.getBettingMoney() * FIRST_BLACK_JACK));
        }
    }

    private void checkDealerBlackJackFirst(Player player) {
        if (dealer.isBlackJackFirst()) {
            totalOfBetting -= player.getBettingMoney();
            playersAndProfits.put(player.getName(), player.getBettingMoney());
        }
    }

    private void giveTwoCardsToEveryOne() {
        for (Player player : players) {
            giveTwoCardsToPlayer(player);
        }
        giveTwoCardsToDealer();
    }

    private void giveTwoCardsToDealer() {
        for (int i = 0; i < TWO_CARDS; i++) {
            dealer.addCard(cards.get(makeRandomIndex()));
        }
        PrintHandler.printDealerCard(dealer);
    }

    private void giveTwoCardsToPlayer(Player player) {
        for (int i = 0; i < TWO_CARDS; i++) {
            player.addCard(cards.get(makeRandomIndex()));
        }
        PrintHandler.printCards(player);
    }

    private int makeRandomIndex() {
        return checkDuplication((int) (Math.random() * CARD_COUNT));
    }

    private int checkDuplication(int randomIndex) {
        int before = setForRandomIndex.size();
        setForRandomIndex.add(randomIndex);
        int after = setForRandomIndex.size();
        if (before == after)
            return makeRandomIndex();
        return randomIndex;
    }

    private Map<String, Double> setResult(Map<String, Double> playersAndProfits, double totalOfBetting) {
        if (dealer.isBurst()) {
            totalOfBetting = getTotalOfBetting(playersAndProfits, totalOfBetting);
            playersAndProfits.put(DEALER, totalOfBetting);
            return playersAndProfits;
        }
        for (Player player : players) {
            totalOfBetting = getTotalOfBetting(playersAndProfits, totalOfBetting, player);
        }
        playersAndProfits.put(DEALER, totalOfBetting);
        return playersAndProfits;
    }

    private double getTotalOfBetting(Map<String, Double> playersAndProfits, double totalOfBetting, Player player) {
        if (player.isBurst() && !playersAndProfits.containsKey(player.getName())) {
            playersAndProfits.put(player.getName(), (player.getBettingMoney() * MINUS_PROFIT));
        }
        totalOfBetting = compareDealerWithPlayer(playersAndProfits, totalOfBetting, player);
        return totalOfBetting;
    }

    private double compareDealerWithPlayer(Map<String, Double> playersAndProfits, double totalOfBetting, Player player) {
        if (player.cardSumWithAce() > dealer.cardSumWithAce() && !playersAndProfits.containsKey(player.getName())) {
            playersAndProfits.put(player.getName(), player.getBettingMoney());
            totalOfBetting -= player.getBettingMoney() * MULTIPLIER_PROFIT;
        }
        if (player.cardSumWithAce() == dealer.cardSumWithAce() && !playersAndProfits.containsKey(player.getName())) {
            playersAndProfits.put(player.getName(), Double.valueOf(ZERO_PROFIT));
            totalOfBetting -= player.getBettingMoney();
        }
        if (player.cardSumWithAce() < dealer.cardSumWithAce() && !playersAndProfits.containsKey(player.getName())) {
            playersAndProfits.put(player.getName(), (player.getBettingMoney() * MINUS_PROFIT));
        }
        return totalOfBetting;
    }

    private double getTotalOfBetting(Map<String, Double> playersAndProfits, double totalOfBetting) {
        for (Player player : players) {
            totalOfBetting = playerBurstOrNot(playersAndProfits, totalOfBetting, player);
        }
        return totalOfBetting;
    }

    private double playerBurstOrNot(Map<String, Double> playersAndProfits, double totalOfBetting, Player player) {
        if (player.isBurst()) {
            playersAndProfits.put(player.getName(), (player.getBettingMoney() * MINUS_PROFIT));
        }
        if (!playersAndProfits.containsKey(player.getName())) {
            playersAndProfits.put(player.getName(), player.getBettingMoney());
            totalOfBetting -= player.getBettingMoney() * MULTIPLIER_PROFIT;
        }
        return totalOfBetting;
    }
}
