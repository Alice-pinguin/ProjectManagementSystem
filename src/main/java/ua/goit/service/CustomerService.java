package ua.goit.service;

import ua.goit.model.Customers;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CustomerService extends QueryConnection<Customers> implements BaseRepository<Long, Customers> {


    @Override
    public Customers create(Customers customers) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.customers (id_customer, Name,City, Industry) VALUES (?,?,?,?)");
        create.setLong(1, customers.getId());
        create.setString(2, customers.getName());
        create.setString(3, customers.getCity());
        create.setString(4, customers.getIndustry());
        create.executeUpdate();
        create.close();
        return customers;
    }

    @Override
    public Customers update(Long id, Customers customers) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.customers set Name=?, City=?, Industry=? WHERE id_customer=" + id + ";");
        update.setString(1, customers.getName());
        update.setString(2, customers.getCity());
        update.setString(3, customers.getIndustry());
        update.execute();
        update.close();
        return customers;
    }

    @Override
    public void delete(Long id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement
                ("DELETE from homework.customers where id_customer=?");
        delete.execute();
        delete.close();

    }

    @Override
    public Customers findByID(Long id) throws SQLException {
        return ;
    }

    @Override
    public List<Customers> findAll() throws SQLException {

    }
}


