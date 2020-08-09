package Controller;

import Model.*;
import View.PersonEdit;
import javafx.scene.control.Alert;

public class PersonEditController {

    private PersonEdit personEdit;
    private String roll;
    private String username;

    public PersonEditController() {
        personEdit = new PersonEdit();
        submitBtn();
    }

    public void submitBtn() {
        personEdit.getSubmit().setOnAction(actionEvent -> {
            Person person;
            if (roll.equals("Model.Manager")) {
                person = new Manager();
            } else if (roll.equals("Model.Employee")) {
                person = new Employee();
            } else {
                person = new Passenger();
            }
            person.setId(personEdit.getIdCard().getText());
            person.setAddress(personEdit.getAddress().getText());
            person.setEmail(personEdit.getEmail().getText());
            person.setLastname(personEdit.getLastname().getText());
            person.setName(personEdit.getName().getText());
            person.setMoney(Integer.parseInt(personEdit.getMoney().getText()));
            person.setUsername(username);
            if (!person.getName().equals("") && !person.getLastname().equals("") && !person.getEmail().equals("") && !person.getId().equals("") && !person.getAddress().equals("") && !Integer.toString(person.getMoney()).equals("")) {
                if (person.getName().matches("\\D+")) {
                    if (person.getLastname().matches("\\D+")) {
                        if (person.getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])")) {
                            if (!person.getId().matches("\\d+\\D+")) {
                                if (!Integer.toString(person.getMoney()).matches("\\d+\\D+")) {
                                    Database.update(person);
                                } else {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Money Error");
                                    alert.setContentText("ID have number and word. Check it.");
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
            if (roll.equals("Model.Manager")) {
                ManagerManageController managerManageController = new ManagerManageController();
                personEdit.getScene().setRoot(managerManageController.getManagerManage());
            } else if (roll.equals("Model.Employee")) {
                EmployeeManageController employeeManageController = new EmployeeManageController();
                personEdit.getScene().setRoot(employeeManageController.getEmployeeManage());
            } else {
                PassengerManageController passengerManageController = new PassengerManageController();
                personEdit.getScene().setRoot(passengerManageController.getPassengerManage());
            }
        });
    }

    public PersonEdit getPersonEdit() {
        return personEdit;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
