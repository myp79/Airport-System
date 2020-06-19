package Controller;

import View.LoginView;

public class LoginController {
    private LoginView loginView;

    public LoginController(){
        loginView=new LoginView();
    }

    public LoginView getLoginView() {
        return loginView;
    }
}
