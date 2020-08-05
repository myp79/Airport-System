package View;

import Model.Manager;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ManagerManage extends BorderPane {

    private JFXButton add;
    private JFXButton edit;
    private JFXButton delete;
    private TableView<Manager> table;

    public ManagerManage() {
        add = new JFXButton();
        edit = new JFXButton();
        delete = new JFXButton();
        table = new TableView<>();
        TableColumn<Manager, String> nameCol = new TableColumn<>("Name");
        TableColumn<Manager, String> lastnameCol = new TableColumn<>("Lastname");
        TableColumn<Manager, String> idCardCol = new TableColumn<>("ID");
        TableColumn<Manager, String> emailCol = new TableColumn<>("Email");
        TableColumn<Manager, String> addressCol = new TableColumn<>("Address");
        TableColumn<Manager, String> usernameCol = new TableColumn<>("Username");
        TableColumn<Manager, String> passwordCol = new TableColumn<>("Password");
        TableColumn<Manager, Integer> moneyCol = new TableColumn<>("Money");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        idCardCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        moneyCol.setCellValueFactory(new PropertyValueFactory<>("money"));
        table.getColumns().addAll(nameCol, lastnameCol, idCardCol, emailCol, addressCol, usernameCol, passwordCol, moneyCol);

        // Text
        add.setText("Add Manager");
        edit.setText("Edit Manager");
        delete.setText("Delete Manager");

        // Add all to the btnGroup
        VBox btnGroup = new VBox();
        btnGroup.getChildren().addAll(table,add, edit, delete);
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

    public TableView<Manager> getTable() {
        return table;
    }
}
