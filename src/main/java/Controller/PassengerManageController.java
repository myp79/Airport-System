package Controller;

import Model.Database;
import Model.Passenger;
import View.PassengerManage;

public class PassengerManageController {

    private PassengerManage passengerManage;

    public PassengerManageController() {
        passengerManage = new PassengerManage();
        passengerManage.getTable().setItems(Database.passengerForTable());
        deleteBtn();
    }

    public void deleteBtn() {
        passengerManage.getDelete().setOnAction(actionEvent -> {
            Passenger passenger= passengerManage.getTable().getSelectionModel().getSelectedItem();
            if (passenger != null) {
                Database.delete(passenger);
                PassengerManageController passengerManageController=new PassengerManageController();
                this.getPassengerManage().getScene().setRoot(passengerManageController.getPassengerManage());
            }
        });
    }

    public PassengerManage getPassengerManage() {
        return passengerManage;
    }
}
