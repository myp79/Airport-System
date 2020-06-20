package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginView extends BorderPane {
    private JFXTextField username;
    private JFXPasswordField password;
    private JFXButton submit;
    private JFXButton signUp;

    public LoginView() {
        username = new JFXTextField();
        password = new JFXPasswordField();
        submit = new JFXButton();
        signUp = new JFXButton();

        // Text
        username.setPromptText("Username");
        password.setPromptText("Password");
        submit.setText("Submit");
        signUp.setText("Sign Up");

        // Make VBox for input
        VBox information = new VBox(username, password);
        information.setAlignment(Pos.CENTER);

        // Make HBox for button
        HBox btnGroup = new HBox(submit, signUp);

        // All be one
        VBox all=new VBox(information,btnGroup);

        // Setting of Login View
        this.setCenter(all);

    }

    public JFXTextField getUsername() {
        return username;
    }

    public JFXPasswordField getPassword() {
        return password;
    }

    public JFXButton getSubmit() {
        return submit;
    }

    public JFXButton getSignUp() {
        return signUp;
    }
}
