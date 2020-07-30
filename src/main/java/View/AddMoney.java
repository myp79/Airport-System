package View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddMoney extends BorderPane {

    private JFXTextField money;
    private JFXButton submit;

    public AddMoney(){
        money = new JFXTextField();
        submit = new JFXButton();

        // Text
        money.setPromptText("Money");
        submit.setText("Submit");

        // Make VBox for input
        VBox information = new VBox(money);
        information.setAlignment(Pos.CENTER);

        // Make HBox for button
        HBox btnGroup = new HBox(submit);

        // All be one
        VBox all = new VBox(information, btnGroup);

        // Setting of SignUpView
        this.setCenter(all);
    }

    public JFXTextField getMoney() {
        return money;
    }

    public JFXButton getSubmit() {
        return submit;
    }
}
