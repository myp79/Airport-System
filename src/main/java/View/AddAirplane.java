package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddAirplane extends BorderPane {

    private JFXTextField idNo;
    private JFXTextField chairs;
    private JFXButton submit;

    public AddAirplane() {
        idNo = new JFXTextField();
        chairs = new JFXTextField();
        submit = new JFXButton();

        // Text
        idNo.setPromptText("ID");
        chairs.setPromptText("Capacity");
        submit.setText("Submit");

        // Make VBox for input
        VBox information = new VBox(idNo, chairs);
        information.setAlignment(Pos.CENTER);

        // Make HBox for button
        HBox btnGroup = new HBox(submit);

        // All be one
        VBox all = new VBox(information, btnGroup);

        // Setting of AddAirplane
        this.setCenter(all);
    }

    public JFXTextField getIdNo() {
        return idNo;
    }

    public JFXTextField getChairs() {
        return chairs;
    }

    public JFXButton getSubmit() {
        return submit;
    }
}
