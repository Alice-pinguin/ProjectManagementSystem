package ua.goit.service.maintables;

import java.sql.SQLException;
import java.util.List;

public interface SQLExecutor<T>{

    void create(T t) throws SQLException;

    List<T> read(long id) throws SQLException;

    void update(long id, T t) throws SQLException;

    void delete(long id) throws SQLException;


}
