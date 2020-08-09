package Controller;

import Model.Database;
import View.MassageView;
import javafx.scene.control.Alert;

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
            if (!massage.equals("")) {
                Database.add(username, massage);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Massage Error");
                alert.setContentText("Please enter a massage.");
                alert.show();
            }
        });
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
