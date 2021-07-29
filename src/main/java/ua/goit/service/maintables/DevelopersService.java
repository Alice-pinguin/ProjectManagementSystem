package ua.goit.service.maintables;

import ua.goit.controller.DataBaseConnection;
import ua.goit.model.Developers;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DevelopersService implements SQLExecutor<Developers> {
    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection =  dataBaseConnection.getConnection();

    @Override
    public void create(Developers developers) throws SQLException {
        PreparedStatement developer = connection.prepareStatement
                ("INSERT INTO 'developers' ('developer_name','developer_age', 'developer_gender') VALUES (?,?,?);");
        developer.setString(1, developers.getName());
        developer.setString(2, String.valueOf(developers.getAge()));
        developer.setString(3, developers.getGender());
        developer.execute();
    }

    @Override
    public List<Developers> read(long id) throws SQLException {
        List<Developers> developersList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT* FROM homework.developers");
        while (resultSet.next()) {
            Developers developer = Developers.builder()
                    .id(resultSet.getLong("id_developer"))
                    .name(resultSet.getString("Name"))
                    .age(resultSet.getInt("Age"))
                    .gender(resultSet.getString("Gender"))
                    .build();
            developersList.add(developer);
        }
        return developersList;
    }

    @Override
    public void update(long id, Developers developers) throws SQLException {
        PreparedStatement developerUpdate = connection.prepareStatement
                ("UPDATE 'developers' set developer_name=?,developer_age=?, developer_gender=? WHERE id_developers=?;");

        developerUpdate.setString(1, developers.getName());
        developerUpdate.setString(2, String.valueOf(developers.getAge()));
        developerUpdate.setString(3, developers.getGender());
        developerUpdate.setString(4, String.valueOf(developers.getId()));
        developerUpdate.execute();

    }

    @Override
    public void delete(long id) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM 'developers' WHERE id_developers=" + id);

    }

}


