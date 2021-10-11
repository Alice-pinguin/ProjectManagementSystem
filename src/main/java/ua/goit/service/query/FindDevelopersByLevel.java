package ua.goit.service.query;

import ua.goit.repository.QueryExecutorImpl;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.QueryCommand;
import ua.goit.view.View;

import java.util.Map;

public class FindDevelopersByLevel extends QueryCommand {


    public FindDevelopersByLevel(View view, Map<String, Command> commands, QueryExecutorImpl queryExecutor) {
        super (view, commands, queryExecutor);
    }

    @Override
    public String commandName() {
        return "Find all developers by level";
    }

    @Override
    public String description() {
        return "find developers by level";
    }

    @Override
    public void process() {
        super.getDevelopersByLevel ();
    }
}