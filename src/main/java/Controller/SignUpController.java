package Controller;

import Model.Database;
import View.SignUpView;
import javafx.scene.control.Alert;

public class SignUpController {
    private SignUpView signUpView;

    public SignUpController() {
        signUpView = new SignUpView();
        submitBtn();
    }

    public void submitBtn() {
        signUpView.getSubmit().setOnAction(actionEvent -> {
            String name = signUpView.getName().getText();
            String lastname = signUpView.getLastname().getText();
            String email = signUpView.getEmail().getText();
            String idcard = signUpView.getIdCard().getText();
            String username = signUpView.getUsername().getText();
            String password = signUpView.getPassword().getText();
            if (email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])")){
                Database.add(name, lastname, email, idcard, username, password, "passenger");
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Email Error");
                alert.setContentText("Email has wrong pattern. Check it.");
                alert.show();
            }
        });
    }

    public SignUpView getSignUpView() {
        return signUpView;
    }
}
