package Model;

public class Ticket implements Showable {
    @Override
    public void show() {

    }
    private String id;
    private String price;
    private String crime;

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
}
