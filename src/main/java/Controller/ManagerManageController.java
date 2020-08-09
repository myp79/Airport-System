package Controller;

import Model.Database;
import Model.Manager;
import Model.Manager;
import View.ManagerManage;
import javafx.scene.control.Alert;

public class ManagerManageController {

    private ManagerManage managerManage;

    public ManagerManageController() {
        managerManage = new ManagerManage();
        managerManage.getTable().setItems(Database.managerForTable());
        addBtn();
        deleteBtn();
        editBtn();
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
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Select Error");
                alert.setContentText("Please Select an item.");
                alert.show();
            }
        });
    }

    public void editBtn() {
        managerManage.getEdit().setOnAction(actionEvent -> {
            Manager manager = managerManage.getTable().getSelectionModel().getSelectedItem();
            if (manager != null) {
                PersonEditController personEditController = new PersonEditController();
                managerManage.getScene().setRoot(personEditController.getPersonEdit());
                personEditController.getPersonEdit().getIdCard().setText(manager.getId());
                personEditController.getPersonEdit().getAddress().setText(manager.getAddress());
                personEditController.getPersonEdit().getEmail().setText(manager.getEmail());
                personEditController.getPersonEdit().getName().setText(manager.getName());
                personEditController.getPersonEdit().getLastname().setText(manager.getLastname());
                personEditController.getPersonEdit().getMoney().setText(Integer.toString(manager.getMoney()));
                personEditController.setRoll(Manager.class.getTypeName());
                personEditController.setUsername(manager.getUsername());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Select Error");
                alert.setContentText("Please Select an item.");
                alert.show();
            }
        });
    }

    public ManagerManage getManagerManage() {
        return managerManage;
    }
}
