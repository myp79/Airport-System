package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ForgotPassword extends BorderPane {

    private JFXTextField username;
    private JFXTextField email;
    private JFXButton submit;

    public ForgotPassword() {
        username = new JFXTextField();
        email = new JFXTextField();
        submit = new JFXButton();

        // Text
        username.setPromptText("Username");
        email.setPromptText("Email");
        submit.setText("Submit");

        // Make VBox for input
        VBox information = new VBox(username, email);
        information.setAlignment(Pos.CENTER);

        // Make HBox for button
        HBox btnGroup = new HBox(submit);

        // All be one
        VBox all = new VBox(information, btnGroup);

        // Setting of Login View
        this.setCenter(all);

    }

    public JFXTextField getUsername() {
        return username;
    }

    public JFXTextField getEmail() {
        return email;
    }

    public JFXButton getSubmit() {
        return submit;
    }
}
