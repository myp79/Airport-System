package Controller;

import Model.Database;
import Model.Ticket;
import View.TicketView;
import javafx.scene.control.Alert;

public class TicketController {
    private TicketView ticketView;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }


    public TicketController(String username) {
        ticketView = new TicketView();
        ticketView.getTable().setItems(Database.ticketsForTable(username));
        addBtn();
        deleteBtn();
    }

    public void addBtn() {
        ticketView.getAdd().setOnAction(actionEvent -> {
            AddTicketController addTicketController = new AddTicketController();
            addTicketController.setUsername(username);
            ticketView.getScene().setRoot(addTicketController.getAddTicket());
        });
    }

    public void deleteBtn() {
        ticketView.getDelete().setOnAction(actionEvent -> {
            Ticket ticket = ticketView.getTable().getSelectionModel().getSelectedItem();
            if (ticket != null) {
                Database.delete(ticket);
                TicketController ticketController = new TicketController(username);
                ticketController.setUsername(username);
                this.getTicketView().getScene().setRoot(ticketController.getTicketView());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Select Error");
                alert.setContentText("Please Select an item.");
                alert.show();
            }
        });
    }

    public TicketView getTicketView() {
        return ticketView;
    }

    public String getUsername() {
        return username;
    }
}
