package onemoreblackjack.user;

import java.util.ArrayList;
import java.util.List;

import onemoreblackjack.domain.Card;
import onemoreblackjack.domain.Symbol;

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
        for (int i = 0; i < cards.size(); i++) {
            sum += cards.get(i).getSymbol().getScore();
        }
        return sum;
    }

    public int sumOfCard() {
        int sum = 0;
        for(int i=0; i<cards.size(); i++){
            if(cards.get(i).getSymbol().equals(Symbol.ACE)){
                sum += sumWithAce(cards.get(i));
                break;
            }
        }
        for (int i = 0; i < cards.size(); i++) {
            sum += cards.get(i).getSymbol().getScore();
        }
        return sum;
    }

    private int sumWithAce(Card card) {
        cards.remove(card);
        int sum = 0;
        for (int i = 0; i < cards.size(); i++) {
            sum += cards.get(i).getSymbol().getScore();
        }
        if (sum <= 10)
            sum += 11;
        if (sum >= 11)
            sum += 1;
        cards.add(card);
        return sum;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cards.size(); i++){
            sb.append(cards.get(i).toString()).append(" ");
        }
        return sb.toString();
    }
}
