package woowa.precourse.practicecourses.movie.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import woowa.precourse.practicecourses.movie.domain.Movie;
import woowa.precourse.practicecourses.movie.domain.Payment;
import woowa.precourse.practicecourses.movie.domain.PlaySchedule;
import woowa.precourse.practicecourses.movie.domain.User;
import woowa.precourse.practicecourses.movie.utils.YesOrNo;

public class InputView {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final String ERROR_FORMAT = "잘못된 형식의 입력입니다.";
    private static final String ERROR_NO_ID = "영화 아이디가 존재하지 않습니다.";
    private static final String INPUT_MOVIE_NUMBER = "예약할 시간표를 선택하세요.(위에서부터 0번)";
    private static final String ERROR_MOVIE_NUMBER = "존재하지 않는 시간대입니다.";
    private static final String INPUT_HOW_MANY = "에약할 인원을 입력하세요.";
    private static final String ERROR_OVER_PEOPLE = "예약인원 초과입니다.";
    private static final String INPUT_MORE_RESERVATION = "예약을 종료하고 결제를 진행하려면 1번을, 추가예약을 진행하려면 2번을 입력해주세요.";
    private static final String INPUT_HOW_MUCH_POINT = "포인트 사용 금액을 입력하세요. 포인트가 없으면 0을 입력";
    private static final String ERROR_OVER_POINT = "사용할 수 있는 포인트를 초과하였습니다. 현재 보유 포인트 : ";
    private static final String INPUT_CREDIT_OR_CASH = "신용카드는 1번, 현금은 2번을 입력해주세요. (할인율은 신용카드 5프로, 현금 3프로입니다)";
    private static final int CREDIT_CARD = 1;
    private static final int CASH = 2;
    private static final String ERROR_PAYMENT = "결제수단은 1번(신용카드) 2번(현금)으로만 선택해주세요.";
    private static final int ZERO = 0;
    private static List<Movie> movies;

    public InputView(List<Movie> movies) {
        this.movies = movies;
    }

    public int inputMovieId() throws IOException {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            return checkMovieId(Integer.parseInt(BR.readLine().trim()));
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputMovieId();
        }
    }

    private int checkMovieId(int parseInt) throws IOException {
        List<Integer> movieIds = new ArrayList<>();
        for (Movie movie : movies) {
            movieIds.add(movie.getId());
        }
        if (movieIds.contains(parseInt))
            return parseInt;
        System.out.println(ERROR_NO_ID);
        return inputMovieId();
    }

    public int inputMovieNumber(int movieId) throws IOException {
        try {
            System.out.println(INPUT_MOVIE_NUMBER);
            return checkScheduleIndex(Integer.parseInt(BR.readLine().trim()), movieId);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputMovieNumber(movieId);
        }
    }

    private int checkScheduleIndex(int userInput, int movieId) throws IOException {
        if (getMovieFromMovieId(movieId).getPlaySchedules().size() > userInput)
            return userInput;
        System.out.println(ERROR_MOVIE_NUMBER);
        return inputMovieId();
    }

    private Movie getMovieFromMovieId(int movieId) {
        Movie idEqualMovie = null;
        for (Movie movie : movies) {
            idEqualMovie = checkUserInputIdAndMovieId(movieId, idEqualMovie, movie);
        }
        return idEqualMovie;
    }

    private Movie checkUserInputIdAndMovieId(int movieId, Movie idEqualMovie, Movie movie) {
        if (movie.getId() == movieId) {
            idEqualMovie = movie;
        }
        return idEqualMovie;
    }

    public int inputHowMany(int movieId, int movieNumber) throws IOException {
        try {
            System.out.println(INPUT_HOW_MANY);
            return checkCanReserve(Integer.parseInt(BR.readLine().trim()), movieId, movieNumber);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputHowMany(movieId, movieNumber);
        }

    }

    private int checkCanReserve(int howMany, int movieId, int movieNumber) throws IOException {
        List<PlaySchedule> playSchedules = getMovieFromMovieId(movieId).getPlaySchedules();
        if (playSchedules.get(movieNumber).canReserve(howMany))
            return howMany;
        System.out.println(ERROR_OVER_PEOPLE);
        return inputHowMany(movieId, movieNumber);
    }

    public boolean inputMoreReserve() throws IOException {
        try {
            System.out.println(INPUT_MORE_RESERVATION);
            return new YesOrNo(Integer.parseInt(BR.readLine().trim())).isYes();
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputMoreReserve();
        }

    }

    public int inputHowMuchPointUse() throws IOException {
        try {
            System.out.println(INPUT_HOW_MUCH_POINT);
            return checkCanUseTheMoney(Integer.parseInt(BR.readLine().trim()));
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputHowMuchPointUse();
        }
    }

    private int checkCanUseTheMoney(int parseInt) throws IOException {
        User user = User.getInstance();
        if (user.canUseThePoint(parseInt)) {
            return parseInt;
        }
        System.out.println(ERROR_OVER_POINT + user.getPoint());
        return inputHowMuchPointUse();
    }

    public Payment inputCreditCardOrCash() throws IOException {
        try {
            System.out.println(INPUT_CREDIT_OR_CASH);
            return checkThisIsOneOrTwo(Integer.parseInt(BR.readLine().trim()));
        } catch (NumberFormatException e) {
            System.out.println(ERROR_FORMAT);
            return inputCreditCardOrCash();
        }
    }

    private Payment checkThisIsOneOrTwo(int payment) throws IOException {
        if (payment != CREDIT_CARD && payment != CASH) {
            System.out.println(ERROR_PAYMENT);
            return inputCreditCardOrCash();
        }
        if (payment == CREDIT_CARD)
            return Payment.CREDIT_CARD;
        return Payment.CASH;
    }
}
