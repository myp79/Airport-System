package Controller;

import Model.Database;
import View.ForgotPassword;
import javafx.scene.control.Alert;

public class ForgotPasswordController {

    private ForgotPassword forgotPassword;

    public ForgotPasswordController() {
        forgotPassword = new ForgotPassword();
        submitBtn();
    }

    public void submitBtn() {
        forgotPassword.getSubmit().setOnAction(actionEvent -> {
            String username = forgotPassword.getUsername().getText();
            String email = forgotPassword.getEmail().getText();
            if (email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])")) {
                String password = Database.forgotPassword(username, email);
                if (password != null) {
                    LoginController loginController = new LoginController();
                    loginController.getLoginView().getPassword().setText(password);
                    forgotPassword.getScene().setRoot(loginController.getLoginView());
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Database Error");
                    alert.setContentText("User doesn't exist. Check username and email.");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Email Error");
                alert.setContentText("Email has wrong pattern. Check it.");
                alert.show();
            }
        });
    }

    public ForgotPassword getForgotPassword() {
        return forgotPassword;
    }
}
