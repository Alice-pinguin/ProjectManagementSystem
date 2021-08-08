package ua.goit.service;

import ua.goit.controller.DataBaseConnection;
import ua.goit.model.Customers;
import ua.goit.repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService  implements BaseRepository<Long, Customers> {

    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection = dataBaseConnection.getConnection();
    List<Customers> customersList = new ArrayList<>();

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
        return   customersList.get(Math.toIntExact(id));
    }

    @Override
    public List<Customers> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from homework.customers");
        while (resultSet.next()){
            Customers customer = Customers.builder()
                    .id(resultSet.getLong("id_customer"))
                    .name(resultSet.getString("name"))
                    .city(resultSet.getString("City"))
                    .industry(resultSet.getString("industry"))
                    .build();
            customersList.add(customer);
        }
        return customersList;
    }
}


