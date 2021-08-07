package ua.goit.service;

import ua.goit.controller.DataBaseConnection;
import ua.goit.model.CompaniesProjects;
import ua.goit.model.CustomersProjects;
import ua.goit.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerProjectService implements BaseRepository<Long, CustomersProjects> {
    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection = dataBaseConnection.getConnection();
    List<CustomersProjects> customerProjectServiceList = new ArrayList<>();

    @Override
    public CustomersProjects create(CustomersProjects customersProjects) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.customers_projects (id_customer ,id_project) VALUES (?,?)");
        create.setLong(1, customersProjects.getCustomerId());
        create.setLong(1, customersProjects.getProjectId());
        create.executeUpdate();
        create.close();
        return customersProjects;
    }

    @Override
    public CustomersProjects update(Long id, CustomersProjects customersProjects) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.customers_projects set id_project=? WHERE id_customer=" + id + ";");
        update.setLong(1, customersProjects.getProjectId());
        update.execute();
        update.close();
        return customersProjects;
    }

    @Override
    public void delete(Long aLong) throws SQLException {
        PreparedStatement delete = connection.prepareStatement
                ("DELETE from homework.customers_projects where id_customer=?");
        delete.execute();
        delete.close();
    }

    @Override
    public CustomersProjects findByID(Long id) throws SQLException {
        return customerProjectServiceList.get(Math.toIntExact(id));
    }

    @Override
    public List<CustomersProjects> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from homework.customers_projects");
        while (resultSet.next()) {
            CustomersProjects customersProjects = CustomersProjects.builder()
                    .customerId(resultSet.getLong("id_customer"))
                    .projectId(resultSet.getLong("id_project"))
                    .build();
        }
        return customerProjectServiceList;
    }
}
