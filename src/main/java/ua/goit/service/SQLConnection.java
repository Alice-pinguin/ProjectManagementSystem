package ua.goit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ua.goit.controller.DataBaseConnection;
import ua.goit.model.BaseEntity;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import ua.goit.repository.BaseRepository;
import ua.goit.utils.PropertiesLoader;

public abstract class SQLConnection<E extends BaseEntity<ID>, ID> implements Closeable, BaseRepository<E, ID> {

    private ObjectMapper objectMapper;
    protected final Connection connection;
    private String tableName;
    private final PreparedStatement findAllPS;

    @SneakyThrows
    public SQLConnection() {
        connection = DataBaseConnection.getInstance().getConnection();
        String databaseSchemaName = PropertiesLoader.getProperty("db.name");
        findAllPS = connection.prepareStatement("SELECT * FROM " + databaseSchemaName + "."
                + tableName);// get info from annotation "entity"
    }

    @SneakyThrows
    @Override
    public List<E> findAll(){
        ResultSet executeQuery = findAllPS.executeQuery();
        //parse to list of E with ObjectMapper
    return findAll();
    }

    @Override
    public Optional<E> findById(ID id){
        //todo
    return findAll().stream().findAny();
    }

    @SneakyThrows
    @Override
    public void close() {
        connection.close();
    }

}
