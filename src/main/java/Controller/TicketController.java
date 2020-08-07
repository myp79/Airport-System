package Controller;

import View.TicketView;

public class TicketController {
    private TicketView ticketView;
    private String username;

    public TicketController() {
        ticketView = new TicketView();
    }

    public TicketView getTicketView() {
        return ticketView;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
