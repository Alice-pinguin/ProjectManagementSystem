package ua.goit.repository;


import lombok.SneakyThrows;
import ua.goit.controller.DataBaseConnection;
import ua.goit.model.Developer;
import ua.goit.model.Project;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QueryExecutorImpl implements QueryExecutor{

  private  CrudRepository<Project, Long> projectRepository = RepositoryFactory.of(Project.class);
  private  List<Developer> developerList = new ArrayList<> ();
  private final Connection connection = DataBaseConnection.getInstance ().getConnection ();
  private final Statement statement;
    {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
           throw new RuntimeException ();
        }
    }

    @SneakyThrows
    @Override
    public List getTotalSalaryDevelopersByProject(Long id) {
        List salary = new ArrayList<> ();
        String query = "SELECT SUM(developers.salary) AS sumSalaries FROM jdbc.developers_projects " +
                "inner join jdbc.developers on jdbc.developers_projects.id_developer = developers.id " +
                "inner join jdbc.projects on jdbc.developers_projects.id_project ='" + id + "'" +
                "GROUP BY projects.id  limit 1";
        ResultSet resultSet = statement.executeQuery (query);
        while (resultSet.next ())
            salary.add (resultSet.getString ("sumSalaries"));
        return salary;
    }

    @SneakyThrows
    @Override
    public List<Developer> getListOfDevelopersFromProject(Long id)  {
        String query = "SELECT * FROM jdbc.developers d, jdbc.projects p, jdbc.developers_projects dp" +
                " where  d.id=dp.id_developer and p.id = dp.id_project and p.id ='" +id +"'";
        return getDevelopers (query, developerList);
    }

    @SneakyThrows
    @Override
    public List<Developer> getDevelopersBySkill(String skill){
        String query = "SELECT d.id, d.name,d.age, d.gender, d.salary FROM jdbc.developers d " +
                "INNER JOIN jdbc.developers_skills ds ON d.id = ds.id_developer " +
                "INNER JOIN jdbc.skills s ON ds.id_skill = s.id" +
                " WHERE s.language ='"+skill+"'";
        return getDevelopers (query, developerList);
    }

    @SneakyThrows
    @Override
    public List<Developer> getDeveloperByLevel (String level) {
        String query = "SELECT d.id, d.name,d.age, d.gender, d.salary FROM jdbc.developers d " +
                "INNER JOIN jdbc.developers_skills ds ON d.id = ds.id_developer " +
                "INNER JOIN jdbc.skills s ON ds.id_skill = s.id" +
                " WHERE s.level ='"+level+"'";
        return getDevelopers (query, developerList);
    }

    @SneakyThrows
    private List<Developer> getDevelopers(String query, List<Developer> developerList) {
        ResultSet resultSet = statement.executeQuery (query);
        while (resultSet.next ()){
            Developer developer = Developer.builder ()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .age(resultSet.getInt("age"))
                    .gender(resultSet.getString("gender"))
                    .salary(resultSet.getLong("salary"))
                    .build();
            developerList.add (developer);

        }

        return developerList;
    }

    @Override
    public List projectWithCountDevAndDate(Long id)  {
        return projectRepository.findAll().stream()
                .map(p -> p.getCreateDate ().toString() + " - " + p.getName() + " - " + getListOfDevelopersFromProject(id).size ()+".")
                .collect(Collectors.toList());
    }

}






