package Model;

public class Manager extends Person implements Showable {
    @Override
    public void show() {
        System.out.println(getName() + " " + getLastname());
    }
}
