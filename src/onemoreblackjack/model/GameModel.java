package onemoreblackjack.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import onemoreblackjack.domain.Card;
import onemoreblackjack.domain.CardFactory;
import onemoreblackjack.io.PrintHandler;
import onemoreblackjack.io.UserInput;
import onemoreblackjack.user.Dealer;
import onemoreblackjack.user.Player;
import onemoreblackjack.user.User;

public class GameModel {
    private static final int RANGE_OF_CARD = 51;
    private static final int BASIC_CARD = 2;

    private static UserInput userInput = new UserInput();
    private static List<Player> players = new ArrayList<>();
    private static Dealer dealer = new Dealer();
    private static List<Card> cards = CardFactory.create();
    private static Set<Integer> setNotForDuplicationOfCard = new HashSet<>();


    public void makePlayersAndDealer(List<String> userNames, List<Double> bettingMoney) {
        for(int i=0;i< userNames.size(); i++){
            players.add(new Player(userNames.get(i),bettingMoney.get(i)));
        }
    }

    public void playGame() throws IOException {
        giveTwoCardsToEveryOne();
        PrintHandler.printDealerAndPlayerCards(dealer,players);
        for(int i=0;i <players.size(); i++){
            giveOneMoreCard(players.get(i));
        }
        checkDealerOneMoreAndGive();
        PrintHandler.showNamesAndCardsAndSum(dealer,players);
        PrintHandler.printFinalResult(calculateResult());
    }

    private Object calculateResult() {
        return new Object();
    }

    private boolean checkDealerOneMoreAndGive() {
        int dealerSumOfCards = dealer.sumOfCardToAdd();
        if(dealerSumOfCards<=16){
            checkAndGiveCard(dealer,makeRandomNumber());
            PrintHandler.givenOneMoreCardToDealer();
            return checkDealerOneMoreAndGive();
        }
        return false;
    }

    private boolean giveOneMoreCard(Player player) throws IOException {
        if(canHaveMore(player) && wantToMore(player)){
            checkAndGiveCard(player,makeRandomNumber());
            PrintHandler.printPlayerCards(player);
            return giveOneMoreCard(player);
        }
        return false;
    }

    private boolean canHaveMore(Player player) {
        if(player.sumOfCardToAdd()>21)
            return false;
        return true;
    }

    private boolean wantToMore(Player player) throws IOException {
        PrintHandler.askWantToHaveMore(player);
        if(userInput.wantToMore())
            return true;
        return false;
    }

    private void giveTwoCardsToEveryOne() {
        for(int i=0; i<players.size(); i++){
            giveTwoCardsToPlayer(players.get(i));
        }
        giveTwoCardsToDealer();
    }

    private void giveTwoCardsToDealer() {
        for(int i=0; i<BASIC_CARD; i++){
            int index = makeRandomNumber();
            checkAndGiveCard(dealer, index);
        }
    }

    private void giveTwoCardsToPlayer(Player player) {
        for(int i=0; i<BASIC_CARD; i++){
            int index = makeRandomNumber();
            checkAndGiveCard(player, index);
        }
    }

    private boolean checkAndGiveCard(User user, int index) {
        if(setNotForDuplicationOfCard.contains(index)){
            index = makeRandomNumber();
            return checkAndGiveCard(user,index);
        }
        user.addCard(cards.get(index));
        setNotForDuplicationOfCard.add(index);
        return true;
    }

    private int makeRandomNumber(){ return (int)(Math.random()* RANGE_OF_CARD); }
}
