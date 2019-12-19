package woowa.precourse.practicecourses.movie;

import java.io.IOException;

import woowa.precourse.practicecourses.movie.controller.GameController;

public class Application {
    public static void main(String[] args) throws IOException {
        try {
            GameController.play();
        } catch (Exception e) {
            System.out.println("프로그램에 이상이 있는 것 같습니다. 담당자에게 연락주세요(010,3002,5691");
        }

        // TODO 구현 진행
    }
}
