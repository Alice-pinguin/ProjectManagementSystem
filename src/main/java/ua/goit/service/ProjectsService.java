package ua.goit.service;

import ua.goit.controller.DataBaseConnection;
import ua.goit.model.Developers;
import ua.goit.model.Projects;
import ua.goit.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProjectsService implements BaseRepository<Long, Projects> {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection = dataBaseConnection.getConnection();
    List<Projects> projectsList = new ArrayList<>();


    @Override
    public Projects create(Projects projects) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.projects (id_project ,name, Field,creation_date, cost) VALUES (?,?,?,?,?)");
        create.setLong(1, projects.getId_project());
        create.setString(2, projects.getName());
        create.setString(3, projects.getField());
        create.setString(4, projects.getCreateDate());
        create.setLong(5, projects.getCost());
        create.executeUpdate();
        create.close();
        return projects;
    }

    @Override
    public Projects update(Long id, Projects projects) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.projects set name=?, Field=?,creation_date=?, cost=? WHERE id_project=" + id + ";");
        update.setString(1, projects.getName());
        update.setString(2, projects.getField());
        update.setString(3, projects.getCreateDate());
        update.setLong(4, projects.getCost());
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
    public Projects findByID(Long id) throws SQLException {
        return projectsList.get(Math.toIntExact(id));
    }

    @Override
    public List<Projects> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from homework.projects");
        while (resultSet.next()) {
            Projects project = Projects.builder()
                    .id_project(resultSet.getLong("id_project"))
                    .name(resultSet.getString("name"))
                    .field(resultSet.getString("field"))
                    .cost(resultSet.getLong("cost"))
                    .build();
            projectsList.add(project);
        }
        return projectsList;
    }

    public List<Developers> findDev(Long id) throws SQLException {
        List<Developers> byProject = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM homework.developers d, homework.skills s, homework.developers_skills ds\n" +
                "where s.level='Middle' and d.id_developer=ds.id_developer and s.id_skill=ds.id_skill;");
        while (resultSet.next()) {
            Developers developer  = Developers.builder()
                    .id_developer(resultSet.getLong("id_developer"))
                    .age(resultSet.getInt("age"))
                    .gender(resultSet.getString("Gender"))
                    .build();
                    byProject.add(developer);


        }
return byProject;

    }
}



