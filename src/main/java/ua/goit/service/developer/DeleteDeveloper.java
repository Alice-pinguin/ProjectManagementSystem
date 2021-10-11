package ua.goit.service.developer;

import ua.goit.model.Developer;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;

import ua.goit.view.View;

import java.util.Map;


public class DeleteDeveloper extends CrudCommand {

    public DeleteDeveloper(View view, Map<String, Command> commands) {
        super (view, commands, Developer.class);
    }

    @Override
    public void process() {
        super.deleteById ();
    }

    @Override
    public String commandName() {
        return "Delete developer";
}

    @Override
    public String description() {
        return "delete developer by ID";
    }
}