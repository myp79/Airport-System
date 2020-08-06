package Controller;

import View.EmployeeView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeeController {
    private EmployeeView employeeView;
    private String username;

    public EmployeeController() {
        employeeView = new EmployeeView();
        changeProfile();
        massageBtn();
        flightBtn();
    }

    public void changeProfile() {
        employeeView.getProfile().setOnAction(actionEvent -> {
            ChangeProfileController changeProfileController = new ChangeProfileController();
            changeProfileController.setUsername(username);
            Stage stage = new Stage();
            stage.setScene(new Scene(changeProfileController.getChangeProfileView()));
            stage.show();
        });

    }

    public void massageBtn() {
        employeeView.getMassage().setOnAction(actionEvent -> {
            MassageController massageController = new MassageController();
            massageController.setUsername(username);
            Stage stage = new Stage();
            stage.setScene(new Scene(massageController.getMassageView()));
            stage.show();
        });
    }

    public void flightBtn() {
        employeeView.getFlightManage().setOnAction(actionEvent -> {
            FlightManagerController flightManagerController = new FlightManagerController();
            Stage stage = new Stage();
            stage.setScene(new Scene(flightManagerController.getFlightManager()));
            stage.show();
        });
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EmployeeView getEmployeeView() {
        return employeeView;
    }
}
