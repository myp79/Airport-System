package Controller;

import Model.Database;
import View.AddManager;
import javafx.scene.control.Alert;

public class AddManagerController {

    private AddManager addManager;

    public AddManagerController() {
        addManager = new AddManager();
        submitBtn();
    }

    public void submitBtn(){
        addManager.getSubmit().setOnAction(actionEvent -> {
            String name = addManager.getName().getText();
            String lastname = addManager.getLastname().getText();
            String email = addManager.getEmail().getText();
            String idcard = addManager.getIdCard().getText();
            String username = addManager.getUsername().getText();
            String password = addManager.getPassword().getText();
            String address=addManager.getAddress().getText();
            if (email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])")){
                Database.add(name,lastname,email,address,idcard,0,username,password,"manager");
                ManagerManageController managerManageController=new ManagerManageController();
                addManager.getScene().setRoot(managerManageController.getManagerManage());
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Email Error");
                alert.setContentText("Email has wrong pattern. Check it.");
                alert.show();
            }
        });

    }

    public AddManager getAddManager() {
        return addManager;
    }
}
