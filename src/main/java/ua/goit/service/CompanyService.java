package ua.goit.service;


import ua.goit.controller.DataBaseConnection;
import ua.goit.model.Companies;
import ua.goit.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public  class CompanyService  implements BaseRepository<Long, Companies> {
    DataBaseConnection dataBaseConnection = new DataBaseConnection();
    Connection connection = dataBaseConnection.getConnection();
    List <Companies> companiesList = new ArrayList<>();

    @Override
    public Companies create(Companies companies) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.companies (id_company ,name, City) VALUES (?,?,?)");
        create.setLong(1, companies.getId());
        create.setString(2, companies.getName());
        create.setString(2, companies.getCity());
        create.executeUpdate();
        create.close();
        return companies;
    }

    @Override
    public Companies update(Long id, Companies companies) throws SQLException {
        PreparedStatement update = connection.prepareStatement
                ("UPDATE homework.companies set name=?, city=?, WHERE id_company=" + id + ";");
        update.setString(1, companies.getName());
        update.setString(2, companies.getCity());
        update.execute();
        update.close();
        return companies;
    }

    @Override
    public void delete(Long id) throws SQLException {
        PreparedStatement delete = connection.prepareStatement
                ("DELETE from homework.companies where id_company=?");
        delete.execute();
        delete.close();

    }

    @Override
    public Companies findByID(Long id) throws SQLException {
        return companiesList.get(Math.toIntExact(id));

    }

    @Override
    public List<Companies> findAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from homework.companies");
        while (resultSet.next()){
            Companies company = Companies.builder()
                    .id(resultSet.getLong("id_company"))
                    .name(resultSet.getString("name"))
                    .city(resultSet.getString("city"))
                    .build();
            companiesList.add(company);
        }
        return companiesList;
    }
    }

