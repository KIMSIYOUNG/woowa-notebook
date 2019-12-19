package woowa.precourse.practicecourses.movie.view;

import java.util.List;

import woowa.precourse.practicecourses.movie.domain.Movie;
import woowa.precourse.practicecourses.movie.domain.User;

public class OutputView {

    private static final String START_PAYMENT = "결제를 시작합니다. 아래에 예약한 영화들이 표기됩니다.";
    private static final String PRINT_TOTAL_MONEY = "감사합니다 최종적으로 결제한 금액은 : ";
    private static final String 입니다 = "입니다";
    private static final String ERROR_TIME = "기존에 예매했던 영화와 시간차이가 1시간 이하입니다.";


    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    public static void printStartPayment() {
        System.out.println(START_PAYMENT);
    }

    public static void printReservedMovies(User user) {
        System.out.println(user.toString());
    }

    public static void printTotalMoney(double totalPrice) {
        System.out.println(PRINT_TOTAL_MONEY + totalPrice + 입니다);
    }

    public static void printErrorOfTime() {
        System.out.println(ERROR_TIME);
    }
}
