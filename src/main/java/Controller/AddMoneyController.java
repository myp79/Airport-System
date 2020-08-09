package Controller;

import Model.Database;
import View.AddMoney;
import javafx.scene.control.Alert;

public class AddMoneyController {
    private AddMoney addMoney;
    private String username;

    public AddMoneyController() {
        addMoney = new AddMoney();
        submitBtn();
    }

    public AddMoney getAddMoney() {
        return addMoney;
    }

    public void submitBtn() {
        addMoney.getSubmit().setOnAction(actionEvent -> {
            String money = addMoney.getMoney().getText();
            if (money.matches("\\d+\\D+")) {
                Database.update(username, Integer.parseInt(money));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Money Error");
                alert.setContentText("Money have word and number. Check it.");
                alert.show();
            }
        });
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
