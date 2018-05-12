
package Utility;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class DBConnection {

    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/emojo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME,
                        PASSWORD);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}