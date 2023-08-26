package br.com.eletrica.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/normativas";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "livro";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error while connecting to the database", e);
        }
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
