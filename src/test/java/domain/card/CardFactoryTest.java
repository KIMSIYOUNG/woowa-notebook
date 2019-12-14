package domain.card;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardFactoryTest {
    @Test
    void create() {
        List<Card> cards = CardFactory.create();
        assertThat(cards).hasSize(52);
        System.out.println(cards);
        System.out.println(cards.get(1).getSymbol().getScore());
        System.out.println(cards.get(1).getSymbol());
        System.out.println(cards.get(1).getType());
    }
}