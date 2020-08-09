package Controller;

import Model.Airplane;
import Model.Database;
import Model.Flight;
import View.FlightManager;

public class FlightManagerController {
    private FlightManager flightManager;

    public FlightManagerController() {
        flightManager = new FlightManager();
        flightManager.getTable().setItems(Database.flightsForTable());
        addBtn();
        deleteBtn();
        flightDetail();
        editBtn();
    }

    public void addBtn() {
        flightManager.getAdd().setOnAction(actionEvent -> {
            AddFlightController addFlightController = new AddFlightController();
            flightManager.getScene().setRoot(addFlightController.getAddFlight());
        });
    }

    public void deleteBtn() {
        flightManager.getDelete().setOnAction(actionEvent -> {
            Flight flight = flightManager.getTable().getSelectionModel().getSelectedItem();
            if (flight != null) {
                Database.delete(flight);
                FlightManagerController flightManagerController = new FlightManagerController();
                this.flightManager.getScene().setRoot(flightManagerController.getFlightManager());
            }
        });
    }

    public void flightDetail() {
        flightManager.getDetail().setOnAction(actionEvent -> {
            Flight flight = flightManager.getTable().getSelectionModel().getSelectedItem();
            FlightDetailController flightDetailController = new FlightDetailController(flight);
            flightManager.getScene().setRoot(flightDetailController.getFlightDetail());
        });
    }

    public void editBtn() {
        flightManager.getEdit().setOnAction(actionEvent -> {
            Flight flight = flightManager.getTable().getSelectionModel().getSelectedItem();
            if (flight != null) {
                FlightEditController flightEditController = new FlightEditController();
                flightManager.getScene().setRoot(flightEditController.getFlightEdit());
                flightEditController.getFlightEdit().getIdNum().setText(flight.getId());
                flightEditController.getFlightEdit().getNo().setText(flight.getNo());
                flightEditController.getFlightEdit().getAirplane().setText(flight.getAirplane());
                flightEditController.getFlightEdit().getTickets().setText(flight.getTicket());
                flightEditController.getFlightEdit().getSource().setText(flight.getSource());
                flightEditController.getFlightEdit().getDestination().setText(flight.getDestination());
                flightEditController.getFlightEdit().getDate().setText(flight.getDate());
                flightEditController.getFlightEdit().getTime().setText(flight.getTime());
                flightEditController.getFlightEdit().getDuration().setText(flight.getDuration());
                flightEditController.setFlightOldId(flight.getId());
            }
        });
    }

    public FlightManager getFlightManager() {
        return flightManager;
    }
}
