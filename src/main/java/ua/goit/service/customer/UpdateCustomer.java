package ua.goit.service.customer;

import ua.goit.model.Customer;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

import java.util.Optional;

public class UpdateCustomer implements Command {

    private  final View view;;
    private CrudRepository<Customer, Long> customerRepository;

    public UpdateCustomer(View view,CrudRepository<Customer, Long> customerRepository) {
        this.view = view;
        customerRepository = RepositoryFactory.of (Customer.class);
    }

    @Override
    public String commandName() {
        return "Update customer";
    }

    @Override
    public void process() {
        view.write ("Enter a customer id");
        Long id = Long.valueOf (view.read ());
        Optional<Customer> customer = customerRepository.findById (id);
        if (customer.isEmpty ()) {
            throw new IllegalArgumentException (String.format ("Customer with id %d not exist"));
        }

        view.write("Enter a customer name");
        String name = view.read();
        view.write("Enter a customer city");
        String city = view.read();
        view.write("Enter a customer industry");
        String industry = view.read();

        customer.get().setName (name);
        customer.get ().setCity (city);
        customer.get ().setIndustry (industry);
        customerRepository.update(customer.get ());
        view.write("Customer updated");

    }
}
