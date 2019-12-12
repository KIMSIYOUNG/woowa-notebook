package woowa.precourse.practicecourses.blackjack.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class CardFactoryTest {

    @Test
    public void CardFactoryTest(){
        List<Card> cards = CardFactory.create();
        for(Card c : cards){
            System.out.println(c);
        }
    }

}