package ua.goit.service;

import ua.goit.controller.DataBaseConnection;
import ua.goit.model.Developers;
import ua.goit.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DevelopersService implements BaseRepository<Long, Developers> {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection = dataBaseConnection.getConnection();
    List <Developers> developersList = new ArrayList<>();

    @Override
    public Developers create(Developers developers) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.developers (id_developer ,name, Age, Gender) VALUES (?,?,?)");
        create.setLong(1, developers.getId());
        create.setString(2, developers.getName());
        create.setLong(1, developers.getAge());
        create.setString(2, developers.getGender());
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
        update.setString(1, developers.getGender());
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
        return developersList.get(Math.toIntExact(id));
    }

    @Override
    public List<Developers> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from homework.developers");
        while (resultSet.next()){
            Developers developer = Developers.builder()
                    .developerID(resultSet.getLong("id_developer"))
                    .age(resultSet.getInt("age"))
                    .gender(resultSet.getString("Gender"))
                    .build();
            developersList.add(developer);
        }
        return developersList;
    }
}
