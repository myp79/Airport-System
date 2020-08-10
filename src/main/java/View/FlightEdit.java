package View;

import com.jfoenix.controls.*;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FlightEdit extends BorderPane {

    private JFXTextField idNum;
    private JFXComboBox<String> airplane;
    private JFXTextField tickets;
    private JFXTextField source;
    private JFXTextField destination;
    private JFXDatePicker date;
    private JFXTimePicker time;
    private JFXTextField no;
    private JFXTextField duration;
    private JFXButton submit;

    public FlightEdit() {
        idNum = new JFXTextField();
        airplane = new JFXComboBox<>();
        tickets = new JFXTextField();
        source = new JFXTextField();
        destination = new JFXTextField();
        date = new JFXDatePicker();
        time = new JFXTimePicker();
        duration = new JFXTextField();
        no = new JFXTextField();
        submit = new JFXButton();

        // Text
        idNum.setPromptText("ID");
        airplane.setPromptText("Airplane");
        tickets.setPromptText("Ticket");
        source.setPromptText("Source");
        destination.setPromptText("Destination");
        date.setPromptText("Date");
        time.setPromptText("Time");
        duration.setPromptText("Duration");
        no.setPromptText("No");
        submit.setText("Submit");

        // Make VBox for input
        VBox information = new VBox(idNum, airplane, tickets);
        VBox info = new VBox(source);
        VBox loginInformation = new VBox(destination, date, time, duration, no);
        information.setAlignment(Pos.CENTER);
        loginInformation.setAlignment(Pos.CENTER);

        // Make HBox for button
        HBox btnGroup = new HBox(submit);

        // All be one
        VBox all = new VBox(information, info, loginInformation, btnGroup);

        // Setting of AddEmployee
        this.setCenter(all);
    }

    public JFXTextField getIdNum() {
        return idNum;
    }

    public JFXComboBox<String> getAirplane() {
        return airplane;
    }

    public JFXTextField getTickets() {
        return tickets;
    }

    public JFXTextField getSource() {
        return source;
    }

    public JFXTextField getDestination() {
        return destination;
    }

    public JFXDatePicker getDate() {
        return date;
    }

    public JFXTimePicker getTime() {
        return time;
    }

    public JFXTextField getDuration() {
        return duration;
    }

    public JFXButton getSubmit() {
        return submit;
    }

    public JFXTextField getNo() {
        return no;
    }
}
