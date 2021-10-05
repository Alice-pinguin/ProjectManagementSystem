package ua.goit.service.project;

import ua.goit.model.Project;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

import java.util.Optional;

public class DeleteProject implements Command {

    private final View view;
    private CrudRepository<Project, Long> projectRepository;

    public DeleteProject(View view, CrudRepository<Project, Long> projectRepository) {
        this.view = view;
        projectRepository = RepositoryFactory.of (Project.class);
    }

    @Override
    public String commandName() {
        return "Delete project";
    }

    @Override
    public void process() {

        view.write("Enter a project id");
        Long id = Long.valueOf (view.read());
        Optional<Project> project = projectRepository.findById (id);
        if (project.isEmpty ())
            throw new IllegalArgumentException("Project with id %d not exist");

        projectRepository.deleteById (id);
        view.write("Project deleted");
    }
}
