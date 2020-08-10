package Controller;

import Model.Airplane;
import Model.Database;
import View.AddAirplane;
import javafx.scene.control.Alert;

public class AddAirplaneController {

    private AddAirplane addAirplane;

    public AddAirplaneController() {
        addAirplane = new AddAirplane();
        submitBtn();
    }

    public void submitBtn() {
        addAirplane.getSubmit().setOnAction(actionEvent -> {
            String id = addAirplane.getIdNo().getText();
            String chairs = addAirplane.getChairs().getText();
            if (!id.equals("") && !chairs.equals("")) {
                if (!chairs.matches("\\d+\\D+")) {
                    Airplane airplane = new Airplane();
                    airplane.setId(id);
                    airplane.setChairs(Integer.parseInt(chairs));
                    if (Database.check(airplane)) {
                        Database.add(airplane);
                        AirplaneManageController airplaneManageController = new AirplaneManageController();
                        addAirplane.getScene().setRoot(airplaneManageController.getAirplaneManage());
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Exist Error");
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

    public AddAirplane getAddAirplane() {
        return addAirplane;
    }
}
