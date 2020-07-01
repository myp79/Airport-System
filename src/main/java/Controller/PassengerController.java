package Controller;

import View.PassengerView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PassengerController {
    private PassengerView passengerView;
    private String username;

    public PassengerController() {
        passengerView = new PassengerView();
        changeProfile();
    }

    public void changeProfile() {
        passengerView.getProfile().setOnAction(actionEvent -> {
            ChangeProfileController changeProfileController = new ChangeProfileController();
            changeProfileController.setUsername(username);
            Stage stage = new Stage();
            stage.setScene(new Scene(changeProfileController.getChangeProfileView()));
            stage.show();
        });

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PassengerView getPassengerView() {
        return passengerView;
    }
}
