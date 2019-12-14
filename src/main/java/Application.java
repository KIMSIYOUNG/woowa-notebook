import java.io.IOException;

import controller.GameController;
import io.PrintHandler;

public class Application {
    public static void main(String[] args) throws IOException {
        try {
            GameController.start();
        } catch (Exception e) {
            PrintHandler.printSystemError();
            e.printStackTrace();
        }
    }
}
