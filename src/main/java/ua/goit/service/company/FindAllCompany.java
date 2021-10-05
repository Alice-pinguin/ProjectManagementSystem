package ua.goit.service.company;

import ua.goit.model.Company;
import ua.goit.repository.CrudRepository;
import ua.goit.repository.RepositoryFactory;
import ua.goit.view.Command;
import ua.goit.view.View;

public class FindAllCompany implements Command {

    private final View view;
    private CrudRepository<Company, Long> companyRepository;

    public FindAllCompany(View view, CrudRepository<Company, Long> companyRepository) {
        this.view = view;
        companyRepository = RepositoryFactory.of (Company.class);
    }

    @Override
    public String commandName() {
        return "Find all companies";
    }

    @Override
    public void process() {

        System.out.println(companyRepository.findAll ());
    }
}
