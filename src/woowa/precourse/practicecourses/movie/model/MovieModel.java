package woowa.precourse.practicecourses.movie.model;

import java.io.IOException;
import java.util.List;

import woowa.precourse.practicecourses.movie.domain.*;
import woowa.precourse.practicecourses.movie.view.InputView;
import woowa.precourse.practicecourses.movie.view.OutputView;

public class MovieModel {
    private static List<Movie> movies;
    private static InputView inputView;
    private static User user;

    public MovieModel(List<Movie> movies) {
        this.movies = movies;
        inputView = new InputView(movies);
        user = User.getInstance();
    }


    public void startReservation() throws IOException {
        do {
            OutputView.printMovies(movies);
            int movieId = inputView.inputMovieId();
            int movieNumber = inputView.inputMovieNumber(movieId);
            int howMany = inputView.inputHowMany(movieId, movieNumber);
            checkAndAddToReserveList(movieId, movieNumber, howMany);
        } while (inputView.inputMoreReserve());
        startPayment();
    }

    private void startPayment() throws IOException {
        OutputView.printStartPayment();
        OutputView.printReservedMovies(user);
        int point = inputView.inputHowMuchPointUse();
        user.usePoint(point);
        Payment payment = inputView.inputCreditCardOrCash();
        OutputView.printTotalMoney(user.getTotalPrice(payment));

    }

    private boolean checkAndAddToReserveList(int movieId, int movieNumber, int howMany) {
        MovieManager movieManager = new MovieManager(movies);
        Movie movie = movieManager.getMovieFromId(movieId);
        PlaySchedule playSchedule = movieManager.getPlayScheduleFromIdAndTime(movieId, movieNumber);
        if (user.canReserve(playSchedule)) {
            user.addMovie(new ReservedMovie(movie, playSchedule, howMany));
            playSchedule.decreaseCapacity(howMany);
            return true;
        }
        OutputView.printErrorOfTime();
        return false;
    }
}
