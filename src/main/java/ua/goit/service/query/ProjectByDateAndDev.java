package ua.goit.service.query;

import ua.goit.repository.QueryExecutorImpl;
import ua.goit.view.Command;
import ua.goit.view.View;

public class ProjectByDateAndDev implements Command {

    private final View view;
    private QueryExecutorImpl queryExecutor;

    public ProjectByDateAndDev(View view, QueryExecutorImpl queryExecutor) {
        this.view = view;
        this.queryExecutor = new QueryExecutorImpl ();
    }

    @Override
    public String commandName() {
        return "Project with date and developers";
    }

    @Override
    public void process() {
        System.out.println (queryExecutor.projectWithCountDevAndDate ());
    }
}
