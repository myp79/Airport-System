package View;

import Model.Database;
import Model.Massage;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MassageManage extends BorderPane {

    private JFXButton delete;
    private TableView<Massage> table;

    public MassageManage() {
        delete = new JFXButton();
        table = new TableView<>();
        TableColumn<Massage ,String> usernameCol = new TableColumn<>("Username");
        TableColumn<Massage ,String> massageCol = new TableColumn<>("Massage");
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        massageCol.setCellValueFactory(new PropertyValueFactory<>("massage"));
        table.getColumns().addAll(usernameCol,massageCol);

        // Text
        delete.setText("Delete Massage");

        // Add all to the btnGroup
        VBox btnGroup = new VBox();
        btnGroup.getChildren().addAll(table,delete);
        btnGroup.setAlignment(Pos.CENTER);

        // Setting of Manager View
        this.setCenter(btnGroup);
    }

    public JFXButton getDelete() {
        return delete;
    }

    public TableView<Massage> getTableView() {
        return table;
    }
}
