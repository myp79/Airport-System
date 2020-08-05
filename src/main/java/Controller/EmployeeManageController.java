package Controller;

import Model.Database;
import View.EmployeeManage;

public class EmployeeManageController {

    private EmployeeManage employeeManage;

    public EmployeeManageController() {
        employeeManage = new EmployeeManage();
        employeeManage.getTable().setItems(Database.employeesForTable());
        addBtn();
    }

    public void addBtn() {
        employeeManage.getAdd().setOnAction(actionEvent -> {
            AddEmployeeController addEmployeeController = new AddEmployeeController();
            employeeManage.getScene().setRoot(addEmployeeController.getAddEmployee());
        });
    }

    public EmployeeManage getEmployeeManage() {
        return employeeManage;
    }
}
