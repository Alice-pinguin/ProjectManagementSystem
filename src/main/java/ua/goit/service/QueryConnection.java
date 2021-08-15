package ua.goit.service;

import lombok.Getter;
import lombok.SneakyThrows;
import ua.goit.controller.DataBaseConnection;
import ua.goit.model.BaseEntity;

import java.io.Closeable;
import java.sql.Connection;


public abstract class QueryConnection<E extends BaseEntity<Long>> implements Closeable {

    @Getter
    protected final Connection connection;

    @SneakyThrows
    public QueryConnection() {
        connection = DataBaseConnection.getInstance().getConnection();

    }

    @SneakyThrows
    @Override
    public void close() {
        connection.close();
    }
}
