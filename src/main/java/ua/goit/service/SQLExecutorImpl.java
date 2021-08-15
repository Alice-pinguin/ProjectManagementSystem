package ua.goit.service;

import ua.goit.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class SQLExecutorImpl<E extends BaseEntity<Long>> implements SQLExecutor <Developers,Long>{

    public SQLExecutorImpl() throws SQLException {
    }

    ProjectsService projectsService  = new ProjectsService();
    DevelopersService developersService = new DevelopersService();
    DeveloperSkillService developerSkillService = new DeveloperSkillService();
    SkillsService skillsService = new SkillsService();

    List<Developers> developersByProject = new ArrayList<>();
    List<Developers> allDevelopers = developersService.findAll();
    List<DevelopersSkills> developersListMiddle = developerSkillService.findAll();
    List<Skills> skillsList = skillsService.findAll();


    @Override
    public Long getTotalSalaryDevelopersByProject(Long id) throws SQLException {
        return developersByProject.stream()
                .mapToLong(Developers::getSalary)
                .sum();

    }

    @Override
    public List<Developers> getListOfDevelopersForProject(Long id) throws SQLException {
        Projects find = projectsService.findByID(id);

        return developersByProject;
    }

    @Override
    public List<Developers> getDevelopersBySkill(String skill) throws SQLException {
        return null;
    }

    @Override
    public List<Developers> getDeveloperByLevel(String level) throws SQLException {
        return null;
    }

    @Override
    public List<Developers> projectWithCountDevAndDate() {
        return null;
    }
}

