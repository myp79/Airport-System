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
    private static List<Massage> massages=new ArrayList<>();

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

    public static ObservableList<Massage> massagesForTable() {
        Database.massages.clear();
        massages();
        ObservableList<Massage> massages = FXCollections.observableArrayList();
        massages.addAll(Database.massages);
        return massages;
    }
}
