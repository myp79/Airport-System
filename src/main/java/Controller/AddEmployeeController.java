package Controller;

import Model.Database;
import View.AddEmployee;
import javafx.scene.control.Alert;

public class AddEmployeeController {

    private AddEmployee addEmployee;

    public AddEmployeeController() {
        addEmployee = new AddEmployee();
        submitBtn();
    }

    public void submitBtn() {
        addEmployee.getSubmit().setOnAction(actionEvent -> {
            String name = addEmployee.getName().getText();
            String lastname = addEmployee.getLastname().getText();
            String email = addEmployee.getEmail().getText();
            String idcard = addEmployee.getIdCard().getText();
            String username = addEmployee.getUsername().getText();
            String password = addEmployee.getPassword().getText();
            String address = addEmployee.getAddress().getText();
            if (email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])")) {
                Database.add(name, lastname, email, address, idcard, 0, username, password, "employee");
                EmployeeManageController employeeManageController = new EmployeeManageController();
                addEmployee.getScene().setRoot(employeeManageController.getEmployeeManage());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Email Error");
                alert.setContentText("Email has wrong pattern. Check it.");
                alert.show();
            }
        });

    }

    public AddEmployee getAddEmployee() {
        return addEmployee;
    }
}