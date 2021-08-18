package ua.goit.service;

import ua.goit.model.CustomersProjects;
import ua.goit.model.Skills;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class SkillsService extends SQLConnection<Skills, Long> {

    public SkillsService(String tableName, String... columns) {
        super("skills", "id_skill", "language", "level");
    }
}
