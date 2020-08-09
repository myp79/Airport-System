package Controller;

import Model.Database;
import View.ChangeProfileView;
import javafx.scene.control.Alert;

public class ChangeProfileController {
    private ChangeProfileView changeProfileView;
    private String username;

    ChangeProfileController() {
        changeProfileView = new ChangeProfileView();
        submitBtn();
    }

    public void submitBtn() {
        changeProfileView.getSubmit().setOnAction(actionEvent -> {
            String password = changeProfileView.getPassword().getText();
            if (!password.equals("")) {
                Database.update(username, password);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Password Error");
                alert.setContentText("Please Enter a password");
                alert.show();
            }
        });

    }

    public void setUsername(String username) {
        this.username = username;
    }


    public ChangeProfileView getChangeProfileView() {
        return changeProfileView;
    }
}
