package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ChangeProfileView extends BorderPane {
    private JFXPasswordField password;
    private JFXButton submit;

    public ChangeProfileView() {
        password = new JFXPasswordField();
        submit = new JFXButton();

        // Text
        password.setPromptText("Password");
        submit.setText("Submit");

        // VBox for all
        VBox all = new VBox(password, submit);

        // Setting of Login View
        this.setCenter(all);

    }

    public JFXPasswordField getPassword() {
        return password;
    }

    public JFXButton getSubmit() {
        return submit;
    }
}
