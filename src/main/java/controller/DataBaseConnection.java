package controller;

import lombok.SneakyThrows;

import utils.PropertiesLoader;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection  implements Closeable {

    private static final String user_name = PropertiesLoader.getProperty("name");
    private static final String password = PropertiesLoader.getProperty("password");
    private static final String URL = PropertiesLoader.getProperty("url");
    private static final String JDBC_DRIVER = PropertiesLoader.getProperty("driver");
    private static DataBaseConnection dataBaseConnection;
    private static Connection connection;

    @SneakyThrows
    private DataBaseConnection() {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(URL, user_name, password);
    }

    @SneakyThrows
    public static DataBaseConnection getInstance() {
        if (dataBaseConnection == null || getConnection().isClosed()) {
            dataBaseConnection = new DataBaseConnection();
        }
        return dataBaseConnection;
    }

    public static Connection getConnection() {
        return connection;
    }

    @SneakyThrows
    @Override
    public void close() {
        connection.close();
    }
}




