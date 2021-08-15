package ua.goit.service;

import ua.goit.model.BaseEntity;

import java.sql.SQLException;
import java.util.List;

public interface SQLExecutor<E extends BaseEntity<ID>, ID> {

    Long getTotalSalaryDevelopersByProject(Long id) throws SQLException;

    List<E> getListOfDevelopersForProject(Long id) throws SQLException;

    List<E> getDevelopersBySkill(String skill) throws SQLException;

    List<E> getDeveloperByLevel(String level) throws SQLException;

    List<E> projectWithCountDevAndDate();



}

