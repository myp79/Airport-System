package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AirplaneEdit extends BorderPane {

    private JFXTextField idNo;
    private JFXTextField chair;
    private JFXButton submit;

    public AirplaneEdit() {
        idNo = new JFXTextField();
        chair = new JFXTextField();
        submit = new JFXButton();

        // Text
        idNo.setPromptText("ID");
        chair.setPromptText("Chair");
        submit.setText("Submit");

        // Make VBox for input
        VBox information = new VBox(idNo, chair);
        information.setAlignment(Pos.CENTER);

        // Make HBox for button
        HBox btnGroup = new HBox(submit);

        // All be one
        VBox all = new VBox(information, btnGroup);

        // Setting of SignUpView
        this.setCenter(all);
    }

    public JFXTextField getIdNo() {
        return idNo;
    }

    public JFXTextField getChair() {
        return chair;
    }

    public JFXButton getSubmit() {
        return submit;
    }
}
