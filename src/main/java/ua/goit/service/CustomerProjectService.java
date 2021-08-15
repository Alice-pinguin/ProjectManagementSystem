package ua.goit.service;

import ua.goit.model.CustomersProjects;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerProjectService  extends QueryConnection<CustomersProjects> implements BaseRepository<Long, CustomersProjects> {

    @Override
    public CustomersProjects create(CustomersProjects customersProjects) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.customers_projects (id_customer ,id_project) VALUES (?,?)");
        create.setLong(1, customersProjects.getCustomerId());
        create.setLong(2, customersProjects.getProjectId());
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
        return;
    }

    @Override
    public List<CustomersProjects> findAll() throws SQLException {

    }
}
