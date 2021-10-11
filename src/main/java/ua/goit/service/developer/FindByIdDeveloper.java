package ua.goit.service.developer;

import ua.goit.model.Company;
import ua.goit.model.Developer;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;
import java.util.Optional;

public class FindByIdDeveloper extends CrudCommand {

    public FindByIdDeveloper(View view, Map<String, Command> commands) {
        super (view, commands, Developer.class);
    }

    @Override
    public String commandName() {
        return "Find by ID developer";
    }

    @Override
    public String description() {
        return "find a developer by ID";
    }

    @Override
    public void process() {
        super.findById ();
        }
    }
