package View;

import Model.Airplane;
import Model.Flight;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class FlightManager extends BorderPane {
    private JFXButton add;
    private JFXButton edit;
    private JFXButton delete;
    private TableView<Flight> table;

    public FlightManager() {
        add = new JFXButton();
        edit = new JFXButton();
        delete = new JFXButton();
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
        add.setText("Add Flight");
        edit.setText("Edit Flight");
        delete.setText("Delete Flight");

        // Add all to the btnGroup
        VBox btnGroup = new VBox();
        btnGroup.getChildren().addAll(table, add, edit, delete);
        btnGroup.setAlignment(Pos.CENTER);

        // Setting of Manager View
        this.setCenter(btnGroup);
    }

    public JFXButton getAdd() {
        return add;
    }

    public JFXButton getEdit() {
        return edit;
    }

    public JFXButton getDelete() {
        return delete;
    }

    public TableView<Flight> getTable() {
        return table;
    }
}
