package Controller;

import View.ManagerView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerController {
    private ManagerView managerView;
    private String username;

    public ManagerController(String roll) {
        managerView = new ManagerView();
        if (roll.equals("admin")) {
            managerView.getBtnGroup().getChildren().addAll(managerView.getManger());
        }
        changeProfile();
        managerBtn();
        employeeBtn();
        passengerBtn();
        flightBtn();
        massageBtn();
        airplaneBtn();
    }

    public void changeProfile() {
        managerView.getProfile().setOnAction(actionEvent -> {
            ChangeProfileController changeProfileController = new ChangeProfileController();
            changeProfileController.setUsername(username);
            Stage stage = new Stage();
            stage.setScene(new Scene(changeProfileController.getChangeProfileView()));
            stage.show();
        });
    }

    public void managerBtn() {
        managerView.getManger().setOnAction(actionEvent -> {
            ManagerManageController managerManageController = new ManagerManageController();
            Stage stage = new Stage();
            stage.setScene(new Scene(managerManageController.getManagerManage()));
            stage.show();
        });
    }

    public void employeeBtn() {
        managerView.getEmployeeManage().setOnAction(actionEvent -> {
            EmployeeManageController employeeManageController = new EmployeeManageController();
            Stage stage = new Stage();
            stage.setScene(new Scene(employeeManageController.getEmployeeManage()));
            stage.show();
        });

    }

    public void passengerBtn() {
        managerView.getPassengerManage().setOnAction(actionEvent -> {
            PassengerManageController passengerManageController = new PassengerManageController();
            Stage stage = new Stage();
            stage.setScene(new Scene(passengerManageController.getPassengerManage()));
            stage.show();
        });
    }

    public void flightBtn() {
        managerView.getFlightManage().setOnAction(actionEvent -> {
            FlightManagerController flightManagerController = new FlightManagerController();
            Stage stage = new Stage();
            stage.setScene(new Scene(flightManagerController.getFlightManager()));
            stage.show();
        });
    }

    public void massageBtn() {
        managerView.getMassage().setOnAction(actionEvent -> {
            MassageManageController massageManageController = new MassageManageController();
            Stage stage = new Stage();
            stage.setScene(new Scene(massageManageController.getMassageManage()));
            stage.show();
        });
    }

    public void airplaneBtn() {
        managerView.getAirplane().setOnAction(actionEvent -> {
            AirplaneManageController airplaneManageController = new AirplaneManageController();
            Stage stage = new Stage();
            stage.setScene(new Scene(airplaneManageController.getAirplaneManage()));
            stage.show();
        });
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ManagerView getManagerView() {
        return managerView;
    }
}
