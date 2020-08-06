package View;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ManagerView extends BorderPane {
    private JFXButton employeeManage;
    private JFXButton profile;
    private JFXButton passengerManage;
    private JFXButton flightManage;
    private JFXButton massage;
    private JFXButton manger;
    private JFXButton airplane;
    private VBox btnGroup;

    public ManagerView() {
        employeeManage = new JFXButton();
        profile = new JFXButton();
        passengerManage = new JFXButton();
        flightManage = new JFXButton();
        massage = new JFXButton();
        manger = new JFXButton();
        airplane = new JFXButton();
        btnGroup = new VBox();

        // Text
        employeeManage.setText("Employee");
        profile.setText("Profile");
        passengerManage.setText("Passenger");
        flightManage.setText("Flight");
        massage.setText("Massage");
        manger.setText("Manager");
        airplane.setText("Airplane");

        // Add all to the btnGroup
        btnGroup.getChildren().addAll(employeeManage, profile, passengerManage, airplane,flightManage, massage);
        btnGroup.setAlignment(Pos.CENTER);

        // Setting of Manager View
        this.setCenter(btnGroup);
    }

    public JFXButton getEmployeeManage() {
        return employeeManage;
    }

    public JFXButton getProfile() {
        return profile;
    }

    public JFXButton getPassengerManage() {
        return passengerManage;
    }

    public JFXButton getFlightManage() {
        return flightManage;
    }

    public JFXButton getMassage() {
        return massage;
    }

    public JFXButton getManger() {
        return manger;
    }

    public VBox getBtnGroup() {
        return btnGroup;
    }

    public JFXButton getAirplane() {
        return airplane;
    }
}
