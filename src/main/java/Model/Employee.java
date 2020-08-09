package Model;

public class Employee extends Person implements Showable {

    @Override
    public void show() {
        System.out.println(getName() + " " + getLastname());
    }
}
