package woowa.precourse.practicecourses.baseball.io;

public class PrintHandler {
    private static final String ERROR_IN_PROGRAM = "프로그램 내부에 에러가 발생하였습니다. 조치 후 다시 실행 해주세요.";
    private static final String INPUT_USER_NUMBER = "세수를 입력하세요 : ";
    private static final String ERROR_USER_INPUT = "입력 포맷이 잘못되었습니다. 다시 입력 해 주세요!";
    private static final String ERROR_INPUT_DUPLICATION = "각 자리수마다 다른 수를 입력 해 주세요.";
    private static final int ZERO = 0;

    public static void errorInProgram() {
        System.out.println(ERROR_IN_PROGRAM);
    }

    public static void inputUserNumber() {
        System.out.print(INPUT_USER_NUMBER);
    }

    public static void errorUserInput() {
        System.out.println(ERROR_USER_INPUT);
    }

    public static void errorInputDuplication() {
        System.out.println(ERROR_INPUT_DUPLICATION);
    }

    public static void printCompareResult(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if(strike > ZERO)
            sb.append("STRIKE : "+ strike);
        if(ball > ZERO)
            sb.append(" BALL : "+ ball);
        if(strike == ZERO && ball ==ZERO)
            sb.append("NOTHING");
        System.out.println(sb.toString());
    }

}
