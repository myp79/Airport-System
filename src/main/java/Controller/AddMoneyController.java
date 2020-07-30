package Controller;

import Model.Database;
import View.AddMoney;

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
            int money = Integer.parseInt(addMoney.getMoney().getText());
            Database.update(username,money);
        });
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
