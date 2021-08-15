package ua.goit.service;

import ua.goit.model.DevelopersProjects;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeveloperProjectService extends QueryConnection<DevelopersProjects> implements BaseRepository<Long, DevelopersProjects> {


    @Override
    public DevelopersProjects create(DevelopersProjects developersProjects) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.developers_projects (id_developer ,id_project) VALUES (?,?)");
        create.setLong(1, developersProjects.getDelevoperId());
        create.setLong(2, developersProjects.getProjectId());
        create.executeUpdate();
        create.close();
        return developersProjects;
    }

    @Override
    public DevelopersProjects update(Long id, DevelopersProjects developersProjects) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.developers_projects set id_project=? WHERE id_developer=" + id + ";");
        update.setLong(1, developersProjects.getProjectId());
        update.execute();
        update.close();
        return developersProjects;
    }

    @Override
    public void delete(Long aLong) throws SQLException {
        PreparedStatement delete = connection.prepareStatement
                ("DELETE from homework.developers_projects where id_developer=?");
        delete.execute();


    }

    @Override
    public DevelopersProjects findByID(Long id) throws SQLException {
        return;
    }

    @Override
    public List<DevelopersProjects> findAll() throws SQLException {

    }
}
