package ru.lkodos.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

     private static final String URL = "db.url";
     private static final String USER = "db.user";
     private static final String PASS = "db.password";

    private ConnectionManager() {

    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.getProperties(URL),
                    PropertiesUtil.getProperties(USER),
                    PropertiesUtil.getProperties(PASS)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
