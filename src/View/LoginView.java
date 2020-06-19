package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.layout.BorderPane;

public class LoginView extends BorderPane {
    private JFXTextField username;
    private JFXPasswordField password;
    private JFXButton submit;
    private JFXButton signUp;

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
