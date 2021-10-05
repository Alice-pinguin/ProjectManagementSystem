package ua.goit.service.developer;

import ua.goit.model.Developer;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

public class FindAllDevelopers implements Command {
    private final View view;
    private CrudRepository<Developer, Long> developerRepository;

    public FindAllDevelopers(View view, CrudRepository<Developer, Long> developerRepository) {
        this.view = view;
        developerRepository = RepositoryFactory.of (Developer.class);
    }

    @Override
    public String commandName() {
        return "Find all developers";
    }

    @Override
    public void process() {
        developerRepository.findAll ();

    }
}
