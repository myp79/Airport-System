package View;

import Model.Ticket;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TicketView extends BorderPane {

    private JFXButton add;
    private JFXButton delete;
    private TableView<Ticket> table;

    public TicketView() {
        add = new JFXButton();
        delete = new JFXButton();
        table = new TableView<>();
        TableColumn<Ticket, String> idCardCol = new TableColumn<>("ID");
        TableColumn<Ticket, String> priceCol = new TableColumn<>("Price");
        TableColumn<Ticket, Integer> crimeCol = new TableColumn<>("Crime");
        idCardCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        crimeCol.setCellValueFactory(new PropertyValueFactory<>("crime"));
        table.getColumns().addAll(idCardCol, priceCol, crimeCol);

        // Text
        add.setText("Add Ticket");
        delete.setText("Delete Ticket");

        // Add all to the btnGroup
        VBox btnGroup = new VBox();
        btnGroup.getChildren().addAll(table, add, delete);
        btnGroup.setAlignment(Pos.CENTER);

        // Setting of Ticket View
        this.setCenter(btnGroup);
    }

    public JFXButton getAdd() {
        return add;
    }

    public JFXButton getDelete() {
        return delete;
    }

    public TableView<Ticket> getTable() {
        return table;
    }
}
