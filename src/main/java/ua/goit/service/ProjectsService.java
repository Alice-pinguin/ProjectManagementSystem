package ua.goit.service;

import ua.goit.model.Projects;
import ua.goit.repository.BaseRepository;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.List;


public class ProjectsService extends QueryConnection<Projects> implements BaseRepository<Long, Projects> {

    @Override
    public Projects create(Projects projects) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.projects (id_project ,name, field, creation_date, cost) VALUES (?,?,?,?,?)");
        create.setLong(1, projects.getId());
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
        return ;
    }

    @Override
    public List<Projects> findAll() throws SQLException {

    }

}



