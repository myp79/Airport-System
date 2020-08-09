package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddEmployee extends BorderPane {

    private JFXTextField name;
    private JFXTextField lastname;
    private JFXTextField email;
    private JFXTextField idCard;
    private JFXTextField username;
    private JFXTextField address;
    private JFXTextField money;
    private JFXPasswordField password;
    private JFXButton submit;

    public AddEmployee() {
        name = new JFXTextField();
        lastname = new JFXTextField();
        email = new JFXTextField();
        idCard = new JFXTextField();
        address = new JFXTextField();
        money = new JFXTextField();
        username = new JFXTextField();
        password = new JFXPasswordField();
        submit = new JFXButton();

        // Text
        name.setPromptText("Name");
        lastname.setPromptText("Last name");
        email.setPromptText("Email");
        idCard.setPromptText("ID");
        address.setPromptText("Address");
        money.setPromptText("Money");
        username.setPromptText("Username");
        password.setPromptText("Password");
        submit.setText("Submit");

        // Make VBox for input
        VBox information = new VBox(name, lastname, email);
        VBox info = new VBox(address, money);
        VBox loginInformation = new VBox(idCard, username, password);
        information.setAlignment(Pos.CENTER);
        loginInformation.setAlignment(Pos.CENTER);

        // Make HBox for button
        HBox btnGroup = new HBox(submit);

        // All be one
        VBox all = new VBox(information, info, loginInformation, btnGroup);

        // Setting of AddEmployee
        this.setCenter(all);

    }

    public JFXTextField getName() {
        return name;
    }

    public JFXTextField getLastname() {
        return lastname;
    }

    public JFXTextField getEmail() {
        return email;
    }

    public JFXTextField getIdCard() {
        return idCard;
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

    public JFXTextField getAddress() {
        return address;
    }

    public JFXTextField getMoney() {
        return money;
    }
}
