package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PersonEdit extends BorderPane {
    private JFXTextField name;
    private JFXTextField lastname;
    private JFXTextField email;
    private JFXTextField idCard;
    private JFXTextField address;
    private JFXTextField money;
    private JFXButton submit;

    public PersonEdit() {
        name = new JFXTextField();
        lastname = new JFXTextField();
        email = new JFXTextField();
        idCard = new JFXTextField();
        address = new JFXTextField();
        money = new JFXTextField();
        submit = new JFXButton();

        // Text
        name.setPromptText("Name");
        lastname.setPromptText("Last name");
        email.setPromptText("Email");
        idCard.setPromptText("ID");
        address.setPromptText("Address");
        money.setPromptText("Money");
        submit.setText("Submit");

        // Make VBox for input
        VBox information = new VBox(name, lastname, email);
        VBox info = new VBox(address);
        VBox loginInformation = new VBox(idCard, money);
        information.setAlignment(Pos.CENTER);
        loginInformation.setAlignment(Pos.CENTER);

        // Make HBox for button
        HBox btnGroup = new HBox(submit);

        // All be one
        VBox all = new VBox(information, info, loginInformation, btnGroup);

        // Setting of SignUpView
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

    public JFXTextField getAddress() {
        return address;
    }

    public JFXTextField getMoney() {
        return money;
    }

    public JFXButton getSubmit() {
        return submit;
    }

}
