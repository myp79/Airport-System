package Controller;

import Model.Ticket;
import View.AddTicket;

public class AddTicketController {

    private AddTicket addTicket;

    public AddTicketController() {
        addTicket = new AddTicket();
        submitBtn();
    }

    public void submitBtn() {
        addTicket.getSubmit().setOnAction(actionEvent -> {
            String date = addTicket.getDate().getText();
            String number = addTicket.getDate().getText();
            Ticket ticket = new Ticket();
            // Some problem here
            TicketController ticketController = new TicketController();
            addTicket.getScene().setRoot(ticketController.getTicketView());
        });
    }

    public AddTicket getAddTicket() {
        return addTicket;
    }
}
