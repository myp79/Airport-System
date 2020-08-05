package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static Connection connection;
    private static Statement statement;
    private static String url = "jdbc:mysql://localhost:3306/Airport";
    private static String adminUser = "root";
    private static String adminPassword = "19376428";
    private static List<Massage> massages = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    private static List<Manager> managers = new ArrayList<>();
    private static List<Passenger> passengers = new ArrayList<>();

    public static String check(String username, String password) {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM person WHERE password = '%s'", password));
            while (resultSet.next()) {
                if (resultSet.getString("username").equals(username)) {
                    return resultSet.getString("roll");
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void add(String name, String lastname, String email, String address, String idcard, int money, String username, String password, String roll) {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            statement.executeUpdate(String.format("INSERT INTO person (name, lastname, email, idcard, address, money, username, password, roll) VALUES('%s','%s','%s','%s','%s',%d,'%s','%s','%s')", name, lastname, email, idcard, address, money, username, password, roll));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String username, String password) {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            statement.executeUpdate(String.format("UPDATE person SET password = '%s' WHERE username='%s'", password, username));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void update(String username, int money) {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            statement.executeUpdate(String.format("UPDATE person SET money=%d WHERE username='%s'", money, username));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void add(String username, String massage) {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            statement.executeUpdate(String.format("INSERT INTO massage (username,massage) VALUES('%s','%s')", username, massage));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void massages() {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM massage");
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String userMassage = resultSet.getString("massage");
                Massage massage = new Massage();
                massage.setUsername(username);
                massage.setMassage(userMassage);
                massages.add(massage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void employees() {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person WHERE roll='employee'");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String id = resultSet.getString("idcard");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String money = resultSet.getString("money");
                Employee employee = new Employee();
                employee.setName(name);
                employee.setLastname(lastname);
                employee.setEmail(email);
                employee.setId(id);
                employee.setUsername(username);
                employee.setPassword(password);
                employee.setAddress(address);
                employee.setMoney(Integer.parseInt(money));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void managers() {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person WHERE roll='manager'");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String id = resultSet.getString("idcard");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String money = resultSet.getString("money");
                Manager manager = new Manager();
                manager.setName(name);
                manager.setLastname(lastname);
                manager.setEmail(email);
                manager.setId(id);
                manager.setUsername(username);
                manager.setPassword(password);
                manager.setAddress(address);
                manager.setMoney(Integer.parseInt(money));
                managers.add(manager);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void passengers() {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person WHERE roll='passenger'");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String id = resultSet.getString("idcard");
                String address = resultSet.getString("address");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String money = resultSet.getString("money");
                Passenger passenger = new Passenger();
                passenger.setName(name);
                passenger.setLastname(lastname);
                passenger.setEmail(email);
                passenger.setId(id);
                passenger.setUsername(username);
                passenger.setPassword(password);
                passenger.setAddress(address);
                passenger.setMoney(Integer.parseInt(money));
                passengers.add(passenger);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Massage massage) {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            statement.executeUpdate(String.format("DELETE FROM massage WHERE username='%s' and massage='%s'", massage.getUsername(), massage.getMassage()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Person person) {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            statement.executeUpdate(String.format("DELETE FROM person WHERE username='%s'", person.getUsername()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Massage> massagesForTable() {
        Database.massages.clear();
        massages();
        ObservableList<Massage> massages = FXCollections.observableArrayList();
        massages.addAll(Database.massages);
        return massages;
    }

    public static ObservableList<Employee> employeesForTable() {
        Database.employees.clear();
        employees();
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        employees.addAll(Database.employees);
        return employees;
    }

    public static ObservableList<Manager> managerForTable() {
        Database.managers.clear();
        managers();
        ObservableList<Manager> managers = FXCollections.observableArrayList();
        managers.addAll(Database.managers);
        return managers;
    }

    public static ObservableList<Passenger> passengerForTable() {
        Database.passengers.clear();
        passengers();
        ObservableList<Passenger> passengers = FXCollections.observableArrayList();
        passengers.addAll(Database.passengers);
        return passengers;
    }
}
