package Controller;

import Model.*;
import View.PersonEdit;

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
            Database.update(person);
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
