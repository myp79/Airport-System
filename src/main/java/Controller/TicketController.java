package Controller;

import View.TicketView;

public class TicketController {
    private TicketView ticketView;
    private String username;

    public TicketController() {
        ticketView = new TicketView();
        addBtn();
    }

    public void addBtn() {
        ticketView.getAdd().setOnAction(actionEvent -> {
            AddTicketController addTicketController = new AddTicketController();
            ticketView.getScene().setRoot(addTicketController.getAddTicket());
        });
    }

    public TicketView getTicketView() {
        return ticketView;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
