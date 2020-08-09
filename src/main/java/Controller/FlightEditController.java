package Controller;

import Model.Database;
import Model.Flight;
import View.FlightEdit;

public class FlightEditController {

    private FlightEdit flightEdit;
    private String flightOldId;

    public FlightEditController() {
        flightEdit = new FlightEdit();
        submitBtn();
    }

    public void submitBtn() {
        flightEdit.getSubmit().setOnAction(actionEvent -> {
            Flight flight = new Flight();
            flight.setId(flightEdit.getIdNum().getText());
            flight.setDestination(flightEdit.getDestination().getText());
            flight.setSource(flightEdit.getSource().getText());
            flight.setDuration(flightEdit.getDuration().getText());
            flight.setTime(flightEdit.getTime().getText());
            flight.setDate(flightEdit.getDate().getText());
            flight.setTicket(flightEdit.getTickets().getText());
            flight.setNo(flightEdit.getNo().getText());
            flight.setAirplane(flightEdit.getAirplane().getText());
            Database.update(flight, flightOldId);
            FlightManagerController flightManagerController = new FlightManagerController();
            flightEdit.getScene().setRoot(flightManagerController.getFlightManager());
        });
    }

    public FlightEdit getFlightEdit() {
        return flightEdit;
    }

    public void setFlightOldId(String flightOldId) {
        this.flightOldId = flightOldId;
    }
}
