package ua.goit.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ua.goit.controller.DataBaseConnection;
import ua.goit.model.BaseEntity;

import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


import ua.goit.repository.BaseRepository;
import ua.goit.utils.PropertiesLoader;

import javax.persistence.Entity;

public abstract class SQLConnection<E extends BaseEntity<ID>, ID> implements Closeable, BaseRepository<E, ID> {

    protected final Connection connection;
    private final ObjectMapper objectMapper;
    private final Class<E> entityClass;
    private  String databaseSchemaName;
    private String tableName;
    private String [] columns;
    private final PreparedStatement findAllPS;
    private final  PreparedStatement findBiIdPS;
    private final PreparedStatement deleteByIdPS;
    private final PreparedStatement createPS;
    private final PreparedStatement updateById;

    @SneakyThrows
    public SQLConnection(String tableName, String...columns) {
        connection = DataBaseConnection.getInstance().getConnection();
        this.objectMapper = new ObjectMapper();
        entityClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        databaseSchemaName = PropertiesLoader.getProperty("db.name");
        this.tableName = tableName; //   tableName =entityClass.getAnnotation(Entity.class)
        this.columns = columns;
        findAllPS = connection.prepareStatement("select* from " + databaseSchemaName + "." + tableName);
        findBiIdPS = connection.prepareStatement("select* from " + databaseSchemaName+"."+tableName+ " where id=?;");
        deleteByIdPS = connection.prepareStatement("delete from" + databaseSchemaName + "." + tableName + " where id=?;");
        createPS = connection.prepareStatement("insert into " + databaseSchemaName + "." + tableName + " VALUES ?,?");
        updateById = connection.prepareStatement("update " + databaseSchemaName + "." + tableName + " SET " +  " WHERE id=?");

    }

    @SneakyThrows
    @Override
    public E create(E e) {

        return e;
    }

    @SneakyThrows
    @Override
    public E update(E e) {
        return e;
    }

    @SneakyThrows
    @Override
    public void deleteById(ID id) {
        deleteByIdPS.setObject(1, id);
        deleteByIdPS.executeUpdate();

    }
    @SneakyThrows
    @Override
    public List<E> findAll(){
        return convertTo(findAllPS.executeQuery());
    }

    @SneakyThrows
    @Override
    public Optional<E> findById(ID id){
        findBiIdPS.setObject(1, id);
        List<E> byId = convertTo(findBiIdPS.executeQuery());
        return  Optional.of(byId.get(0));
    }

    @SneakyThrows
    public List<E> convertTo(ResultSet resultSet) {
        final List<E> all = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> objectMap = new HashMap<>();
            for (String column : columns) {
                objectMap.put(column, resultSet.getObject(column));
            }
            all.add(objectMapper.convertValue(objectMap, entityClass));
        }
        return all;
    }

    @SneakyThrows
    @Override
    public void close() {
        connection.close();
    }

}
