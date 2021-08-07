package ua.goit.service;

import ua.goit.controller.DataBaseConnection;
import ua.goit.model.Customers;
import ua.goit.model.Projects;
import ua.goit.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectsService implements BaseRepository<Long, Projects> {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection = dataBaseConnection.getConnection();
    List<Projects> projectsList = new ArrayList<>();


    @Override
    public Projects create(Projects projects) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.projects (id_project ,name, Field) VALUES (?,?,?)");
        create.setLong(1, projects.getId());
        create.setString(2, projects.getName());
        create.setString(2, projects.getField());
        create.setString(2, projects.getCreateDate());
        create.setLong(1, projects.getCost());
        create.executeUpdate();
        create.close();
        return projects;
    }

    @Override
    public Projects update(Long id, Projects projects) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.projects set name=?, Field=?,creation_date=?, cost=? WHERE id_project=" + id + ";");
        update.setString(1, projects.getName());
        update.setString(1, projects.getField());
        update.setString(1, projects.getCreateDate());
        update.setLong(2, projects.getCost());
        update.execute();
        update.close();
        return projects;
    }

    @Override
    public void delete(Long id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement
                ("DELETE from homework.projects where id_project=?");
        delete.execute();
        delete.close();

    }

    @Override
    public Projects findByID(Long aLong) throws SQLException {
        return null;
    }

    @Override
    public List<Projects> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from homework.projects");
        while (resultSet.next()) {
            Projects project = Projects.builder()
                    .id(resultSet.getLong("id_project"))
                    .name(resultSet.getString("name"))
                    .field(resultSet.getString("field"))
                    .cost(resultSet.getLong("cost"))
                    .build();
            projectsList.add(project);
        }
        return projectsList;
    }
}

