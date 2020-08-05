package View;

import Model.Employee;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class EmployeeManage extends BorderPane {

    private JFXButton add;
    private JFXButton edit;
    private JFXButton delete;
    private TableView<Employee> table;

    public EmployeeManage() {
        add = new JFXButton();
        edit = new JFXButton();
        delete = new JFXButton();
        table = new TableView<>();
        TableColumn<Employee,String> nameCol = new TableColumn<>("Name");
        TableColumn<Employee,String> lastnameCol = new TableColumn<>("Lastname");
        TableColumn<Employee,String> idCardCol = new TableColumn<>("ID");
        TableColumn<Employee ,String> emailCol = new TableColumn<>("Email");
        TableColumn<Employee ,String> addressCol = new TableColumn<>("Address");
        TableColumn<Employee,String> usernameCol = new TableColumn<>("Username");
        TableColumn<Employee,String> passwordCol = new TableColumn<>("Password");
        TableColumn<Employee ,Integer> moneyCol = new TableColumn<>("Money");
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
        add.setText("Add Employee");
        edit.setText("Edit Employee");
        delete.setText("Delete Employee");

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

    public TableView<Employee> getTable() {
        return table;
    }
}
