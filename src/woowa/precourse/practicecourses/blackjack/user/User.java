package woowa.precourse.practicecourses.blackjack.user;

import java.util.ArrayList;
import java.util.List;

import woowa.precourse.practicecourses.blackjack.domain.Card;
import woowa.precourse.practicecourses.blackjack.domain.Symbol;

public class User {
    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int sumOfCardToAdd(){
        int sum = 0;
        for (Card card : cards) {
            sum += card.getSymbol().getScore();
        }
        return sum;
    }

    public int sumOfCard() {
        int sum = 0;
        if (cards.contains(Symbol.ACE)) {
            sum += sumWithAce(sum);
        }
        for (Card card : cards) {
            sum += card.getSymbol().getScore();
        }
        return sum;
    }


    private int sumWithAce(int sum) {
        Card ace = cards.remove(cards.indexOf(Symbol.ACE));
        for (Card card : cards) {
            sum += card.getSymbol().getScore();
        }
        if (sum <= 10)
            sum += 11;
        if (sum >= 11)
            sum += 1;
        cards.add(ace);
        return sum;
    }
}
