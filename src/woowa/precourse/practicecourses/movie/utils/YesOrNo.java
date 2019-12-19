package woowa.precourse.practicecourses.movie.utils;

import java.util.Objects;

public class YesOrNo {
    private final int value;

    public YesOrNo(int value) {
        if (Objects.isNull(value))
            throw new IllegalArgumentException("값은 Null이 될 수 없습니다.");
        if (value != 1 && value != 2)
            throw new IllegalArgumentException("값은 1또는 2여야 합니다.");
        this.value = value;
    }

    public boolean isYes() {
        return value == 2;
    }
}
