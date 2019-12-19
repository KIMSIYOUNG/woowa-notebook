package woowa.precourse.practicecourses.movie.domain;

import java.time.LocalDateTime;

import static woowa.precourse.practicecourses.movie.utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public boolean canReserve(int howMany){
        return capacity >= howMany;
    }

    public void decreaseCapacity(int howMany){
        capacity -= howMany;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    public String getScheduleInfo(){
        return "시작시간: " + format(startDateTime);
    }
}
