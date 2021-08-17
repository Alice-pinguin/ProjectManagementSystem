package ua.goit.service;

import ua.goit.model.CustomersProjects;


public class CustomerProjectService  extends SQLConnection<CustomersProjects, Long>{

    public CustomerProjectService(String tableName, String... columns) {
        super("customers_projects", "id_customer", "id_project");
    }
}
