package ua.goit.service.commands.query;

import ua.goit.repository.QueryExecutor;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.QueryCommand;
import ua.goit.view.View;

import java.util.Map;

public class ProjectWithCountDevAndDateCommand extends QueryCommand {

    public ProjectWithCountDevAndDateCommand(View view, Map<String, Command> commands, QueryExecutor queryExecutor) {
        super (view, commands, queryExecutor);
    }

    @Override
    public String commandName() {
        return "project_by_date";
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
