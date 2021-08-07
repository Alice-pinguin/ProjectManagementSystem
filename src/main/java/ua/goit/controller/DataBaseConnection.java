package ua.goit.controller;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.SneakyThrows;
import ua.goit.utils.PropertiesLoader;

import java.io.Closeable;
import java.sql.Connection;



public class DataBaseConnection  implements Closeable {

    private static final String user_name = PropertiesLoader.getProperty("name");
    private static final String password = PropertiesLoader.getProperty("password");
    private static final String URL = PropertiesLoader.getProperty("url");
    private static final String JDBC_DRIVER = PropertiesLoader.getProperty("driver");
    private static Connection connection;
    private HikariDataSource dataSource;

    public DataBaseConnection(){
        connection = createDataSource();
    }

    @SneakyThrows
    public Connection getConnection() {
        return dataSource.getConnection();
    }

    private Connection createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setDriverClassName(JDBC_DRIVER);
        config.setUsername(user_name);
        config.setPassword(password);
        config.setMaximumPoolSize(10);
        config.setIdleTimeout(10_000);
        config.setConnectionTimeout(10_000);
        dataSource = new HikariDataSource(config);
        return connection;
    }

    @SneakyThrows
    @Override
    public void close() {
        getConnection().close();
    }

}