package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
//    private static DbConn dbConn;
    private static Connection connection = getMysqlConnection();

    private static Connection getMysqlConnection() {
        String userName = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/crud?useLegacyDatetimeCode=false&serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(connectionURL, userName, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getConnection() {
        return connection;
    }
}
