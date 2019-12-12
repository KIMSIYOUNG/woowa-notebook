package woowa.precourse.practicecourses.blackjack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import woowa.precourse.practicecourses.blackjack.domain.Card;
import woowa.precourse.practicecourses.blackjack.domain.CardFactory;

public class Test {
    public static void main(String[] args) {

        List<Card> cards = CardFactory.create();
        System.out.println(cards);
        System.out.println(cards.size());
        System.out.println(cards.get(51));
        System.out.println(cards.toString());
    }
}
