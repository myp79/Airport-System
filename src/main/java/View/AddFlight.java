package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddFlight extends BorderPane {

    private JFXTextField idNum;
    private JFXTextField airplane;
    private JFXTextField tickets;
    private JFXTextField source;
    private JFXTextField destination;
    private JFXTextField date;
    private JFXTextField time;
    private JFXTextField duration;
    private JFXButton submit;

    public AddFlight() {
        idNum = new JFXTextField();
        airplane = new JFXTextField();
        tickets = new JFXTextField();
        source = new JFXTextField();
        destination = new JFXTextField();
        date = new JFXTextField();
        time = new JFXTextField();
        duration = new JFXTextField();
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
        submit.setText("Submit");

        // Make VBox for input
        VBox information = new VBox(idNum, airplane, tickets);
        VBox info = new VBox(source);
        VBox loginInformation = new VBox(destination, date, time,duration);
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

    public JFXTextField getAirplane() {
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

    public JFXTextField getDate() {
        return date;
    }

    public JFXTextField getTime() {
        return time;
    }

    public JFXButton getSubmit() {
        return submit;
    }

    public JFXTextField getDuration() {
        return duration;
    }
}

