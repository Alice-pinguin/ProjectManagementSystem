package ua.goit;

import ua.goit.controller.DataBaseConnection;
import ua.goit.model.Companies;
import ua.goit.model.CompaniesProjects;
import ua.goit.service.CompanyProjectService;
import ua.goit.service.CompanyService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Application {

    public static void main(String[] args) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
       Connection connection =  dataBaseConnection.getConnection();
        System.out.println(connection);

        CompanyService companyService  = new CompanyService();
        List<Companies> companiesList = companyService.findAll();
        Companies company = companyService.findByID(0L);
        System.out.println(companiesList);

        CompanyProjectService companyProjectService = new CompanyProjectService();
        List<CompaniesProjects> companiesProjects = companyProjectService.findAll();
        System.out.println(companiesProjects);


    }
}
