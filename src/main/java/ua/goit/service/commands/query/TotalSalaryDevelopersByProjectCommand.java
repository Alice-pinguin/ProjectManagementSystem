package ua.goit.service.commands.query;

import ua.goit.service.commands.Command;
import ua.goit.service.commands.QueryCommand;
import ua.goit.view.View;

import java.util.Map;

public class TotalSalaryDevelopersByProjectCommand extends QueryCommand {

    public TotalSalaryDevelopersByProjectCommand(View view, Map<String, Command> commands) {
        super (view, commands);
    }

    @Override
    public String commandName() {
        return "total_salary_developers";
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

