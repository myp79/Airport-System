package Model;

import java.sql.*;

public class Database {
    private static Connection connection;
    private static Statement statement;
    private static String url = "jdbc:mysql://localhost:3306/StudentSystem";
    private static String adminUser = "root";
    private static String adminPassword = "19376428";

    public static String check(String username, String password){
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM person WHERE 'password'="+password);
            while (resultSet.next()){
                if (resultSet.getString("username").equals(username)){
                    return resultSet.getString("roll");
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
