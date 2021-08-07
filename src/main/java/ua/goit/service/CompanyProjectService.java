package ua.goit.service;

import ua.goit.controller.DataBaseConnection;

import ua.goit.model.CompaniesProjects;
import ua.goit.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyProjectService implements BaseRepository<Long, CompaniesProjects> {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection = dataBaseConnection.getConnection();
    List <CompaniesProjects> companiesProjectsList = new ArrayList<>();

    @Override
    public CompaniesProjects create(CompaniesProjects companiesProjects) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.companies_projects (id_company ,id_project) VALUES (?,?)");
        create.setLong(1, companiesProjects.getCompanyId());
        create.setLong(1, companiesProjects.getProjectId());
        create.executeUpdate();
        create.close();
        return companiesProjects;
    }

    @Override
    public CompaniesProjects update(Long id, CompaniesProjects companiesProjects) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.companies_projects set id_project=? WHERE id_company=" + id + ";");
       update.setLong(1, companiesProjects.getProjectId());
        update.execute();
        update.close();
        return companiesProjects;
    }

    @Override
    public void delete(Long aLong) throws SQLException {
        PreparedStatement delete = connection.prepareStatement
                ("DELETE from homework.companies_projects where id_company=?");
        delete.execute();
        delete.close();

    }

    @Override
    public CompaniesProjects findByID(Long id) throws SQLException {
        return companiesProjectsList.get(Math.toIntExact(id));
    }

    @Override
    public List<CompaniesProjects> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from homework.companies_projects");
        while (resultSet.next()){
            CompaniesProjects companiesProject = CompaniesProjects.builder()
                    .companyId(resultSet.getLong("id_company"))
                    .projectId(resultSet.getLong("id_project"))
                    .build();
            companiesProjectsList.add(companiesProject);
        }
        return companiesProjectsList;
    }
}
