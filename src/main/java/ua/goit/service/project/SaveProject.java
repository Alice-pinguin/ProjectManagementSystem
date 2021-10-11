package ua.goit.service.project;

import ua.goit.model.Project;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;

public class SaveProject extends CrudCommand {

    public SaveProject(View view, Map<String, Command> commands) {
        super (view, commands, Project.class);
    }

        @Override
    public String commandName() {
        return "Save project";
    }

    @Override
    public String description() {
        return "For saving a new project, please enter the name, field, cost and create date" +
                "in format yyyy-mm-dd of a project";
    }

    @Override
    public void process() {
        Project project = Project.builder()
                .name(view.read())
                .field (view.read())
                .createDate (view.read ())
                .cost (Long.valueOf (view.read ()))
                .build();

    }
}
