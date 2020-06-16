package Model;

public abstract class Person {
    public String id;
    public String name;
    public String lastname;
    public String username;
    public String password;
    public String email;

    public abstract String getId();

    public abstract String getName();

    public abstract String getLastname();

    public abstract String getUsername();

    public abstract String getPassword();

    public abstract String getEmail();
}
