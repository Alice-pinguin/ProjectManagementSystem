package ua.goit.service.project;


import ua.goit.model.Project;

import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;
import java.util.Map;


public class FindByIdProject extends CrudCommand {

    public FindByIdProject(View view, Map<String, Command> commands) {
        super (view, commands, Project.class);
    }

    @Override
    public String commandName() {
        return "Find by ID project";
    }

    @Override
    public String description() {
        return "find a project by ID";
    }

    @Override
    public void process() {
        super.findById ();
        }
    }
