package View;

import Model.Airplane;
import Model.Flight;
import Model.Passenger;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class FlightDetail extends BorderPane {

    private TableView<Passenger> table;

    public FlightDetail() {
        table = new TableView<>();
        TableColumn<Passenger, String> nameCol = new TableColumn<>("Name");
        TableColumn<Passenger, String> lastnameCol = new TableColumn<>("Lastname");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        table.getColumns().addAll(nameCol, lastnameCol);

        // Add all to the btnGroup
        VBox btnGroup = new VBox();
        btnGroup.getChildren().addAll(table);
        btnGroup.setAlignment(Pos.CENTER);

        // Setting of Manager View
        this.setCenter(btnGroup);
    }

    public TableView<Passenger> getTable() {
        return table;
    }
}
