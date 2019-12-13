package woowa.precourse.practicecourses.racing.io;

import java.util.List;

import woowa.precourse.practicecourses.racing.domain.Car;

public class PrintHandler {
    private static final String INPUT_USER_NAMES_TO_PLAY = "경주 할 자동차의 이름을 입력하세요";
    private static final String ERROR_USER_NAMES = "유저는 1명이상이어야 하며, 한글자 이상 이름을 입력하셔야 합니다.";
    private static final String INPUT_HOW_MANY = "시도할 회수는 몇회인가요?";
    private static final String ERROR_INPUT_ZERO = "0은 입력할 수 없습니다.";
    private static final String ERROR_INPUT_HOW_MANY = "입력이 잘못되었습니다. 1이상의 자연수로 다시 입력해주세요.";
    private static final String RESULT = "실행 결과";
    private static final String WINNER_IS = "우승자는 : ";
    private static final String END = "입니다~! 축하드립니다.!!";
    private static final String BLANK = " ";
    private static final String COLON = " : ";
    private static final String DASH_FOR_POSITION = "-";

    public static void inputUserNames() {
        System.out.println(INPUT_USER_NAMES_TO_PLAY);
    }

    public static void errorUserNames() {
        System.out.println(ERROR_USER_NAMES);
    }

    public static void inputHowMany() {
        System.out.println(INPUT_HOW_MANY);
    }

    public static void errorInputZero() {
        System.out.println(ERROR_INPUT_ZERO);
    }

    public static void errorInputHowMany() {
        System.out.println(ERROR_INPUT_HOW_MANY);
    }

    public static void printCarNameAndPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName()).append(COLON);
        for (int i = 0; i < car.getPosition(); i++) {
            sb.append(DASH_FOR_POSITION);
        }
        System.out.println(sb.toString());
    }

    public static void notifyResult() {
        System.out.println(RESULT);
    }

    public static void printWinner(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNER_IS);
        for (String winner : winners)
            sb.append(winner).append(BLANK);
        sb.append(END);
        System.out.println(sb.toString());
    }
}
