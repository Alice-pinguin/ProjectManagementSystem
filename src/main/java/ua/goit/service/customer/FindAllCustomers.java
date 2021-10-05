package ua.goit.service.customer;

import ua.goit.model.Customer;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

public class FindAllCustomers implements Command {

    private  final View view;;
    private CrudRepository<Customer, Long> customerRepository;

    public FindAllCustomers(View view,CrudRepository<Customer, Long> customerRepository) {
        this.view = view;
        customerRepository = RepositoryFactory.of (Customer.class);
    }

    @Override
    public String commandName() {
        return "Find all customers";
    }

    @Override
    public void process() {
        customerRepository.findAll ();

    }
}
