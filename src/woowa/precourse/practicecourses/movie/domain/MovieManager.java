package woowa.precourse.practicecourses.movie.domain;

import java.util.List;

public class MovieManager {
    private List<Movie> movies;

    public MovieManager(List<Movie> movies) {
        this.movies = movies;
    }

    public Movie getMovieFromId(int id) {
        return movies.stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .get();
    }

    public PlaySchedule getPlayScheduleFromIdAndTime(int id, int time) {
        Movie movieFromId = getMovieFromId(id);
        return movieFromId.getPlaySchedules().get(time);
    }
}
