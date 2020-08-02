package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MassageView extends BorderPane {

    private JFXTextArea massage;
    private JFXButton submit;

    public MassageView() {
        massage = new JFXTextArea();
        submit = new JFXButton();
        VBox btnGroup = new VBox();

        // Text
        massage.setPromptText("Massage...");
        submit.setText("Submit");

        // Add all to the btnGroup
        btnGroup.getChildren().addAll(massage, submit);
        btnGroup.setAlignment(Pos.CENTER);

        // Setting of Massage View
        this.setCenter(btnGroup);
    }

    public JFXTextArea getMassage() {
        return massage;
    }

    public JFXButton getSubmit() {
        return submit;
    }
}
