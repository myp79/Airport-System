package Controller;

import Model.Database;
import Model.Flight;
import View.FlightDetail;

public class FlightDetailController {

    private FlightDetail flightDetail;

    public FlightDetailController(Flight flight) {
        flightDetail = new FlightDetail();
        flightDetail.getTable().setItems(Database.passengerForTable(flight.getId()));
    }

    public FlightDetail getFlightDetail() {
        return flightDetail;
    }
}
