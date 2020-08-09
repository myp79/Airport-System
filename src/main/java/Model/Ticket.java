package Model;

public class Ticket implements Showable {
    @Override
    public void show() {
        System.out.println(id + " " + flightId);
    }

    private String id;
    private String price;
    private String crime;
    private String flightId;
    private String person;

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getCrime() {
        return crime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
