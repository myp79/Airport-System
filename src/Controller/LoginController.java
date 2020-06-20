package Controller;

import View.LoginView;

public class LoginController {
    private LoginView loginView;

    public LoginController() {
        loginView = new LoginView();
    }
    public void submitBtn(){
        loginView.getSubmit().setOnAction(actionEvent -> {
        });
    }
    public LoginView getLoginView() {
        return loginView;
    }
}
