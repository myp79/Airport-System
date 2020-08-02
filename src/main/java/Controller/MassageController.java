package Controller;

import Model.Database;
import View.MassageView;

public class MassageController {
    private MassageView massageView;
    private String username;

    public MassageController() {
        massageView = new MassageView();
        submitBtn();
    }

    public MassageView getMassageView() {
        return massageView;
    }

    public void submitBtn() {
        massageView.getSubmit().setOnAction(actionEvent -> {
            String massage = massageView.getMassage().getText();
            Database.add(username, massage);
        });
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
