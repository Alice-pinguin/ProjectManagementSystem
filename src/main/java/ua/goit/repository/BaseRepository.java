package ua.goit.repository;

import ua.goit.model.BaseEntity;
import ua.goit.model.Companies;


import java.sql.SQLException;
import java.util.List;


public interface BaseRepository<ID,E extends BaseEntity<ID>> {

    E create (E e) throws SQLException;

    E update(ID id,E e) throws SQLException;

    void delete(ID id) throws SQLException;

    E findByID(ID id) throws SQLException;

    List<E> findAll() throws SQLException;
}
