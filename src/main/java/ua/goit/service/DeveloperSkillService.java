package ua.goit.service;

import ua.goit.model.DevelopersSkills;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeveloperSkillService  extends QueryConnection<DevelopersSkills> implements BaseRepository<Long, DevelopersSkills> {

    @Override
    public DevelopersSkills create(DevelopersSkills developersSkills) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.developers_skills (id_developer ,id_skill) VALUES (?,?)");
        create.setLong(1, developersSkills.getDeveloperId());
        create.setLong(2, developersSkills.getSkillId());
        create.executeUpdate();
        create.close();
        return developersSkills;
    }

    @Override
    public DevelopersSkills update(Long id, DevelopersSkills developersSkills) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.developers_skills set id_skill=? WHERE id_developer=" + id + ";");
        update.setLong(1, developersSkills.getSkillId());
        update.execute();
        update.close();
        return developersSkills;
    }

    @Override
    public void delete(Long id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement
                ("DELETE from homework.developers_skills where id_developer=?");
        delete.execute();
        delete.close();


    }

    @Override
    public DevelopersSkills findByID(Long id) throws SQLException {
        return ;
    }

    @Override
    public List<DevelopersSkills> findAll() throws SQLException {

    }

    }

