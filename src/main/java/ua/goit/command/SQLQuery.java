package ua.goit.command;

import ua.goit.model.BaseEntity;

import java.sql.SQLException;
import java.util.List;

public interface SQLQuery <ID,E extends BaseEntity<ID>> {

    Long getTotalSalaryDevelopersByProject(Long id) throws SQLException;

    List<E> getDeveloperByLevel(String level) throws SQLException;

    List<E> getDevelopersBySkill(String skill);

    List<E> projectsWithCountDevelopers();

    List<E> getDevelopersByProjectID(Long id) throws SQLException;

}

