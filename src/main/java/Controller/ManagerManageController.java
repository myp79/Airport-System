package Controller;

import Model.Database;
import Model.Manager;
import View.ManagerManage;

public class ManagerManageController {

    private ManagerManage managerManage;

    public ManagerManageController() {
        managerManage = new ManagerManage();
        managerManage.getTable().setItems(Database.managerForTable());
        addBtn();
        deleteBtn();
    }

    public void addBtn() {
        managerManage.getAdd().setOnAction(actionEvent -> {
            AddManagerController addManagerController = new AddManagerController();
            managerManage.getScene().setRoot(addManagerController.getAddManager());
        });
    }

    public void deleteBtn() {
        managerManage.getDelete().setOnAction(actionEvent -> {
            Manager manager = managerManage.getTable().getSelectionModel().getSelectedItem();
            if (manager != null) {
                Database.delete(manager);
                ManagerManageController managerManageController = new ManagerManageController();
                this.getManagerManage().getScene().setRoot(managerManageController.getManagerManage());
            }
        });
    }

    public ManagerManage getManagerManage() {
        return managerManage;
    }
}
