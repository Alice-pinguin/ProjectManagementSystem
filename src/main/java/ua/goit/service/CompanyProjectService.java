package ua.goit.service;


import ua.goit.model.CompaniesProjects;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CompanyProjectService extends QueryConnection<CompaniesProjects> implements BaseRepository<Long, CompaniesProjects> {

    @Override
    public CompaniesProjects create(CompaniesProjects companiesProjects) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.companies_projects (id_company ,id_project) VALUES (?,?)");
        create.setLong(1, companiesProjects.getCompanyId());
        create.setLong(2, companiesProjects.getProjectId());
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
    public void delete(Long id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement
                ("DELETE from homework.companies_projects where id_company=?");
        delete.execute();
        delete.close();

    }

    @Override
    public CompaniesProjects findByID(Long id) throws SQLException {
        return;
    }

    @Override
    public List<CompaniesProjects> findAll() throws SQLException {

    }
}
