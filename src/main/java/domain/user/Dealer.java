package domain.user;

/**
 * 게임 딜러를 의미하는 객체
 */
public class Dealer extends User{

    public Dealer() {}

    // TODO 추가 기능 구현

    @Override
    public String toString() {
        return "딜러님의 카드 : " +super.getCards().toString();
    }
}
