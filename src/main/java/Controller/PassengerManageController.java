package Controller;

import Model.Database;
import Model.Passenger;
import Model.Passenger;
import View.PassengerManage;

public class PassengerManageController {

    private PassengerManage passengerManage;

    public PassengerManageController() {
        passengerManage = new PassengerManage();
        passengerManage.getTable().setItems(Database.passengerForTable());
        deleteBtn();
        editBtn();
    }

    public void deleteBtn() {
        passengerManage.getDelete().setOnAction(actionEvent -> {
            Passenger passenger = passengerManage.getTable().getSelectionModel().getSelectedItem();
            if (passenger != null) {
                Database.delete(passenger);
                PassengerManageController passengerManageController = new PassengerManageController();
                this.getPassengerManage().getScene().setRoot(passengerManageController.getPassengerManage());
            }
        });
    }

    public void editBtn() {
        passengerManage.getEdit().setOnAction(actionEvent -> {
            Passenger passenger = passengerManage.getTable().getSelectionModel().getSelectedItem();
            if (passenger != null) {
                PersonEditController personEditController = new PersonEditController();
                passengerManage.getScene().setRoot(personEditController.getPersonEdit());
                personEditController.getPersonEdit().getIdCard().setText(passenger.getId());
                personEditController.getPersonEdit().getAddress().setText(passenger.getAddress());
                personEditController.getPersonEdit().getEmail().setText(passenger.getEmail());
                personEditController.getPersonEdit().getName().setText(passenger.getName());
                personEditController.getPersonEdit().getLastname().setText(passenger.getLastname());
                personEditController.getPersonEdit().getMoney().setText(Integer.toString(passenger.getMoney()));
                personEditController.setRoll(Passenger.class.getTypeName());
                personEditController.setUsername(passenger.getUsername());
            }
        });
    }

    public PassengerManage getPassengerManage() {
        return passengerManage;
    }
}
