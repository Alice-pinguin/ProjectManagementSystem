package ua.goit.service.query;

import ua.goit.repository.QueryExecutorImpl;
import ua.goit.view.Command;
import ua.goit.view.View;

public class TotalSalaryByProject implements Command {

    private final View view;
    private QueryExecutorImpl queryExecutor;

    public TotalSalaryByProject(View view, QueryExecutorImpl queryExecutor) {
        this.view = view;
        this.queryExecutor = new QueryExecutorImpl ();
    }

    @Override
    public String commandName() {
        return "Find total salary developers";
    }

    @Override
    public void process() {
        view.write("Enter project ID");
        Long id  = Long.valueOf (view.read());
        queryExecutor.getTotalSalaryDevelopersByProject (id);

    }
}
