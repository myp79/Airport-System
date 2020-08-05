package Controller;

import Model.Database;
import Model.Massage;
import View.MassageManage;

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
            }
        });
    }

    public MassageManage getMassageManage() {
        return massageManage;
    }
}
