package ua.goit.service.project;

import ua.goit.model.Project;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

public class CreateProject implements Command {

    private final View view;
    private CrudRepository<Project, Long> projectRepository;

    public CreateProject(View view, CrudRepository<Project, Long> projectRepository) {
        this.view = view;
        projectRepository = RepositoryFactory.of (Project.class);
    }

    @Override
    public String commandName() {
        return "Create project";
    }

    @Override
    public void process() {

        view.write("Enter project name");
        String name = view.read();
        view.write("Enter project field age");
        String field = view.read ();
        view.write("Enter project cost");
        Long cost = Long.valueOf(view.read());
        view.write("Enter a project date in format 'yyyy-mm-dd'");
        String date = view.read ();

        Project project = new Project ();
        project.setName (name);
        project.setField (field);
        project.setCost (cost);
        project.setCreateDate (date);
        projectRepository.create(project);
        view.write("Project created");
    }
}
