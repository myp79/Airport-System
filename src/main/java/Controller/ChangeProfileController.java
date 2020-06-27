package Controller;

import Model.Database;
import View.ChangeProfileView;

public class ChangeProfileController {
    private ChangeProfileView changeProfileView;
    private String username;

    ChangeProfileController() {
        changeProfileView = new ChangeProfileView();
        submitBtn();
    }

    public void submitBtn() {
        changeProfileView.getSubmit().setOnAction(actionEvent -> {
            Database.update(username,changeProfileView.getPassword().getText());
        });

    }

    public void setUsername(String username) {
        this.username = username;
    }


    public ChangeProfileView getChangeProfileView() {
        return changeProfileView;
    }
}
