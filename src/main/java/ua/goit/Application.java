package ua.goit;


import lombok.extern.slf4j.Slf4j;
import ua.goit.controller.DataBaseConnection;
import ua.goit.model.Developers;
import ua.goit.service.maintables.DevelopersService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Application {

    public static void main(String[] args) throws SQLException {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
       Connection connection =  dataBaseConnection.getConnection();
        System.out.println(connection);
        DevelopersService developersService = new DevelopersService();
        List<Developers> developer  = developersService.read(2L);
        System.out.println(developer);


    }
}
