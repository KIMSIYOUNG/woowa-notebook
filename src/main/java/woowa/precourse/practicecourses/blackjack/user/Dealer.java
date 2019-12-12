package woowa.precourse.practicecourses.blackjack.user;

import java.util.ArrayList;
import java.util.List;

import woowa.precourse.practicecourses.blackjack.domain.Card;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer {
    private final List<Card> cards = new ArrayList<>();

    public Dealer() {}

    public void addCard(Card card) {
        cards.add(card);
    }

    // TODO 추가 기능 구현
}
