package Controller;

import View.ManagerView;

public class ManagerController {
    ManagerView managerView;

    public ManagerController(String roll) {
        managerView = new ManagerView();
        if (roll.equals("admin")){
            managerView.getBtnGroup().getChildren().addAll(managerView.getManger());
        }
    }

    public ManagerView getManagerView() {
        return managerView;
    }
}
