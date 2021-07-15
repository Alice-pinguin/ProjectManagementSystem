package controller;

import lombok.SneakyThrows;
import utils.PropertiesLoader;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection  implements Closeable {

    private static final String user_name = PropertiesLoader.getProperty("name");
    private static final String password = PropertiesLoader.getProperty("password");
    private static final String URL = PropertiesLoader.getProperty("url");
    private static final String JDBC_DRIVER = PropertiesLoader.getProperty("driver");
    private static DataBaseConnection dataBaseConnection;
    private  Connection connection;


    public DataBaseConnection()throws SQLException {
        try {
            Class.forName(JDBC_DRIVER);
        }  catch (ClassNotFoundException e) {
            throw new ClassCastException("No data found");
        }
        this.connection = DriverManager.getConnection(URL, user_name, password);
    }


    private DataBaseConnection getInstance() throws SQLException {
        if (dataBaseConnection == null || getConnection().isClosed()) {
            dataBaseConnection = new DataBaseConnection();
        }
        return dataBaseConnection;
    }

    private  Connection getConnection() {
       return connection;
    }




    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
           throw new RuntimeException("Connection doesn't closed");
        }

    }
}



