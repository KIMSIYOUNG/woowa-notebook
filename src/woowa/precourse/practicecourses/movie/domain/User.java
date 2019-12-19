package woowa.precourse.practicecourses.movie.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private static final int ZERO = 0;

    private static User user;
    private List<ReservedMovie> movies = new ArrayList<>();
    private int point = 1000;
    private double totalMoney = 0;

    public static User getInstance() {
        if (Objects.isNull(user)) {
            return new User();
        }
        return user;
    }

    public void addMovie(ReservedMovie reservedMovie) {
        movies.add(reservedMovie);
    }

    public void usePoint(int howMuch) {
        point -= howMuch;
        totalMoney -= howMuch;
    }

    public double getTotalPrice(Payment payment) {
        for (int i = 0; i < movies.size(); i++) {
            totalMoney += movies.get(i).calculateTotalMoney();
        }
        totalMoney = payment.totalPriceWithDiscount(totalMoney);
        return totalMoney;
    }

    public boolean canUseThePoint(int parseInt) {
        if (parseInt >= ZERO && parseInt <= point)
            return true;
        return false;
    }

    public int getPoint() {
        return point;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ReservedMovie reservedMovie : movies) {
            sb.append(reservedMovie.toString());
        }
        return sb.toString();
    }

    public boolean canReserve(PlaySchedule playSchedule) {
        List<Boolean> list = new ArrayList<>();
        for (ReservedMovie reservedMovie : movies) {
            list.add(reservedMovie.isOneHourWithinRange(playSchedule));
        }
        if (movies.size() == 0) {
            return true;
        }
        return !list.contains(true);
    }
}
