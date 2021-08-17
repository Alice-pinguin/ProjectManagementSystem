package ua.goit.service;

import ua.goit.model.CustomersProjects;
import ua.goit.model.Projects;
import ua.goit.repository.BaseRepository;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.List;


public class ProjectsService extends SQLConnection<Projects, Long>{

    public ProjectsService(String tableName, String... columns) {
        super("projects", "id_project", "name", "field");
    }
}



