package Model;


import java.sql.*;

public class Database {
    private String query;
    private Connection connection;
    private Statement statement;
    private String url = "jdbc:mysql://localhost:3306/StudentSystem";
    private String adminUser = "root";
    private String adminPassword = "19376428";

    public Database() {
        try {
            connection = DriverManager.getConnection(url, adminUser, adminPassword);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

}
