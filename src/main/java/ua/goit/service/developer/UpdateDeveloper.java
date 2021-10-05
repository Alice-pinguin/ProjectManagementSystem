package ua.goit.service.developer;

import ua.goit.model.Developer;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

import java.util.Optional;

public class UpdateDeveloper implements Command {

    private final View view;
    private CrudRepository<Developer, Long> developerRepository;

    public UpdateDeveloper(View view, CrudRepository<Developer, Long> developerRepository) {
        this.view = view;
        developerRepository = RepositoryFactory.of (Developer.class);
    }

    @Override
    public String commandName() {
        return "Update developer";
    }

    @Override
    public void process() {

        view.write("Enter a developer id");
        Long id = Long.valueOf (view.read());
        Optional<Developer> developer = developerRepository.findById (id);

        if (developer.isEmpty ())
            throw new IllegalArgumentException("Developer with id %d not exist");

        view.write("Enter developer name");
        String name = view.read();
        view.write("Enter developer age");
        Integer age = Integer.parseInt(view.read());
        view.write("Enter developer gender");
        String gender = view.read();
        view.write("Enter developer salary");
        Long salary = Long.valueOf (view.read());

        developer.get().setName(name);
        developer.get ().setAge (age);
        developer.get ().setGender (gender);
        developer.get ().setSalary (salary);
        developerRepository.update(developer.get ());
        view.write("Developer updated");
    }
}
