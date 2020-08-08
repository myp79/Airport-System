package Controller;

import View.PassengerView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PassengerController {
    private PassengerView passengerView;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public PassengerController() {
        passengerView = new PassengerView();
        changeProfile();
        moneyBtn();
        massageBtn();
        ticketBtn();
    }

    public void changeProfile() {
        passengerView.getProfile().setOnAction(actionEvent -> {
            ChangeProfileController changeProfileController = new ChangeProfileController();
            changeProfileController.setUsername(username);
            Stage stage = new Stage();
            stage.setScene(new Scene(changeProfileController.getChangeProfileView()));
            stage.show();
        });

    }

    public void moneyBtn() {
        passengerView.getMoney().setOnAction(actionEvent -> {
            AddMoneyController addMoneyController = new AddMoneyController();
            addMoneyController.setUsername(username);
            Stage stage = new Stage();
            stage.setScene(new Scene(addMoneyController.getAddMoney()));
            stage.show();
        });
    }

    public void massageBtn() {
        passengerView.getMassage().setOnAction(actionEvent -> {
            MassageController massageController = new MassageController();
            massageController.setUsername(username);
            Stage stage = new Stage();
            stage.setScene(new Scene(massageController.getMassageView()));
            stage.show();
        });
    }

    public void ticketBtn() {
        passengerView.getBuyTicket().setOnAction(actionEvent -> {
            TicketController ticketController = new TicketController();
            ticketController.setUsername(username);
            Stage stage = new Stage();
            stage.setScene(new Scene(ticketController.getTicketView()));
            stage.show();
        });
    }


    public PassengerView getPassengerView() {
        return passengerView;
    }
}
