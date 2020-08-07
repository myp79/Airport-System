package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddTicket extends BorderPane {

    private JFXTextField date;
    private JFXTextField number;
    private JFXButton submit;

    public AddTicket() {
        date = new JFXTextField();
        number = new JFXTextField();
        submit = new JFXButton();

        // Text
        date.setPromptText("Date");
        number.setPromptText("number");
        submit.setText("Submit");

        // Make VBox for input
        VBox information = new VBox(date, number);
        information.setAlignment(Pos.CENTER);

        // Make HBox for button
        HBox btnGroup = new HBox(submit);

        // All be one
        VBox all = new VBox(information, btnGroup);

        // Setting of AddTicket
        this.setCenter(all);
    }

    public JFXTextField getDate() {
        return date;
    }

    public JFXTextField getNumber() {
        return number;
    }

    public JFXButton getSubmit() {
        return submit;
    }
}
