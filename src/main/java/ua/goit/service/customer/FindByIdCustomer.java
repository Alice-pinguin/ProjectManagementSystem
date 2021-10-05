package ua.goit.service.customer;

import ua.goit.model.Customer;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

import java.util.Optional;

public class FindByIdCustomer implements Command {

    private  final View view;
    private CrudRepository<Customer, Long> customerRepository;

    public FindByIdCustomer(View view, CrudRepository<Customer, Long> customerRepository) {
        this.view = view;
        customerRepository = RepositoryFactory.of(Customer.class);
    }

    @Override
    public String commandName() {
        return "Find by ID customer";
    }

    @Override
    public void process() {
        view.write ("Enter a customer id");
        Long id = Long.valueOf (view.read ());
        Optional<Customer> customer = customerRepository.findById (id);
        if (customer.isEmpty ()) {
            throw new IllegalArgumentException ("Customer with id %d not exist");
        }
        System.out.println (customer.get ());
    }
}
