package ua.goit.service;

import ua.goit.model.Companies;
import ua.goit.repository.BaseRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public  class CompanyService extends QueryConnection<Companies>  implements BaseRepository<Long, Companies> {


    @Override
    public Companies create(Companies companies) throws SQLException {
        PreparedStatement create = connection.prepareStatement(
                "INSERT INTO homework.companies (id_company ,name, City) VALUES (?,?,?)");
        create.setLong(1, companies.getId());
        create.setString(2, companies.getName());
        create.setString(3, companies.getCity());
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
        return ;

    }

    @Override
    public List<Companies> findAll() throws SQLException {
    }

}

