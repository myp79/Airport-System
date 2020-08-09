package Controller;

import Model.Airplane;
import Model.Database;
import View.AirplaneManage;
import javafx.scene.control.Alert;

public class AirplaneManageController {

    private AirplaneManage airplaneManage;

    public AirplaneManageController() {
        airplaneManage = new AirplaneManage();
        airplaneManage.getTable().setItems(Database.airplanesForTable());
        addBtn();
        deleteBtn();
        airplaneDetail();
        editBtn();
    }

    public void addBtn() {
        airplaneManage.getAdd().setOnAction(actionEvent -> {
            AddAirplaneController addAirplaneController = new AddAirplaneController();
            airplaneManage.getScene().setRoot(addAirplaneController.getAddAirplane());
        });
    }

    public void deleteBtn() {
        airplaneManage.getDelete().setOnAction(actionEvent -> {
            Airplane airplane = airplaneManage.getTable().getSelectionModel().getSelectedItem();
            if (airplane != null) {
                Database.delete(airplane);
                AirplaneManageController airplaneManageController = new AirplaneManageController();
                this.getAirplaneManage().getScene().setRoot(airplaneManageController.getAirplaneManage());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Select Error");
                alert.setContentText("Please Select an item.");
                alert.show();
            }
        });
    }

    public void airplaneDetail() {
        airplaneManage.getDetail().setOnAction(actionEvent -> {
            Airplane airplane = airplaneManage.getTable().getSelectionModel().getSelectedItem();
            if (airplane != null) {
                AirplaneDetailController airplaneDetailController = new AirplaneDetailController(airplane);
                airplaneManage.getScene().setRoot(airplaneDetailController.getAirplaneDetail());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Select Error");
                alert.setContentText("Please Select an item.");
                alert.show();
            }
        });
    }

    public void editBtn() {
        airplaneManage.getEdit().setOnAction(actionEvent -> {
            Airplane airplane = airplaneManage.getTable().getSelectionModel().getSelectedItem();
            if (airplane != null) {
                AirplaneEditController airplaneEditController = new AirplaneEditController();
                airplaneManage.getScene().setRoot(airplaneEditController.getAirplaneEdit());
                airplaneEditController.getAirplaneEdit().getIdNo().setText(airplane.getId());
                airplaneEditController.getAirplaneEdit().getChair().setText(Integer.toString(airplane.getChairs()));
                airplaneEditController.setAirplaneOldId(airplane.getId());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Select Error");
                alert.setContentText("Please Select an item.");
                alert.show();
            }
        });
    }

    public AirplaneManage getAirplaneManage() {
        return airplaneManage;
    }
}
