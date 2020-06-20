package Controller;

import Model.Database;
import View.SignUpView;

public class SignUpController {
    SignUpView signUpView;

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
            Database.add(name, lastname, email, idcard, username, password, "passenger");
        });
    }

    public SignUpView getSignUpView() {
        return signUpView;
    }
}
