package domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.card.Card;

public abstract class User {
    private static final int ACE = 1;
    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public abstract String toString();

    public boolean isBlackJackFirst() {
        if (cardSumWithAce() == 21)
            return true;
        return false;
    }

    public boolean hasAceCard() {
        return cards.stream()
                .map(s -> s.getSymbol().getScore() == ACE)
                .collect(Collectors.toList())
                .contains(true);
    }

    public int sumOfCardWithoutAce() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getSymbol().getScore();
        }
        return sum;
    }

    public int cardSumWithAce() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getSymbol().getScore();
        }
        if (hasAceCard() & sum <= 11)
            return sum += 10;
        return sum;
    }

    public boolean isBurst() {
        return cardSumWithAce() > 21;
    }
}
