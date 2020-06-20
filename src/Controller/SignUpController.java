package Controller;

import View.SignUpView;

public class SignUpController {
    SignUpView signUpView;

    public SignUpController(){
        signUpView=new SignUpView();
    }

    public SignUpView getSignUpView() {
        return signUpView;
    }
}
