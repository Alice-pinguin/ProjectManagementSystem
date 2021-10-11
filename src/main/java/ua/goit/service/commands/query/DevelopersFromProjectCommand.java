package ua.goit.service.commands.query;

import ua.goit.repository.QueryExecutor;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.QueryCommand;
import ua.goit.view.View;

import java.util.Map;

public class DevelopersFromProjectCommand extends QueryCommand {


    public DevelopersFromProjectCommand(View view, Map<String, Command> commands, QueryExecutor queryExecutor) {
        super (view, commands, queryExecutor);
    }

    @Override
    public String commandName() {
        return "developers_by_project";
    }

    @Override
    public String description() {
        return "find developers on project";
    }

    @Override
    public void process() {
        super.getListOfDevelopersFromProject ();
    }
}

