package ua.goit.service.company;

import ua.goit.model.Company;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;
import java.util.Optional;

public class FindByIdCompany extends CrudCommand {

    public FindByIdCompany(View view, Map<String, Command> commands) {
        super (view, commands, Company.class);
    }

    @Override
    public String commandName() {
        return "Find by ID company";
    }

    @Override
    public String description() {
        return "find a company by ID";
    }

    @Override
    public void process() {
        super.findById ();
        }
    }
