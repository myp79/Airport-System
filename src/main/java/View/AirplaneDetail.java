package View;

import Model.Flight;
import Model.Passenger;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AirplaneDetail extends BorderPane {

    private TableView<Flight> table;

    public AirplaneDetail() {
        table = new TableView<>();
        TableColumn<Flight, String> IdCol = new TableColumn<>("ID");
        TableColumn<Flight, String> sourceCol = new TableColumn<>("Source");
        TableColumn<Flight, String> destinationCol = new TableColumn<>("Destination");
        IdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        sourceCol.setCellValueFactory(new PropertyValueFactory<>("source"));
        destinationCol.setCellValueFactory(new PropertyValueFactory<>("destination"));
        table.getColumns().addAll(IdCol, sourceCol, destinationCol);

        // Add all to the btnGroup
        VBox btnGroup = new VBox();
        btnGroup.getChildren().addAll(table);
        btnGroup.setAlignment(Pos.CENTER);

        // Setting of Manager View
        this.setCenter(btnGroup);
    }

    public TableView<Flight> getTable() {
        return table;
    }
}
