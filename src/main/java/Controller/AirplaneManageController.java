package Controller;

import Model.Airplane;
import Model.Database;
import Model.Flight;
import View.AirplaneManage;

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
            }
        });
    }

    public void airplaneDetail() {
        airplaneManage.getDetail().setOnAction(actionEvent -> {
            Airplane airplane = airplaneManage.getTable().getSelectionModel().getSelectedItem();
            AirplaneDetailController airplaneDetailController = new AirplaneDetailController(airplane);
            airplaneManage.getScene().setRoot(airplaneDetailController.getAirplaneDetail());
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
            }
        });
    }

    public AirplaneManage getAirplaneManage() {
        return airplaneManage;
    }
}
