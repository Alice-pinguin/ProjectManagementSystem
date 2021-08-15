package ua.goit.service;

import ua.goit.model.Skills;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SkillsService extends QueryConnection<Skills> implements BaseRepository<Long, Skills> {

    @Override
    public Skills create(Skills skills) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.skills (id_skill ,Language, Level) VALUES (?,?,?)");
        create.setLong(1, skills.getId_skill());
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
        update.setString(2, skills.getLevel());
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
        return;
    }

    @Override
    public List<Skills> findAll() throws SQLException {

    }
}
