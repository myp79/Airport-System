package Controller;

import Model.Database;
import Model.Flight;
import Model.Ticket;
import View.AddTicket;

import java.util.Random;

public class AddTicketController {

    private AddTicket addTicket;
    private String username;

    public AddTicketController() {
        addTicket = new AddTicket();
        addTicket.getTable().setItems(Database.flightsForTable());
        submitBtn();
    }

    public void submitBtn() {
        addTicket.getSubmit().setOnAction(actionEvent -> {
            Flight flight = addTicket.getTable().getSelectionModel().getSelectedItem();
            String number = addTicket.getNumber().getText();
            if (flight != null) {
                Database.update(flight, Integer.parseInt(number));
                for (int i = 0; i < Integer.parseInt(number); i++) {
                    Random random = new Random();
                    int ticketId = random.nextInt(1000000);
                    Ticket ticket = new Ticket();
                    ticket.setId(Integer.toString(ticketId));
                    Database.add(ticket, username, flight);
                }
                TicketController ticketController = new TicketController(username);
                addTicket.getScene().setRoot(ticketController.getTicketView());
            }
        });
    }

    public AddTicket getAddTicket() {
        return addTicket;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
