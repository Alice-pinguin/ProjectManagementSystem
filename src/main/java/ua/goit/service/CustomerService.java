package ua.goit.service;

import ua.goit.model.Customers;
import ua.goit.model.CustomersProjects;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerService extends SQLConnection<CustomersProjects, Long> {

    public CustomerService(String tableName, String... columns) {
        super("customers", "id_customer", "name","city", "industry");
    }
}


