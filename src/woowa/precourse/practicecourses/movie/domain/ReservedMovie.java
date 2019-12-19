package woowa.precourse.practicecourses.movie.domain;

import woowa.precourse.practicecourses.movie.utils.DateTimeUtils;

public class ReservedMovie {
    private static final String NEW_LINE = "\n";
    private Movie movie;
    private PlaySchedule playSchedule;
    private int count;

    public ReservedMovie(Movie movie, PlaySchedule playSchedule, int count) {
        this.movie = movie;
        this.playSchedule = playSchedule;
        this.count = count;
    }

    public boolean isOneHourWithinRange(PlaySchedule otherPlaySchedule) {
        return DateTimeUtils.isOneHourWithinRange(playSchedule.getStartDateTime(), otherPlaySchedule.getStartDateTime());
    }

    public int calculateTotalMoney() {
        return movie.getPrice() * count;
    }

    @Override
    public String toString() {
        return movie.getMovieInfo() + playSchedule.getScheduleInfo()
                + " 예약된 인원 : " + count + NEW_LINE;
    }

}
