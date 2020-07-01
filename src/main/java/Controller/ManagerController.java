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

    public void setUsername(String username) {
        this.username = username;
    }

    public ManagerView getManagerView() {
        return managerView;
    }
}
