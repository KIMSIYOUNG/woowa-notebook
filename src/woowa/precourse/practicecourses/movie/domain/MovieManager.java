package woowa.precourse.practicecourses.movie.domain;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies = new ArrayList<>();

    public MovieManager(List<Movie> movies) {
        this.movies = movies;
    }

    public Movie getMovieFromId(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id)
                return movie;
        }
        throw new IllegalArgumentException("아이디가 존재하지 않습니다.");
    }

    public PlaySchedule getPlayScheduleFromIdAndTime(int id, int time) {
        Movie movieFromId = getMovieFromId(id);
        return movieFromId.getPlaySchedules().get(time);
    }
}
