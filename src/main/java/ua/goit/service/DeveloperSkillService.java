package ua.goit.service;

import ua.goit.controller.DataBaseConnection;
import ua.goit.model.DevelopersSkills;
import ua.goit.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeveloperSkillService implements BaseRepository<Long, DevelopersSkills> {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection = dataBaseConnection.getConnection();
    List<DevelopersSkills> developersSkillsList = new ArrayList<>();


    @Override
    public DevelopersSkills create(DevelopersSkills developersSkills) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.developers_skills (id_developer ,id_skill) VALUES (?,?)");
        create.setLong(1, developersSkills.getDeveloperId());
        create.setLong(2, developersSkills.getSkillsId());
        create.executeUpdate();
        create.close();
        return developersSkills;
    }

    @Override
    public DevelopersSkills update(Long id, DevelopersSkills developersSkills) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.developers_skills set id_skill=? WHERE id_developer=" + id + ";");
        update.setLong(1, developersSkills.getSkillsId());
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
        return developersSkillsList.get(Math.toIntExact(id));
    }

    @Override
    public List<DevelopersSkills> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from homework.developers_skills");
        while (resultSet.next()){
            DevelopersSkills developerSkill = DevelopersSkills.builder()
                    .developerId(resultSet.getLong("id_developer"))
                    .skillsId(resultSet.getLong("id_skill"))
                    .build();
            developersSkillsList.add(developerSkill);
        }
        return developersSkillsList;
    }

    }

