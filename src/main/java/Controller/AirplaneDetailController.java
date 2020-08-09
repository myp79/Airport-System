package Controller;

import Model.Airplane;
import Model.Database;
import View.AirplaneDetail;

public class AirplaneDetailController {
    private AirplaneDetail airplaneDetail;

    public AirplaneDetailController(Airplane airplane) {
        airplaneDetail = new AirplaneDetail();
        airplaneDetail.getTable().setItems(Database.flightsForTable(airplane.getId()));
    }

    public AirplaneDetail getAirplaneDetail() {
        return airplaneDetail;
    }
}
