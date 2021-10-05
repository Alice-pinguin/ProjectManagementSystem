package ua.goit.service.query;

import ua.goit.repository.QueryExecutorImpl;
import ua.goit.view.Command;
import ua.goit.view.View;

public class FindDevelopersByLevel implements Command {

    private final View view;
    private QueryExecutorImpl queryExecutor;

    public FindDevelopersByLevel(View view, QueryExecutorImpl queryExecutor) {
        this.view = view;
        this.queryExecutor = new QueryExecutorImpl ();
    }

    @Override
    public String commandName() {
        return "Find all developers by level";
    }

    @Override
    public void process() {
        view.write("Choose level");
        String level  = view.read();
        queryExecutor.getDeveloperByLevel (level);
    }
}