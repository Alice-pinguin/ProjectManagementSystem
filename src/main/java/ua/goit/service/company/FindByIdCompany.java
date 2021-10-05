package ua.goit.service.company;

import ua.goit.model.Company;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

import java.util.Optional;

public class FindByIdCompany implements Command {

    private final View view;
    private CrudRepository<Company, Long> companyRepository;

    public FindByIdCompany(View view, CrudRepository<Company, Long> companyRepository) {
        this.view = view;
        companyRepository = RepositoryFactory.of (Company.class);
    }

    @Override
    public String commandName() {
        return "Find by ID company";
    }

    @Override
    public void process() {

        view.write ("Enter a company id");
        Long id = Long.valueOf (view.read ());
        Optional<Company> company = companyRepository.findById (id);
        view.write (company.toString ()
        );
        if (company.isEmpty ()) {
            throw new IllegalArgumentException (String.format ("Company with id %d not exist"));
        }
    }
}
