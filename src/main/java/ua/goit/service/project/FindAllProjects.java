package ua.goit.service.project;

import ua.goit.model.Project;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

public class FindAllProjects implements Command {
    private final View view;
    private CrudRepository<Project, Long> projectRepository;

    public FindAllProjects(View view, CrudRepository<Project, Long> projectRepository) {
        this.view = view;
        projectRepository = RepositoryFactory.of (Project.class);
    }

    @Override
    public String commandName() {
        return "Find all projects";
    }

    @Override
    public void process() {
        System.out.println (projectRepository.findAll ());
    }
}
