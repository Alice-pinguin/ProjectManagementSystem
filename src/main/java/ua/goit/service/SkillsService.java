package ua.goit.service;

import ua.goit.controller.DataBaseConnection;
import ua.goit.model.Skills;
import ua.goit.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillsService implements BaseRepository<Long, Skills> {
    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection = dataBaseConnection.getConnection();
    List<Skills> skillsList = new ArrayList<>();


    @Override
    public Skills create(Skills skills) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.skills (id_skill ,Language, Level) VALUES (?,?,?)");
        create.setLong(1, skills.getId());
        create.setString(2, skills.getLanguage());
        create.setString(3, skills.getLevel());
        create.executeUpdate();
        create.close();
        return skills;
    }

    @Override
    public Skills update(Long id, Skills skills) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.skills set Language=?,Level=? WHERE id_skill=" + id + ";");
        update.setString(1, skills.getLanguage());
        update.setString(1, skills.getLevel());
        update.execute();
        update.close();
        return skills;
    }

    @Override
    public void delete(Long aLong) throws SQLException {
        PreparedStatement delete = connection.prepareStatement
                ("DELETE from homework.skills where id_skill=?");
        delete.execute();
        delete.close();
    }

    @Override
    public Skills findByID(Long id) throws SQLException {
        return skillsList.get(Math.toIntExact(id));
    }

    @Override
    public List<Skills> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from homework.skills");
        while (resultSet.next()){
            Skills skill = Skills.builder()
                    .id(resultSet.getLong("id_skill"))
                    .Language(resultSet.getString("language"))
                    .level(resultSet.getString("level"))
                    .build();
            skillsList.add(skill);
        }
        return skillsList;
    }
}
