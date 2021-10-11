package ua.goit.service.customer;


import ua.goit.model.Customer;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;

public class SaveCustomer extends CrudCommand {

    public SaveCustomer(View view, Map<String, Command> commands) {
        super (view, commands, Customer.class);
    }

        @Override
    public String commandName() {
        return "Save customer";
    }

    @Override
    public String description() {
        return "for saving a new customer, please enter the name,city and industry of a customer";
    }

    @Override
    public void process() {
        Customer customer = Customer.builder()
                .name(view.read())
                .city(view.read())
                .industry(view.read())
                .build();

    }
}
