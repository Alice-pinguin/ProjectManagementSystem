package ua.goit.service.customer;

import ua.goit.model.Customer;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;

import ua.goit.view.View;

import java.util.Map;


public class DeleteCustomer extends CrudCommand {

    public DeleteCustomer(View view, Map<String, Command> commands) {
        super (view, commands, Customer.class);
    }

    @Override
    public void process() {
        super.deleteById ();
    }

    @Override
    public String commandName() {
        return "Delete customer";
}

    @Override
    public String description() {
        return "delete customer by ID";
    }
}