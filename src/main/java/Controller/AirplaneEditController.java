package Controller;

import Model.Airplane;
import Model.Database;
import View.AirplaneEdit;
import javafx.scene.control.Alert;

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
            if (!airplane.getId().equals("") && !Integer.toString(airplane.getChairs()).equals("")) {
                if (!Integer.toString(airplane.getChairs()).matches("\\d+\\D+")) {
                    if (Database.check(airplane) || airplane.getId().equals(airplaneOldId)) {
                        Database.update(airplane, airplaneOldId);
                        AirplaneManageController airplaneManageController = new AirplaneManageController();
                        airplaneEdit.getScene().setRoot(airplaneManageController.getAirplaneManage());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Airplane Error");
                        alert.setContentText("Airplane exist.");
                        alert.show();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Chairs Error");
                    alert.setContentText("Chairs have number and word. Check it.");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Null Error");
                alert.setContentText("All field required.");
                alert.show();
            }
        });
    }

    public AirplaneEdit getAirplaneEdit() {
        return airplaneEdit;
    }

    public void setAirplaneOldId(String airplaneOldId) {
        this.airplaneOldId = airplaneOldId;
    }
}
