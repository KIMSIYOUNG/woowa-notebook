package woowa.precourse.practicecourses.movie.controller;

import java.io.IOException;
import java.util.List;

import woowa.precourse.practicecourses.movie.domain.Movie;
import woowa.precourse.practicecourses.movie.domain.MovieRepository;
import woowa.precourse.practicecourses.movie.model.MovieModel;

public class GameController {
    public static void play() throws IOException {
        List<Movie> movies = MovieRepository.getMovies();
        MovieModel gameModel = new MovieModel(movies);
        gameModel.startReservation();
    }
}
