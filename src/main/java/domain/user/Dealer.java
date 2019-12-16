package domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.card.Card;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private static final int ACE = 1;
    private final List<Card> cards = new ArrayList<>();


    public Dealer() {
    }

    // TODO 추가 기능 구현

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

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

    /**
     * 카드를 추가로 받는 경우, 에이스가 포함되어 11로 계산하게 되면 받을 수 없지만(21을 초과하여) 1로 계산한다면 받을 수 있는 경우를
     * 고려해서 에이스를 1로 간주하여 계산하는 메서드
     * @return 에이스를 1로 간주하여 합한 값
     */
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

    @Override
    public String toString() {
        return "딜러님의 카드 : " + getCards().toString();
    }
}
