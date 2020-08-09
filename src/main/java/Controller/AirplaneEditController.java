package Controller;

import Model.Airplane;
import Model.Database;
import View.AirplaneEdit;

public class AirplaneEditController {

    private AirplaneEdit airplaneEdit;
    private String airplaneOldId;

    public AirplaneEditController() {
        airplaneEdit = new AirplaneEdit();
        submitBtn();
    }

    public void submitBtn() {
        airplaneEdit.getSubmit().setOnAction(actionEvent -> {
            Airplane airplane = new Airplane();
            airplane.setId(airplaneEdit.getIdNo().getText());
            airplane.setChairs(Integer.parseInt(airplaneEdit.getChair().getText()));
            Database.update(airplane, airplaneOldId);
            AirplaneManageController airplaneManageController = new AirplaneManageController();
            airplaneEdit.getScene().setRoot(airplaneManageController.getAirplaneManage());
        });
    }

    public AirplaneEdit getAirplaneEdit() {
        return airplaneEdit;
    }

    public void setAirplaneOldId(String airplaneOldId) {
        this.airplaneOldId = airplaneOldId;
    }
}
