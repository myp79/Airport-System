package Controller;

import Model.Airplane;
import Model.Database;
import View.AddAirplane;

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
            Airplane airplane = new Airplane();
            airplane.setId(id);
            airplane.setChairs(Integer.parseInt(chairs));
            Database.add(airplane);
            AirplaneManageController airplaneManageController= new AirplaneManageController();
            addAirplane.getScene().setRoot(airplaneManageController.getAirplaneManage());
        });
    }

    public AddAirplane getAddAirplane() {
        return addAirplane;
    }
}
