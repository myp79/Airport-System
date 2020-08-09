package Controller;

import Model.Database;
import Model.Employee;
import View.EmployeeManage;
import javafx.scene.control.Alert;

public class EmployeeManageController {

    private EmployeeManage employeeManage;

    public EmployeeManageController() {
        employeeManage = new EmployeeManage();
        employeeManage.getTable().setItems(Database.employeesForTable());
        addBtn();
        deleteBtn();
        editBtn();
    }

    public void addBtn() {
        employeeManage.getAdd().setOnAction(actionEvent -> {
            AddEmployeeController addEmployeeController = new AddEmployeeController();
            employeeManage.getScene().setRoot(addEmployeeController.getAddEmployee());
        });
    }

    public void deleteBtn() {
        employeeManage.getDelete().setOnAction(actionEvent -> {
            Employee employee = employeeManage.getTable().getSelectionModel().getSelectedItem();
            if (employee != null) {
                Database.delete(employee);
                EmployeeManageController employeeManageController = new EmployeeManageController();
                this.getEmployeeManage().getScene().setRoot(employeeManageController.getEmployeeManage());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Select Error");
                alert.setContentText("Please Select an item.");
                alert.show();
            }
        });
    }

    public void editBtn() {
        employeeManage.getEdit().setOnAction(actionEvent -> {
            Employee employee = employeeManage.getTable().getSelectionModel().getSelectedItem();
            if (employee != null) {
                PersonEditController personEditController = new PersonEditController();
                employeeManage.getScene().setRoot(personEditController.getPersonEdit());
                personEditController.getPersonEdit().getIdCard().setText(employee.getId());
                personEditController.getPersonEdit().getAddress().setText(employee.getAddress());
                personEditController.getPersonEdit().getEmail().setText(employee.getEmail());
                personEditController.getPersonEdit().getName().setText(employee.getName());
                personEditController.getPersonEdit().getLastname().setText(employee.getLastname());
                personEditController.getPersonEdit().getMoney().setText(Integer.toString(employee.getMoney()));
                personEditController.setRoll(Employee.class.getTypeName());
                personEditController.setUsername(employee.getUsername());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Select Error");
                alert.setContentText("Please Select an item.");
                alert.show();
            }
        });
    }


    public EmployeeManage getEmployeeManage() {
        return employeeManage;
    }
}
