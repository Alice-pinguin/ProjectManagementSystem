package ua.goit.service.commands.query;


import ua.goit.repository.QueryExecutor;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.QueryCommand;
import ua.goit.view.View;
import java.util.Map;

public class DeveloperByLevelCommand extends QueryCommand {

    public DeveloperByLevelCommand(View view, Map<String, Command> commands) {
        super (view, commands);
    }

    @Override
    public String commandName() {
        return "developers_by_level";
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