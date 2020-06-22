import Controller.LoginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        LoginController loginController = new LoginController();
        Scene scene = new Scene(loginController.getLoginView());
        stage.setScene(scene);
        stage.show();
    }
}
