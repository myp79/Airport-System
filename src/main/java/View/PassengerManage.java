package View;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PassengerManage extends BorderPane {

    private JFXButton edit;
    private JFXButton delete;

    public PassengerManage() {
        edit = new JFXButton();
        delete = new JFXButton();

        // Text
        edit.setText("Edit Passenger");
        delete.setText("Delete Passenger");

        // Add all to the btnGroup
        VBox btnGroup = new VBox();
        btnGroup.getChildren().addAll(edit, delete);
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
}
