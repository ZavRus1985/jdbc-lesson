package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/lesson_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ruslan";

    public static final Connection CONNECTION;

    static {
        try {
            CONNECTION = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
