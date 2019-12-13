package woowa.precourse.practicecourses.racing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import woowa.precourse.practicecourses.racing.domain.Car;
import woowa.precourse.practicecourses.racing.io.PrintHandler;

public class GameModel {
    private static final String BLANK = "";
    private static ArrayList<Car> userCars = new ArrayList<>();
    private static int howMany;

    public GameModel(List<String> userNames, int howManyTimes) {
        howMany = howManyTimes;
        for (String userName : userNames) {
            userCars.add(new Car(userName));
        }
    }

    public void gamePlay() {
        PrintHandler.notifyResult();
        for (int i = 0; i < howMany; i++) {
            getEachCarPosition();
            System.out.println(BLANK);
        }
    }

    private void getEachCarPosition() {
        for (int j = 0; j < userCars.size(); j++) {
            userCars.get(j).checkGoOrStop();
            PrintHandler.printCarNameAndPosition(userCars.get(j));
        }
    }

    public void getResult() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (int i = 0; i < userCars.size(); i++) {
            whoIsTheSameAsMaxPosition(winners, maxPosition, i);
        }
        PrintHandler.printWinner(winners);
    }

    private void whoIsTheSameAsMaxPosition(List<String> winners, int maxPosition, int i) {
        if (maxPosition == userCars.get(i).getPosition())
            winners.add(userCars.get(i).getName());
    }

    private int getMaxPosition() {
        List<Integer> listForMasPosition = new ArrayList<>();
        for (int i = 0; i < userCars.size(); i++) {
            listForMasPosition.add(userCars.get(i).getPosition());
        }
        return Collections.max(listForMasPosition);
    }
}
