package ua.goit.service;

import ua.goit.model.Developers;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DevelopersService extends QueryConnection<Developers> implements BaseRepository<Long, Developers> {

    @Override
    public Developers create(Developers developers) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.developers (id_developer ,name, Age, Gender, salary) VALUES (?,?,?,?,?)");
        create.setLong(1, developers.getId());
        create.setString(2, developers.getName());
        create.setLong(3, developers.getAge());
        create.setString(4, developers.getGender());
        create.setLong(5, developers.getSalary());
        create.executeUpdate();
        create.close();
        return developers;
    }

    @Override
    public Developers update(Long id, Developers developers) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.developers set Name=?, age=?,Gender=? WHERE id_developer=" + id + ";");
        update.setString(1, developers.getName());
        update.setInt(2, developers.getAge());
        update.setString(3, developers.getGender());
        update.execute();
        update.close();
        return developers;
    }

    @Override
    public void delete(Long id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement
                ("DELETE from homework.developers where id_developer=?");
        delete.execute();
        delete.close();
    }

    @Override
    public Developers findByID(Long id) throws SQLException {
        return;
    }

    @Override
    public List<Developers> findAll() throws SQLException {

    }

}
