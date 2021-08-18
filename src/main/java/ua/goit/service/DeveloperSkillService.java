package ua.goit.service;

import ua.goit.model.CustomersProjects;
import ua.goit.model.DevelopersSkills;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeveloperSkillService  extends SQLConnection<DevelopersSkills, Long>{

    public DeveloperSkillService(String tableName, String... columns) {
        super("developers_skills", "id_developer", "id_skill");

    }
}

