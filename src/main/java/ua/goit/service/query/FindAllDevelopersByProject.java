package ua.goit.service.query;

import ua.goit.repository.QueryExecutorImpl;
import ua.goit.view.Command;
import ua.goit.view.View;

public class FindAllDevelopersByProject implements Command {
    private final View view;
    private QueryExecutorImpl queryExecutor;

    public FindAllDevelopersByProject(View view, QueryExecutorImpl queryExecutor) {
        this.view = view;
        this.queryExecutor = new QueryExecutorImpl ();
    }

    @Override
    public String commandName() {
        return "Find all developers by project ID";
    }

    @Override
    public void process() {
        view.write("Enter project ID");
        Long id  = Long.valueOf (view.read());
        System.out.println (queryExecutor.getListOfDevelopersFromProject (id));
    }
}

