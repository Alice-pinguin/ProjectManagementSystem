package ua.goit.service.developer;


import ua.goit.model.Developer;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.CrudCommand;
import ua.goit.view.View;

import java.util.Map;

public class SaveDeveloper extends CrudCommand {

    public SaveDeveloper(View view, Map<String, Command> commands) {
        super (view, commands, Developer.class);
    }

        @Override
    public String commandName() {
        return "Save developer";
    }

    @Override
    public String description() {
        return "for saving a new developer, please enter the name,  age, salary and gender of a developer";
    }

    @Override
    public void process() {
        Developer developer = Developer.builder()
                .name(view.read())
                .age (Integer.valueOf (view.read ()))
                .gender (view.read ())
                .salary (Long.valueOf (view.read ()))
                .build();

    }
}
