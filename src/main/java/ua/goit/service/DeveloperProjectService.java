package ua.goit.service;

import ua.goit.controller.DataBaseConnection;
import ua.goit.model.DevelopersProjects;
import ua.goit.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeveloperProjectService implements BaseRepository<Long, DevelopersProjects> {
    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection = dataBaseConnection.getConnection();
    List<DevelopersProjects> developersProjectsList = new ArrayList<>();

    @Override
    public DevelopersProjects create(DevelopersProjects developersProjects) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.developers_projects (id_developer ,id_project) VALUES (?,?)");
        create.setLong(1, developersProjects.getId_developer());
        create.setLong(2, developersProjects.getId_project());
        create.executeUpdate();
        create.close();
        return developersProjects;
    }

    @Override
    public DevelopersProjects update(Long id, DevelopersProjects developersProjects) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.developers_projects set id_project=? WHERE id_developer=" + id + ";");
        update.setLong(1, developersProjects.getId_project());
        update.execute();
        update.close();
        return developersProjects;
    }

    @Override
    public void delete(Long aLong) throws SQLException {
        PreparedStatement delete = connection.prepareStatement
                ("DELETE from homework.developers_projects where id_developer=?");
        delete.execute();
        delete.close();

    }

    @Override
    public DevelopersProjects findByID(Long id) throws SQLException {
        return developersProjectsList.get(Math.toIntExact(id));
    }

    @Override
    public List<DevelopersProjects> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from homework.developers_projects");
        while (resultSet.next()){
            DevelopersProjects developersProject = DevelopersProjects.builder()
                    .id_developer(resultSet.getLong("id_developer"))
                    .id_project(resultSet.getLong("id_project"))
                    .build();
            developersProjectsList.add(developersProject);
        }
            return developersProjectsList;
    }
}
