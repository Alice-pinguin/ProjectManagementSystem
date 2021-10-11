package ua.goit.service.query;

import ua.goit.repository.QueryExecutorImpl;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.QueryCommand;
import ua.goit.view.View;

import java.util.Map;

public class FindAllDevelopersByProject extends QueryCommand {


    public FindAllDevelopersByProject(View view, Map<String, Command> commands, QueryExecutorImpl queryExecutor) {
        super (view, commands, queryExecutor);
    }

    @Override
    public String commandName() {
        return "Find all developers by project";
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

