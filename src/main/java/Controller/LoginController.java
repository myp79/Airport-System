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
        forgotPasswordTBtn();
    }

    public void submitBtn() {
        loginView.getSubmit().setOnAction(actionEvent -> {
            String username = loginView.getUsername().getText();
            String userRoll = Database.check(loginView.getUsername().getText(), loginView.getPassword().getText());
            if (userRoll != null) {
                switch (userRoll) {
                    case "admin":
                    case "manager":
                        ManagerController managerController = new ManagerController(userRoll);
                        managerController.setUsername(username);
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

    public void forgotPasswordTBtn() {
        loginView.getForgotPassword().setOnAction(actionEvent -> {
            ForgotPasswordController forgotPasswordController = new ForgotPasswordController();
            loginView.getScene().setRoot(forgotPasswordController.getForgotPassword());
        });

    }


    public LoginView getLoginView() {
        return loginView;
    }
}
