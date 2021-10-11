package ua.goit.service.developer;

import ua.goit.model.Developer;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;

public class FindAllDeveloper extends CrudCommand {

    public FindAllDeveloper(View view, Map<String, Command> commands) {
        super (view, commands, Developer.class);
    }

    @Override
    public String commandName() {
        return "Find all developers";
    }

    @Override
    public String description() {
        return "find all data about developers";
    }

    @Override
    public void process() {
        super.findAll ();
    }
}
