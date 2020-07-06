package View;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ManagerManage extends BorderPane {

    private JFXButton add;
    private JFXButton edit;
    private JFXButton delete;

    public ManagerManage() {
        add = new JFXButton();
        edit = new JFXButton();
        delete = new JFXButton();

        // Text
        add.setText("Add Manager");
        edit.setText("Edit Manager");
        delete.setText("Delete Manager");

        // Add all to the btnGroup
        VBox btnGroup = new VBox();
        btnGroup.getChildren().addAll(add, edit, delete);
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
}
