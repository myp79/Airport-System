package View;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PassengerView extends BorderPane {
    private JFXButton profile;
    private JFXButton money;
    private JFXButton buyTicket;
    private JFXButton massage;

    public PassengerView(){
        profile = new JFXButton();
        money = new JFXButton();
        buyTicket = new JFXButton();
        massage = new JFXButton();
        VBox btnGroup = new VBox();

        // Text
        profile.setText("Profile");
        money.setText("Passenger");
        buyTicket.setText("Ticket");
        massage.setText("Massage");

        // Add all to the btnGroup
        btnGroup.getChildren().addAll(profile, money, buyTicket, massage);
        btnGroup.setAlignment(Pos.CENTER);

        // Setting of Manager View
        this.setCenter(btnGroup);

    }

    public JFXButton getProfile() {
        return profile;
    }

    public JFXButton getMoney() {
        return money;
    }

    public JFXButton getBuyTicket() {
        return buyTicket;
    }

    public JFXButton getMassage() {
        return massage;
    }
}
