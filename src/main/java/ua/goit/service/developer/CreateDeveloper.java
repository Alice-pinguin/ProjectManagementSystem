package ua.goit.service.developer;

import ua.goit.model.Developer;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

public class CreateDeveloper implements Command {

    private final View view;
    private CrudRepository<Developer, Long> developerRepository;

    public CreateDeveloper(View view, CrudRepository<Developer, Long> developerRepository) {
        this.view = view;
        developerRepository = RepositoryFactory.of (Developer.class);
    }

    @Override
    public String commandName() {
        return "Create developer";
    }

    @Override
    public void process() {

        view.write("Enter a developer name");
        String name = view.read();
        view.write("Enter a developer age");
        Integer age = Integer.parseInt(view.read());
        view.write("Enter developer gender");
        String gender = view.read();
        view.write("Enter developer salary");
        Long salary = Long.valueOf(view.read());

        Developer developer = new Developer();
        developer.setName (name);
        developer.setAge(age);
        developer.setGender(gender);
        developer.setSalary(salary);
        developerRepository.create(developer);
        view.write("Developer created");

    }
}
