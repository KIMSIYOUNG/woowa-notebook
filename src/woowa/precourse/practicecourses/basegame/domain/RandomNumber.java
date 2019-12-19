package woowa.precourse.practicecourses.basegame.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class RandomNumber {
    private static int randomNumber = 0;
    private static final int RANGE = 9;
    private static final int START_FROM = 1;
    private static final int THREE = 3;

    public static int create() {
        Set<Integer> set = new HashSet<>();
        while (!(set.size() == THREE)) {
            set.add((int) (Math.random() * RANGE + START_FROM));
        }
        randomNumber = setToNumber(set);
        return randomNumber;
    }

    private static int setToNumber(Set<Integer> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            sb.append((iterator.next()));
        }
        return Integer.parseInt(sb.toString());
    }

}
