package ua.goit.service.commands.query;

import ua.goit.repository.QueryExecutorImpl;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.QueryCommand;
import ua.goit.view.View;

import java.util.Map;

public class DevelopersBySkillCommand extends QueryCommand {

    public DevelopersBySkillCommand(View view, Map<String, Command> commands, QueryExecutorImpl queryExecutor) {
        super (view, commands, queryExecutor);
    }

    @Override
    public String commandName() {
        return "developers_by_language";
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
