package View;

import Model.Airplane;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class AirplaneManage extends BorderPane {

    private JFXButton add;
    private JFXButton edit;
    private JFXButton delete;
    private JFXButton detail;
    private TableView<Airplane> table;

    public AirplaneManage(){
        add = new JFXButton();
        edit = new JFXButton();
        delete = new JFXButton();
        detail = new JFXButton();
        table = new TableView<>();
        TableColumn<Airplane, String> idCardCol = new TableColumn<>("ID");
        TableColumn<Airplane, String> chairsCol = new TableColumn<>("Capacity");
        idCardCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        chairsCol.setCellValueFactory(new PropertyValueFactory<>("chairs"));
        table.getColumns().addAll( idCardCol, chairsCol);

        // Text
        add.setText("Add Airplane");
        edit.setText("Edit Airplane");
        delete.setText("Delete Airplane");
        detail.setText("Detail");

        // Add all to the btnGroup
        VBox btnGroup = new VBox();
        btnGroup.getChildren().addAll(table, add, edit, delete, detail);
        btnGroup.setAlignment(Pos.CENTER);

        // Setting of Airplane View
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

    public TableView<Airplane> getTable() {
        return table;
    }

    public JFXButton getDetail() {
        return detail;
    }
}
