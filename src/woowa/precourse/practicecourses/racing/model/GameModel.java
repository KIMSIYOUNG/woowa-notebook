package woowa.precourse.practicecourses.racing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import woowa.precourse.practicecourses.racing.domain.Car;
import woowa.precourse.practicecourses.racing.io.PrintHandler;

public class GameModel {
    private static final String BLANK = "";
    private static List<Car> userCars = new ArrayList<>();
    private static int howMany;

    public GameModel(List<String> userNames, int howManyTimes) {
        howMany = howManyTimes;
        userCars = userNames.stream().map(s -> new Car(s)).collect(Collectors.toList());
    }

    public void gamePlay() {
        PrintHandler.notifyResult();
        for (int i = 0; i < howMany; i++) {
            getEachCarPosition();
            System.out.println(BLANK);
        }
    }

    public void getResult() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car userCar : userCars) {
            isMaxPosition(winners, maxPosition, userCar);
        }
        PrintHandler.printWinner(winners);
    }

    private void isMaxPosition(List<String> winners, int maxPosition, Car userCar) {
        if (userCar.isMaxPosition(maxPosition))
            winners.add(userCar.getName());
    }

    private void getEachCarPosition() {
        for (Car userCar : userCars) {
            userCar.checkGoOrStop();
            PrintHandler.printCarNameAndPosition(userCar);
        }
    }

    private int getMaxPosition() {
        List<Integer> listForMasPosition = new ArrayList<>();
        for (Car userCar : userCars) {
            listForMasPosition.add(userCar.getPosition());
        }
        return Collections.max(listForMasPosition);
    }
}
