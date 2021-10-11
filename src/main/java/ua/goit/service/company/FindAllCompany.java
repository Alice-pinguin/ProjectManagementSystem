package ua.goit.service.company;

import ua.goit.model.Company;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;

public class FindAllCompany extends CrudCommand {

    public FindAllCompany(View view, Map<String, Command> commands) {
        super (view, commands, Company.class);
    }

    @Override
    public String commandName() {
        return "Find all companies";
    }

    @Override
    public String description() {
        return "find all data about companies";
    }

    @Override
    public void process() {
        super.findAll ();
    }
}
