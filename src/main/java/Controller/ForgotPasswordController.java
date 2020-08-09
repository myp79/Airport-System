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
        });
    }

    public ForgotPassword getForgotPassword() {
        return forgotPassword;
    }
}
