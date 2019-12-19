package woowa.precourse.practicecourses.basegame.domain;

public enum Count {
    STRIKE,
    BALL;

    private int count;

    public static void initialize() {
        STRIKE.count = 0;
        BALL.count = 0;
    }

    public void addStrike() {
        STRIKE.count++;
    }

    public void addBall() {
        BALL.count++;
    }

    public int getCount() {
        return count;
    }
}
