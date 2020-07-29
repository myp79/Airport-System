package Model;

import java.util.ArrayList;

public class Flight implements Showable {
    @Override
    public void show() {

    }

    private String id;
    private Airplane airplane;
    private Ticket ticket;
    private String source;
    private String destination;
    private String date;
    private String time;
    private String no;
    private ArrayList<Passenger> passengers;
    private String duration;
}
