package woowa.precourse.practicecourses.basegame;

import woowa.precourse.practicecourses.basegame.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        try {
            BaseballController.play();
        } catch (Exception e) {
            System.out.println("프로그램에 에러가 있는 것 같습니다. 담당자에게 연락바랍니다(010-3002-5691)");
            e.printStackTrace();
        }
    }
}
