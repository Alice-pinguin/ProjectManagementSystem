package ua.goit.service.commands;

import ua.goit.model.BaseEntity;
import ua.goit.repository.QueryExecutor;
import ua.goit.repository.QueryExecutorImpl;
import ua.goit.view.View;
import java.util.List;
import java.util.Map;

public abstract class QueryCommand<E extends BaseEntity<ID>, ID> implements Command {

    protected final View view;
    protected final Map<String, Command> commands;
    protected  QueryExecutor<E, ID> queryExecutor  = new QueryExecutorImpl ();

    public QueryCommand(View view, Map<String, Command> commands) {
        this.view = view;
        this.commands = commands;

        }

    protected void getTotalSalaryDevelopersByProject () {
            view.write ("Enter ID");
            Long id = Long.valueOf (view.read ());
            List result = queryExecutor.getTotalSalaryDevelopersByProject (id);
            sendResult (!result.isEmpty (), result);
        }
   protected void getDevelopersBySkill () {
            view.write ("Enter the programming language skill");
            String skill = view.read ();
            List result = queryExecutor.getDevelopersBySkill (skill);
            sendResult (!result.isEmpty (), result);

        }
   protected void getDevelopersByLevel () {
            view.write ("Enter the level");
            String level = view.read ();
            List result = queryExecutor.getDevelopersBySkill (level);
            sendResult (!result.isEmpty (), result);

        }
   protected void getProjectWithCountDevAndDate () {
            view.write ("Enter ID");
            Long id = Long.valueOf (view.read ());
            List result = queryExecutor.projectWithCountDevAndDate (id);
            sendResult (!result.isEmpty (), result);
        }
  protected void getListOfDevelopersFromProject () {
            view.write ("Enter ID");
            Long id = Long.valueOf (view.read ());
            List result = queryExecutor.getListOfDevelopersFromProject (id);
            sendResult (!result.isEmpty (), result);
        }

   private void sendResult (Boolean isDone, Object...result){
            if (isDone) view.write (String.valueOf (result));
            else view.write ("Sorry, for your request doesn't find any entity");
        }

   private void sendResult (Boolean isDone, List result){
            sendResult (isDone, result.toArray ());
        }

    }
