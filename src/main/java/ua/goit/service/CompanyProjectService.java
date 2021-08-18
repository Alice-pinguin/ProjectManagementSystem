package ua.goit.service;


import ua.goit.model.CompaniesProjects;

public class CompanyProjectService extends SQLConnection<CompaniesProjects, Long> {

    public CompanyProjectService(String tableName, String... columns) {
        super("companies_projects", "id_company", "id_project");
    }
}
