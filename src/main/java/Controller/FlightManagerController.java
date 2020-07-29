package Controller;

import View.FlightManager;

public class FlightManagerController {
    private FlightManager flightManager;

    public FlightManagerController(){
        flightManager=new FlightManager();
        addBtn();
    }

    public void addBtn(){
        flightManager.getAdd().setOnAction(actionEvent -> {
            AddFlightController addFlightController= new AddFlightController();
            flightManager.getScene().setRoot(addFlightController.getAddFlight());
        });
    }

    public FlightManager getFlightManager() {
        return flightManager;
    }
}
