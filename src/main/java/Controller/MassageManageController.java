package Controller;

import Model.Database;
import View.MassageManage;

public class MassageManageController {
    private MassageManage massageManage;

    public MassageManageController() {
        massageManage = new MassageManage();
        massageManage.getTableView().setItems(Database.massagesForTable());
    }


    public MassageManage getMassageManage() {
        return massageManage;
    }
}
