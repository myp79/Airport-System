package Model;

import java.util.List;

public class Airplane implements Showable {
    @Override
    public void show() {

    }

    private String id;
    private int chairs;
    private List<Flight> flightList;

    public String getId() {
        return id;
    }

    public int getChairs() {
        return chairs;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }
}
