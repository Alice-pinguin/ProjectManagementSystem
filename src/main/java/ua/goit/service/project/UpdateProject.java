package ua.goit.service.project;

import ua.goit.model.Project;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

import java.util.Date;
import java.util.Optional;

public class UpdateProject implements Command {

    private final View view;
    private CrudRepository<Project, Long> projectRepository;

    public UpdateProject(View view, CrudRepository<Project, Long> projectRepository) {
        this.view = view;
        projectRepository = RepositoryFactory.of (Project.class);
    }

    @Override
    public String commandName() {
        return "Update project";
    }

    @Override
    public void process() {
        view.write("Enter a project id");
        Long id = Long.valueOf (view.read());
        Optional<Project> project = projectRepository.findById (id);
        if (project.isEmpty ())
            throw new IllegalArgumentException("Project with id %d not exist");;

        view.write("Enter a project name");
        String name = view.read();
        view.write("Enter a project field");
        String field = view.read();
        view.write("Enter a project date in format 'yyyy-mm-dd'");
        String date = view.read ();
        view.write("Enter a project cost");
        Long cost = Long.valueOf (view.read());

        project.get ().setName (name);
        project.get ().setField (field);
        project.get ().setCreateDate (date);
        project.get ().setCost (cost);
        projectRepository.update(project.get ());
        view.write("Project updated");

    }
}
