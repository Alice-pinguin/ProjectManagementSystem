package ua.goit.service.customer;

import ua.goit.model.Customer;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;


public class FindByIdCustomer extends CrudCommand {

    public FindByIdCustomer(View view, Map<String, Command> commands) {
        super (view, commands, Customer.class);
    }

    @Override
    public String commandName() {
        return "Find by ID customer";
    }

    @Override
    public String description() {
        return "find a customer by ID";
    }

    @Override
    public void process() {
        super.findById ();
        }
    }
