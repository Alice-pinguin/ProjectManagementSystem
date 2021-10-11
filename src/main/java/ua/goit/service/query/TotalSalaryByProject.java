package ua.goit.service.query;

import ua.goit.repository.QueryExecutorImpl;
import ua.goit.service.commands.Command;
import ua.goit.service.commands.QueryCommand;
import ua.goit.view.View;

import java.util.Map;

public class TotalSalaryByProject extends QueryCommand {

    public TotalSalaryByProject(View view, Map<String, Command> commands, QueryExecutorImpl queryExecutor) {
        super (view, commands, queryExecutor);
    }

    @Override
    public String commandName() {
        return "Show salary developers ";
    }

    @Override
    public String description() {
        return "show salary developers on project";
    }

    @Override
    public void process() {
        super.getTotalSalaryDevelopersByProject ();
    }
}

