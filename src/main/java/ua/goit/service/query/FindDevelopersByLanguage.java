package ua.goit.service.query;

import ua.goit.repository.QueryExecutorImpl;
import ua.goit.view.Command;
import ua.goit.view.View;

public class FindDevelopersByLanguage implements Command {

    private final View view;
    private QueryExecutorImpl queryExecutor;

    public FindDevelopersByLanguage(View view, QueryExecutorImpl queryExecutor) {
        this.view = view;
        this.queryExecutor = new QueryExecutorImpl ();
    }

    @Override
    public String commandName() {
        return "Find all developers by language";
    }

    @Override
    public void process() {
            view.write("Choose languade");
            String skill  = view.read();
        System.out.println (queryExecutor.getDevelopersBySkill (skill));
    }
}
