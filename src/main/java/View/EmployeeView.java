package View;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class EmployeeView extends BorderPane {
    private JFXButton profile;
    private JFXButton flightManage;
    private JFXButton massage;

    public EmployeeView() {
        profile = new JFXButton();
        flightManage = new JFXButton();
        massage = new JFXButton();
        VBox btnGroup = new VBox();

        // Text
        profile.setText("Profile");
        flightManage.setText("Flight");
        massage.setText("Massage");

        // Add all to the btnGroup
        btnGroup.getChildren().addAll(profile, flightManage, massage);
        btnGroup.setAlignment(Pos.CENTER);

        // Setting of Manager View
        this.setCenter(btnGroup);
    }

    public JFXButton getProfile() {
        return profile;
    }

    public JFXButton getFlightManage() {
        return flightManage;
    }

    public JFXButton getMassage() {
        return massage;
    }
}
