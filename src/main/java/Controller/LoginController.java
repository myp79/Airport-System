package Controller;

import Model.Database;
import View.LoginView;
import javafx.scene.control.Alert;

public class LoginController {
    private LoginView loginView;

    public LoginController() {
        loginView = new LoginView();
        submitBtn();
        signUp();
    }

    public void submitBtn() {
        String username = loginView.getUsername().getText();
        loginView.getSubmit().setOnAction(actionEvent -> {
            String userRoll = Database.check(loginView.getUsername().getText(), loginView.getPassword().getText());
            if (userRoll != null) {
                switch (userRoll) {
                    case "admin":
                    case "manager":
                        ManagerController managerController = new ManagerController();
                        managerController.setUsername(username);
                        managerController.setRoll(userRoll);
                        loginView.getScene().setRoot(managerController.getManagerView());
                        break;
                    case "employee":
                        EmployeeController employeeController = new EmployeeController();
                        employeeController.setUsername(username);
                        loginView.getScene().setRoot(employeeController.getEmployeeView());

                        break;
                    case "passenger":
                        PassengerController passengerController = new PassengerController();
                        passengerController.setUsername(username);
                        loginView.getScene().setRoot(passengerController.getPassengerView());
                        break;
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Database Error");
                alert.setContentText("User doesn't exist. Check username and password.");
                alert.show();
            }
        });
    }

    public void signUp() {
        loginView.getSignUp().setOnAction(actionEvent -> {
            SignUpController signUpController = new SignUpController();
            loginView.getScene().setRoot(signUpController.getSignUpView());
        });
    }


    public LoginView getLoginView() {
        return loginView;
    }
}
