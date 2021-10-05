package ua.goit.controller;


import ua.goit.model.*;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.QueryExecutorImpl;
import ua.goit.repository.RepositoryFactory;
import ua.goit.service.company.*;
import ua.goit.service.customer.*;
import ua.goit.service.developer.*;
import ua.goit.service.project.*;
import ua.goit.service.query.*;
import ua.goit.view.Command;
import ua.goit.view.Console;
import ua.goit.view.View;
import java.util.Arrays;
import java.util.List;

public class ConsoleController {
    private View view;
    private List<Command> commands;
    private QueryExecutorImpl queryExecutor = new QueryExecutorImpl ();
    private  CrudRepository<Developer, Long> developerRepository = RepositoryFactory.of (Developer.class);
    private  CrudRepository<Company, Long> companyRepository = RepositoryFactory.of (Company.class);
    private  CrudRepository<Project, Long> projectRepository = RepositoryFactory.of (Project.class);
    private  CrudRepository<Skill,Long> skillRepository = RepositoryFactory.of (Skill.class);
    private  CrudRepository<DeveloperProject, Long> developerProjectRepository = RepositoryFactory.of (DeveloperProject.class);
    private  CrudRepository<DeveloperSkill, Long> developerSkillRepository = RepositoryFactory.of (DeveloperSkill.class);
    private  CrudRepository<Customer, Long> customerRepository = RepositoryFactory.of (Customer.class);

    public ConsoleController() {
        this.view = new Console ();
        this.commands = Arrays.asList (
                new CreateCompany (view,  companyRepository),
                new CreateCustomer (view, customerRepository),
                new CreateDeveloper (view, developerRepository),
                new CreateProject (view, projectRepository),
                new FindByIdCompany (view, companyRepository),
                new FindByIdCustomer (view,  customerRepository),
                new FindByIdDeveloper (view, developerRepository),
                new FindByIdProject (view, projectRepository),
                new FindAllCompany (view, companyRepository),
                new FindAllCustomers (view, customerRepository),
                new FindAllDevelopers (view, developerRepository),
                new FindAllProjects (view, projectRepository),
                new UpdateCompany (view, companyRepository),
                new UpdateCustomer (view, customerRepository),
                new UpdateDeveloper (view, developerRepository),
                new UpdateProject (view, projectRepository),
                new DeleteCompany (view, companyRepository),
                new DeleteCustomer (view, customerRepository),
                new DeleteDeveloper (view, developerRepository),
                new DeleteProject (view, projectRepository),
                new TotalSalaryByProject (view,queryExecutor),
                new FindAllDevelopersByProject (view, queryExecutor),
                new ProjectByDateAndDev (view, queryExecutor),
                new FindDevelopersByLanguage (view, queryExecutor),
                new FindDevelopersByLevel (view, queryExecutor));

    }

    public void run() {

        view.write ("Welcome to database JDBC application");
        while (true) {
            view.write ("\nPlease, enter the command from list or 'Exit'  to exit application\n");
            commands.forEach (x -> view.write (x.commandName ()));
            String input = view.read ();
            if (input.equalsIgnoreCase ("Q"))
                break;
            doCommand (input);
        }
    }

    private void doCommand(String input) {

        for (Command command : commands)
            if (command.canProcess (input)) {
                command.process ();
                break;
            }

    }
}


