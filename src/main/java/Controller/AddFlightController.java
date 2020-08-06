package Controller;

import Model.Database;
import Model.Flight;
import View.AddFlight;

public class AddFlightController {
    private AddFlight addFlight;

    public AddFlightController() {
        addFlight = new AddFlight();
        submit();
    }

    public AddFlight getAddFlight() {
        return addFlight;
    }
    public void submit(){
        addFlight.getSubmit().setOnAction(actionEvent -> {
            String id = addFlight.getIdNum().getText();
            String airplane = addFlight.getAirplane().getText();
            String ticket = addFlight.getTickets().getText();
            String source = addFlight.getSource().getText();
            String destination = addFlight.getDestination().getText();
            String date = addFlight.getDate().getText();
            String time = addFlight.getTime().getText();
            String duration = addFlight.getDuration().getText();
            String sell = "0";
            Flight flight = new Flight();
            flight.setId(id);
            flight.setAirplane(airplane);
            flight.setDate(date);
            flight.setDestination(destination);
            flight.setSource(source);
            flight.setNo(sell);
            flight.setTime(time);
            flight.setTicket(ticket);
            flight.setDuration(duration);
            Database.add(flight);
            FlightManagerController flightManagerController= new FlightManagerController();
            addFlight.getScene().setRoot(flightManagerController.getFlightManager());
        });
    }

}
