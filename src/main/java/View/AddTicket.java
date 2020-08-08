package View;

import Model.Airplane;
import Model.Flight;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddTicket extends BorderPane {

    private JFXTextField date;
    private JFXTextField number;
    private JFXButton submit;
    private TableView<Flight> table;

    public AddTicket() {
        date = new JFXTextField();
        number = new JFXTextField();
        submit = new JFXButton();
        table = new TableView<>();
        TableColumn<Flight, String> durationCol = new TableColumn<>("Duration");
        TableColumn<Flight, String> ticketNo = new TableColumn<>("No");
        TableColumn<Flight, String> idCardCol = new TableColumn<>("ID");
        TableColumn<Flight, String> sourceCol = new TableColumn<>("Source");
        TableColumn<Flight, String> destinationColl = new TableColumn<>("Destination");
        TableColumn<Flight, String> dateCol = new TableColumn<>("Date");
        TableColumn<Flight, String> timeCol = new TableColumn<>("Time");
        TableColumn<Flight, String> ticketCol = new TableColumn<>("Ticket");
        TableColumn<Flight, Airplane> airplaneCol = new TableColumn<>("Airplane");
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        ticketNo.setCellValueFactory(new PropertyValueFactory<>("no"));
        idCardCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        sourceCol.setCellValueFactory(new PropertyValueFactory<>("source"));
        destinationColl.setCellValueFactory(new PropertyValueFactory<>("destination"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        timeCol.setCellValueFactory(new PropertyValueFactory<>("time"));
        airplaneCol.setCellValueFactory(new PropertyValueFactory<>("airplane"));
        ticketCol.setCellValueFactory(new PropertyValueFactory<>("ticket"));
        table.getColumns().addAll(idCardCol, airplaneCol, ticketCol, ticketNo, sourceCol, destinationColl, dateCol, timeCol, durationCol);

        // Text
        date.setPromptText("Date");
        number.setPromptText("number");
        submit.setText("Submit");

        // Make VBox for input
        VBox information = new VBox(table, number);
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

    public TableView<Flight> getTable() {
        return table;
    }
}
