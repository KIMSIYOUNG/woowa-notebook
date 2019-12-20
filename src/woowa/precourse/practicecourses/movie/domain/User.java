package woowa.precourse.practicecourses.movie.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static final int ZERO = 0;

    private static User user;
    private final List<ReservedMovie> movies = new ArrayList<>();
    private int point = 1000;
    private double totalMoney = 0;

    public static User getInstance() {
        if (user == null) {
            user = new User();
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
        for (ReservedMovie movie : movies) {
            totalMoney += movie.calculateTotalMoney();
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
        if(movies.stream().anyMatch(s->s.isOneHourWithinRange(playSchedule)))
            return false;
        return true;
    }
}
