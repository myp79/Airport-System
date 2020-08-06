package Controller;

import Model.Airplane;
import Model.Database;
import View.AirplaneManage;

public class AirplaneManageController {

    private AirplaneManage airplaneManage;

    public AirplaneManageController() {
        airplaneManage = new AirplaneManage();
        airplaneManage.getTable().setItems(Database.airplanesForTable());
        addBtn();
        deleteBtn();
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
            if (airplane != null){
                Database.delete(airplane);
                AirplaneManageController airplaneManageController= new AirplaneManageController();
                this.getAirplaneManage().getScene().setRoot(airplaneManageController.getAirplaneManage());
            }
        });
    }

    public AirplaneManage getAirplaneManage() {
        return airplaneManage;
    }
}
