package Controller;

import Model.Database;
import Model.Flight;
import View.AddFlight;
import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddFlightController {
    private AddFlight addFlight;

    public AddFlightController() {
        addFlight = new AddFlight();
        for (int i = 0; i < Database.airplanesForTable().size(); i++) {
            addFlight.getAirplane().getItems().add(Database.airplanesForTable().get(i).getId());
        }
        submit();
    }

    public AddFlight getAddFlight() {
        return addFlight;
    }

    public void submit() {
        addFlight.getSubmit().setOnAction(actionEvent -> {
            String id = addFlight.getIdNum().getText();
            String airplane = addFlight.getAirplane().getValue();
            String ticket = addFlight.getTickets().getText();
            String source = addFlight.getSource().getText();
            String destination = addFlight.getDestination().getText();
            LocalDate date = addFlight.getDate().getValue();
            LocalTime time = addFlight.getTime().getValue();
            String duration = addFlight.getDuration().getText();
            String sell = "0";
            Flight flight = new Flight();
            if (!id.equals("") && !airplane.equals("") && !ticket.equals("") && !source.equals("") && !destination.equals("") && !date.toString().equals("") && !time.toString().equals("") && !duration.equals("")) {
                if (!id.matches("\\d+\\D+")) {
                    if (!ticket.matches("\\d+\\D+")) {
                        if (source.matches("\\D+")) {
                            if (destination.matches("\\D+")) {
                                if (!duration.matches("\\d+\\D+")) {
                                    flight.setId(id);
                                    flight.setAirplane(airplane);
                                    flight.setDate(date.toString());
                                    flight.setDestination(destination);
                                    flight.setSource(source);
                                    flight.setNo(sell);
                                    flight.setTime(time.toString());
                                    flight.setTicket(ticket);
                                    flight.setDuration(duration);
                                    if (Database.check(flight)) {
                                        Database.add(flight);
                                        FlightManagerController flightManagerController = new FlightManagerController();
                                        addFlight.getScene().setRoot(flightManagerController.getFlightManager());
                                    } else {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("Flight Error");
                                        alert.setContentText("Flight is exist.");
                                        alert.show();
                                    }
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Duration Error");
                                    alert.setContentText("Duration have number and word. Check it.");
                                    alert.show();
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Destination Error");
                                alert.setContentText("Destination have number. Check it.");
                                alert.show();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Source Error");
                            alert.setContentText("Source have number. Check it.");
                            alert.show();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Ticket Error");
                        alert.setContentText("Ticket have number and word. Check it.");
                        alert.show();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ID Error");
                    alert.setContentText("ID have number and word. Check it.");
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

}
