package Controller;

import Model.Database;
import View.TicketView;

public class TicketController {
    private TicketView ticketView;
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    public TicketController() {
        ticketView = new TicketView();
        // problem for user
        ticketView.getTable().setItems(Database.ticketsForTable());
        addBtn();
    }

    public void addBtn() {
        ticketView.getAdd().setOnAction(actionEvent -> {
            AddTicketController addTicketController = new AddTicketController();
            addTicketController.setUsername(username);
            ticketView.getScene().setRoot(addTicketController.getAddTicket());
        });
    }

    public TicketView getTicketView() {
        return ticketView;
    }


}
