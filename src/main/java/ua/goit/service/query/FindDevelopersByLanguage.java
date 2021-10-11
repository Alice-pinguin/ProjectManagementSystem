package ua.goit.service.query;

import ua.goit.repository.QueryExecutorImpl;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.QueryCommand;
import ua.goit.view.View;

import java.util.Map;

public class FindDevelopersByLanguage extends QueryCommand {


    public FindDevelopersByLanguage(View view, Map<String, Command> commands, QueryExecutorImpl queryExecutor) {
        super (view, commands, queryExecutor);
    }

    @Override
    public String commandName() {
        return "Find all developers by language";
    }

    @Override
    public String description() {
        return "find developers by language";
    }

    @Override
    public void process() {
        super.getDevelopersBySkill ();
    }
}
