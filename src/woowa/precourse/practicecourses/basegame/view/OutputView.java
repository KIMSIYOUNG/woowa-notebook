package woowa.precourse.practicecourses.basegame.view;

import woowa.precourse.practicecourses.basegame.domain.Count;

public class OutputView {
    private static final int ZERO = 0;
    private static final String CONGRATULATION = "축하합니다 세자리 수를 모두 맞히셨습니다.";

    public static void printCompareResult() {
        StringBuilder sb = new StringBuilder();
        if (Count.STRIKE.getCount() > ZERO)
            sb.append("STRIKE : " + Count.STRIKE.getCount() + " ");
        if (Count.BALL.getCount() > ZERO)
            sb.append("BALL : " + Count.BALL.getCount());
        if (Count.BALL.getCount() == ZERO && Count.STRIKE.getCount() == ZERO)
            sb.append("NOTHING");
        System.out.println(sb.toString());
    }

    public static void printCongratulation() {
        System.out.println(CONGRATULATION);
    }
}
