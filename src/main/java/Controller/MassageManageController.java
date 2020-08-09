package Controller;

import Model.Database;
import Model.Massage;
import View.MassageManage;
import javafx.scene.control.Alert;

public class MassageManageController {
    private MassageManage massageManage;

    public MassageManageController() {
        massageManage = new MassageManage();
        massageManage.getTableView().setItems(Database.massagesForTable());
        deleteBtn();
    }

    public void deleteBtn() {
        massageManage.getDelete().setOnAction(actionEvent -> {
            Massage massage = massageManage.getTableView().getSelectionModel().getSelectedItem();
            if (massage != null) {
                Database.delete(massage);
                MassageManageController massageManageController = new MassageManageController();
                this.getMassageManage().getScene().setRoot(massageManageController.getMassageManage());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Select Error");
                alert.setContentText("Please Select an item.");
                alert.show();
            }
        });
    }

    public MassageManage getMassageManage() {
        return massageManage;
    }
}
