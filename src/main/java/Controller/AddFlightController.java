package Controller;

import View.AddFlight;
import javafx.scene.control.Alert;

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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setContentText("Database is not work!");
            alert.show();
        });
    }

}
