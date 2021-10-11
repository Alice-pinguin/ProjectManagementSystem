package ua.goit.service.query;

import ua.goit.repository.QueryExecutorImpl;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.QueryCommand;
import ua.goit.view.View;

import java.util.Map;

public class ProjectByDateAndDev extends QueryCommand {


    public ProjectByDateAndDev(View view, Map<String, Command> commands, QueryExecutorImpl queryExecutor) {
        super (view, commands, queryExecutor);
    }

    @Override
    public String commandName() {
        return "Project by date and dev";
    }

    @Override
    public String description() {
        return "show sorted project by date with count dev";
    }

    @Override
    public void process() {
        super.getProjectWithCountDevAndDate ();
    }
}
