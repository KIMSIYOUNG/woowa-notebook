package woowa.precourse.practicecourses.blackjack.user;

import java.util.ArrayList;
import java.util.List;

import woowa.precourse.practicecourses.blackjack.domain.Card;
import woowa.precourse.practicecourses.blackjack.domain.Symbol;

/**
 * 게임 참여자를 의미하는 객체
 */
public class Player extends User {
    private final String name;
    private final double bettingMoney;
    private final List<Card> cards = new ArrayList<>();

    public Player(String name, double bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
    }


    // TODO 추가 기능 구현

    public String getName() {
        return name;
    }

    public double getBettingMoney() {
        return bettingMoney;
    }

    public String toString() {
        String result = name + "의 카드 : ";
        for(int i=0;i<cards.size(); i++){
            result += cards.get(i).toString() + " ";
        }
        return result;

    }


}
