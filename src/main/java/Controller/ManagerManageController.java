package Controller;

import View.ManagerManage;

public class ManagerManageController {

    private ManagerManage managerManage;

    public ManagerManageController() {
        managerManage = new ManagerManage();
        addBtn();
    }

    public void addBtn() {
        managerManage.getAdd().setOnAction(actionEvent -> {
            AddManagerController addManagerController = new AddManagerController();
            managerManage.getScene().setRoot(addManagerController.getAddManager());
        });
    }

    public ManagerManage getManagerManage() {
        return managerManage;
    }
}
