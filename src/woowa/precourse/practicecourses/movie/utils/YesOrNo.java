package woowa.precourse.practicecourses.movie.utils;

import java.util.Objects;

public class YesOrNo {
    private static final int STOP_AND_PAY = 1;
    private static final int MORE_RESERVATION = 2;
    private final int value;

    public YesOrNo(int value) {
        if (Objects.isNull(value))
            throw new IllegalArgumentException("값은 Null이 될 수 없습니다.");
        if (value != STOP_AND_PAY && value != MORE_RESERVATION)
            throw new IllegalArgumentException("값은 1또는 2여야 합니다.");
        this.value = value;
    }

    public boolean isYes() {
        return value == MORE_RESERVATION;
    }
}
