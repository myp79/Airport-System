package Model;

public class Passenger extends Person implements Showable {

    @Override
    public void show() {
        System.out.println(getName() + " " + getLastname());
    }
}
