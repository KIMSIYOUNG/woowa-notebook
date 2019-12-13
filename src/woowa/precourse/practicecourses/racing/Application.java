package woowa.precourse.practicecourses.racing;

import java.io.IOException;

import woowa.precourse.practicecourses.racing.controller.GameController;

public class Application {
    public static void main(String[] args) throws IOException {
        GameController gameController = new GameController();
        gameController.play();
    }
}
