package Controller;

import Model.Database;
import Model.Flight;
import View.FlightEdit;
import javafx.scene.control.Alert;

public class FlightEditController {

    private FlightEdit flightEdit;
    private String flightOldId;

    public FlightEditController() {
        flightEdit = new FlightEdit();
        for (int i = 0; i < Database.airplanesForTable().size(); i++) {
            flightEdit.getAirplane().getItems().add(Database.airplanesForTable().get(i).getId());
        }
        submitBtn();
    }

    public void submitBtn() {
        flightEdit.getSubmit().setOnAction(actionEvent -> {
            Flight flight = new Flight();
            flight.setId(flightEdit.getIdNum().getText());
            flight.setDestination(flightEdit.getDestination().getText());
            flight.setSource(flightEdit.getSource().getText());
            flight.setDuration(flightEdit.getDuration().getText());
            flight.setTime(flightEdit.getTime().getValue());
            flight.setDate(flightEdit.getDate().getValue());
            flight.setTicket(flightEdit.getTickets().getText());
            flight.setNo(flightEdit.getNo().getText());
            flight.setAirplane(flightEdit.getAirplane().getValue());
            if (!flight.getId().equals("") && !flight.getDestination().equals("") && !flight.getSource().equals("") && !flight.getDuration().equals("") && !flight.getTime().toString().equals("") && !flight.getDate().toString().equals("") && !flight.getTicket().equals("") && !flight.getNo().equals("") && !flight.getAirplane().equals("")) {
                if (!flight.getId().matches("\\d+\\D+")) {
                    if (!flight.getTicket().matches("\\d+\\D+")) {
                        if (flight.getSource().matches("\\D+")) {
                            if (flight.getDestination().matches("\\D+")) {
                                if (!flight.getDuration().matches("\\d+\\D+")) {
                                    if (!flight.getNo().matches("\\d+\\D+")) {
                                        if (Database.check(flight)) {
                                            Database.update(flight, flightOldId);
                                            FlightManagerController flightManagerController = new FlightManagerController();
                                            flightEdit.getScene().setRoot(flightManagerController.getFlightManager());
                                        } else {
                                            Alert alert = new Alert(Alert.AlertType.ERROR);
                                            alert.setTitle("Flight Error");
                                            alert.setContentText("Flight exist.");
                                            alert.show();
                                        }
                                    } else {
                                        Alert alert = new Alert(Alert.AlertType.ERROR);
                                        alert.setTitle("No Error");
                                        alert.setContentText("No have number and word. Check it.");
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

    public FlightEdit getFlightEdit() {
        return flightEdit;
    }

    public void setFlightOldId(String flightOldId) {
        this.flightOldId = flightOldId;
    }
}
