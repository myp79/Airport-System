package Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Flight implements Showable {
    @Override
    public void show() {
        System.out.println(id + " " + source + " " + destination);
    }

    private String id;
    private String airplane;
    private String ticket;
    private String source;
    private String destination;
    private LocalDate date;
    private LocalTime time;
    private String no;
    private ArrayList<Passenger> passengers;
    private String duration;
    private FlightStatus status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public FlightStatus getStatus() {
        return status;
    }
}
