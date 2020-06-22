package Model;

import java.sql.*;

public class Database {
    private static Connection connection;
    private static Statement statement;
    private static String url = "jdbc:mysql://localhost:3306/Airport";
    private static String adminUser = "root";
    private static String adminPassword = "19376428";

    public static String check(String username, String password) {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM person WHERE password = '%s'",password));
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

    public static void add(String name, String lastname, String email, String idcard, String username, String password, String roll) {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            statement.executeUpdate(String.format("INSERT INTO person (name, lastname, email, idcard, username, password, roll) VALUES('%s','%s','%s','%s','%s','%s','%s')", name, lastname, email, idcard, username, password, roll));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
