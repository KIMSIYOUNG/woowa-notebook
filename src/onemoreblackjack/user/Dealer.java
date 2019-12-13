package onemoreblackjack.user;

import java.util.List;

import onemoreblackjack.domain.Card;
import woowa.precourse.practicecourses.blackjack.domain.Symbol;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer extends User {

    public Dealer() {
    }

    @Override
    public String toString(){
        return "딜러의 카드 : " + super.toString() + " 결과 : "+ sumOfCard();
    }

    @Override
    public int sumOfCardToAdd(){
        List<Card> cards = super.getCards();
        for(int i=0; i<cards.size(); i++){
            if(cards.get(i).getSymbol().equals(Symbol.ACE))
                return super.sumOfCardToAdd()+10;
        }
        return super.sumOfCardToAdd();
    }
}
