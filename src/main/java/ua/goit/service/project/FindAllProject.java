package ua.goit.service.project;

import ua.goit.model.Project;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;

public class FindAllProject extends CrudCommand {

    public FindAllProject(View view, Map<String, Command> commands) {
        super (view, commands, Project.class);
    }

    @Override
    public String commandName() {
        return "Find all project";
    }

    @Override
    public String description() {
        return "find all data about projects";
    }

    @Override
    public void process() {
        super.findAll ();
    }
}
