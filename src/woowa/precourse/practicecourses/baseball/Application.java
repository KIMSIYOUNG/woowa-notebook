package woowa.precourse.practicecourses.baseball;

import woowa.precourse.practicecourses.baseball.controller.GameController;
import woowa.precourse.practicecourses.baseball.io.PrintHandler;

public class Application {
    public static void main(String[] args) {
        try{
            GameController.play();
        }catch (Exception e){
            PrintHandler.errorInProgram();
        }
    }
}
