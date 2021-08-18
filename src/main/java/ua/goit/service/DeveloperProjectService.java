package ua.goit.service;

import ua.goit.model.CustomersProjects;
import ua.goit.model.DevelopersProjects;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeveloperProjectService extends SQLConnection<DevelopersProjects, Long> {

    public DeveloperProjectService(String tableName, String... columns) {
        super("developers_projects", "id_developer", "id_project");
    }
}
