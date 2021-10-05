package ua.goit.service.project;

import ua.goit.model.Project;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

import java.util.Optional;

public class FindByIdProject implements Command {
    private final View view;
    private CrudRepository<Project, Long> projectRepository;

    public FindByIdProject(View view, CrudRepository<Project, Long> projectRepository) {
        this.view = view;
        projectRepository = RepositoryFactory.of (Project.class);
    }

    @Override
    public String commandName() {
        return "Find by ID project";
    }

    @Override
    public void process() {
        view.write("Enter a project id");
        Long id = Long.valueOf (view.read());
        Optional<Project> project = projectRepository.findById (id);
        if (project.isEmpty ())
            throw new IllegalArgumentException("Project with id %d not exist");

        view.write(project.toString());
    }
}
