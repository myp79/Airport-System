package Controller;

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
            if (flight!=null) {
                Database.delete(flight);
                FlightManagerController flightManagerController = new FlightManagerController();
                this.flightManager.getScene().setRoot(flightManagerController.getFlightManager());
            }
        });
    }

    public FlightManager getFlightManager() {
        return flightManager;
    }
}
