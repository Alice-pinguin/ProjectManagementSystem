package ua.goit.service.developer;

import ua.goit.model.Developer;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

import java.util.Optional;

public class DeleteDeveloper implements Command {

    private final View view;
    private CrudRepository<Developer, Long> developerRepository;

    public DeleteDeveloper(View view, CrudRepository<Developer, Long> developerRepository) {
        this.view = view;
        developerRepository = RepositoryFactory.of (Developer.class);
    }

    @Override
    public String commandName() {
        return "Delete developer";
    }

    @Override
    public void process() {

        view.write("Enter a developer id");
        Long id = Long.valueOf (view.read());
        Optional<Developer> developer = developerRepository.findById (id);

        if (developer.isEmpty ())
            throw new IllegalArgumentException(String.format("Developer with id %d not exist"));

        developerRepository.deleteById (id);
        view.write("Developer deleted");
    }
}
