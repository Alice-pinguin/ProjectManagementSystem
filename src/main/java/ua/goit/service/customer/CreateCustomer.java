package ua.goit.service.customer;

import ua.goit.model.Customer;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

public class CreateCustomer implements Command {

    private  final View view;;
    private CrudRepository<Customer, Long> customerRepository;

    public CreateCustomer(View view,CrudRepository<Customer, Long> customerRepository) {
        this.view = view;
        customerRepository = RepositoryFactory.of (Customer.class);
    }

    @Override
    public String commandName() {
        return "Create customer";
    }

    @Override
    public void process() {

        view.write("Enter a customer name");
        String name = view.read();
        view.write("Enter a customer city");
        String city = view.read();
        view.write("Enter a customer industy");
        String industry = view.read();

        Customer customer = new Customer();
        customer.setName (name);
        customer.setCity (city);
        customer.setIndustry (industry);
        customerRepository.create(customer);
        view.write("Customer created");
    }
}
