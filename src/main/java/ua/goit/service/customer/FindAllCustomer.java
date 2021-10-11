package ua.goit.service.customer;

import ua.goit.model.Customer;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;

public class FindAllCustomer extends CrudCommand {

    public FindAllCustomer(View view, Map<String, Command> commands) {
        super (view, commands, Customer.class);
    }

    @Override
    public String commandName() {
        return "Find all customer";
    }

    @Override
    public String description() {
        return "find all data about customers";
    }

    @Override
    public void process() {
        super.findAll ();
    }
}
