package Controller;

import Model.Database;
import Model.Passenger;
import Model.Person;
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
            String address = signUpView.getAddress().getText();
            if (!name.equals("") && !lastname.equals("") && !email.equals("") && !idcard.equals("") && !username.equals("") && !password.equals("") && !address.equals("")) {
                if (name.matches("\\D+")) {
                    if (lastname.matches("\\D+")) {
                        if (email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])")) {
                            if (!idcard.matches("\\d+\\D+")) {
                                if (Database.check(username)) {
                                    Person person = new Passenger();
                                    person.setName(name);
                                    person.setLastname(lastname);
                                    person.setEmail(email);
                                    person.setAddress(address);
                                    person.setId(idcard);
                                    person.setMoney(0);
                                    person.setUsername(username);
                                    person.setPassword(password);
                                    Database.add(person, "passenger");
                                    LoginController loginController = new LoginController();
                                    signUpView.getScene().setRoot(loginController.getLoginView());
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("User Error");
                                    alert.setContentText("Username exist.");
                                    alert.show();
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("ID Error");
                                alert.setContentText("ID have number and word. Check it.");
                                alert.show();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Email Error");
                            alert.setContentText("Email has wrong pattern. Check it.");
                            alert.show();
                        }
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("LastName Error");
                        alert.setContentText("LastName has number . Check it.");
                        alert.show();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Name Error");
                    alert.setContentText("Name has number . Check it.");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Null Error");
                alert.setContentText("All field required . Check it.");
                alert.show();
            }
        });
    }

    public SignUpView getSignUpView() {
        return signUpView;
    }
}
