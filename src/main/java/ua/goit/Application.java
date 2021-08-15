package ua.goit;

import ua.goit.controller.DataBaseConnection;
import ua.goit.model.*;
import ua.goit.service.*;
;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public class Application {



    public static void main(String[] args) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Connection connection = dataBaseConnection.getConnection();
        System.out.println(connection);

        CompanyService companyService = new CompanyService();
      //  companyService.create(Companies.builder()
       //         .id_company(8L)
        //        .name("Avengers")
         //       .city("New York")
         //       .build());

        DevelopersService developerService = new DevelopersService();
      //  developerService.create(Developers.builder()
       //        .id_developer(11L)
        //       .name("Tony Stark")
        //       .age(42)
         //      .gender("men")
         //      .salary(10000L)
         //      .build());

        ProjectsService projectsService = new ProjectsService();
      //  projectsService.create(Projects.builder()
        //        .id_project(6L)
         //      .id_developer(11L)
         //      .name("Iron man")
          //      .cost(100000000L)
         //      .createDate(LocalDate.of(2020,12,12))
          //     .field("Machine Learning")
         //      .id_company(8L)
         //       .build());
        















    }
}