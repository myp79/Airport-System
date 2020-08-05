package View;

import Model.Passenger;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PassengerManage extends BorderPane {

    private JFXButton edit;
    private JFXButton delete;
    private TableView<Passenger> table;

    public PassengerManage() {
        edit = new JFXButton();
        delete = new JFXButton();
        table = new TableView<>();
        TableColumn<Passenger,String> nameCol = new TableColumn<>("Name");
        TableColumn<Passenger,String> lastnameCol = new TableColumn<>("Lastname");
        TableColumn<Passenger,String> idCardCol = new TableColumn<>("ID");
        TableColumn<Passenger ,String> emailCol = new TableColumn<>("Email");
        TableColumn<Passenger ,String> addressCol = new TableColumn<>("Address");
        TableColumn<Passenger,String> usernameCol = new TableColumn<>("Username");
        TableColumn<Passenger,String> passwordCol = new TableColumn<>("Password");
        TableColumn<Passenger ,Integer> moneyCol = new TableColumn<>("Money");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        idCardCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        moneyCol.setCellValueFactory(new PropertyValueFactory<>("money"));
        table.getColumns().addAll(nameCol,lastnameCol,idCardCol,emailCol,addressCol,usernameCol,passwordCol,moneyCol);

        // Text
        edit.setText("Edit Passenger");
        delete.setText("Delete Passenger");

        // Add all to the btnGroup
        VBox btnGroup = new VBox();
        btnGroup.getChildren().addAll(table,edit, delete);
        btnGroup.setAlignment(Pos.CENTER);

        // Setting of Manager View
        this.setCenter(btnGroup);
    }

    public JFXButton getEdit() {
        return edit;
    }

    public JFXButton getDelete() {
        return delete;
    }

    public TableView<Passenger> getTable() {
        return table;
    }
}
